package za.co.directaxis.assessment.game;

//import org.apache.commons.cli.*;
//import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.cli.*;
import org.apache.commons.math3.stat.StatUtils;

import za.co.directaxis.assessment.game.model.Car;
import za.co.directaxis.assessment.game.model.Score;
import za.co.directaxis.assessment.game.repository.CarDAO;
import za.co.directaxis.assessment.game.util.Consts;
import za.co.directaxis.assessment.game.util.Util;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


/**
 * RaceApp is a simple console application which computes
 * race scores for a list of cars for specific race track. The application takes
 * a string value (-c) representing the  number of races to run,  as its single argument.
 *
 */
public class RaceApp {

    private static final Logger fLogger = Util.getLogger(RaceApp.class);
	
	private final List<Car> carList;
	
	public RaceApp(){
		super();
		
		this.carList = initDbRetrieve();
	}

    /**
     * Runs the application
     *
     * @param args an array of String arguments to be parsed
     */
    public void run(String[] args) {
        Console console = System.console();
        if(carList.isEmpty()){
            console.printf("%s","The car database table is empty. Load some data and try again.");
            System.exit(1);
        }

        console.printf("%s%n %s%n", "The following cars will be in the race:", carList);

        CommandLine line = parseArguments(args);

        if (line.hasOption("race_count")) {

            int race_count = Integer.parseInt(line.getOptionValue("race_count"));

            for(int i=1; i <= race_count; i++){
                String track = console.readLine("Enter the track to use: ");
                if(!Util.textHasContent(track)){
                    //TODO
                }

                calculateAndPrintScores(carList, track);
            }

        } else {
            printAppHelp();
        }
    }

    /**
     * Makes a call to
     * @return
     */
    private List<Car> initDbRetrieve(){
        List<Car> result = new ArrayList<Car>();
		fLogger.info("Retrieving the application data ...");
		CarDAO dao = new CarDAO();
		result = dao.getAllCars();
		
		return result;
    }

    private void calculateAndPrintScores(List<Car> cars, String track){
        int straightCount = findCount(Consts.ONE, track);
        int cornerCount = findCount(Consts.ZERO, track);

        List<Score> raceResultList = new ArrayList<Score>();

        for(Car aCar : cars){
            int straightScore = calculateCarScore(aCar, straightCount, Consts.ONE);
            int cornerScore = calculateCarScore(aCar, cornerCount, Consts.ZERO);

            Integer raceScore = straightScore+cornerScore;
            Score aScore = new Score(aCar,raceScore);
            raceResultList.add(aScore);
        }

        Comparator<Score> scoreComparator = (s1, s2) -> (int) (s1.getScore() - s2.getScore());
		raceResultList.sort(Collections.reverseOrder(scoreComparator));

        Console console = System.console();
		console.printf("%s%n", "Race Results: ");

        for(Score aScore : raceResultList){
            int position = raceResultList.indexOf(aScore)+1;
            console.printf("%s %s%n", Util.ordinal(position), aScore);
        }
    }

    private int calculateCarScore(Car c, int count, char indicator){
        int score = 0;
        //on straight(1) only add Acceleration and TopSpeed
        //on corner(0) only add Braking and Cornering

        switch(indicator){
            case Consts.ONE:
                score = (c.getAcceleration()*count) + (c.getTopSpeed()*count);
                break;
            case Consts.ZERO:
                score = (c.getBraking()*count) + (c.getCorneringAbility()*count);
                break;
        }

        return score;
    }

    /**
     * Returns the number of times a digit, value exists in a string
     * @param aNumber
     * @param track
     * @return
     */
    public int findCount(char aNumber, String track){

        int op = 0;
        int count = 0;
        for(int i = 0;i<track.length();i++)
        {
            if(track.charAt(i) == aNumber){
                count++;
            }
        }

        return count;
    }

    /**
     * Parses application arguments
     *
     * @param args
     * @return <code>CommandLine</code> which represents a list of application
     * arguments.
     */
    private CommandLine parseArguments(String[] args) {

        Options options = getOptions();
        CommandLine line = null;

        CommandLineParser parser = new DefaultParser();

        try {

            line = parser.parse(options, args);

        } catch (Exception ex) {

            System.err.println(ex);
            printAppHelp();

            System.exit(1);
        }

        return line;
    }

    /**
     * Generates application command line options
     *
     * @return application <code>Options</code>
     */
    private Options getOptions() {

        Options options = new Options();

        options.addOption("c", "race_count", true,
                "number of races to run");

        return options;
    }

    /**
     * Prints application help
     */
    private void printAppHelp() {

        Options options = getOptions();

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("RaceApp", options, true);
    }
}
