package za.co.directaxis.assessment.game;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * Starter/launcher class for application.
 *
 */
public class App {

    /**
     * Application entry point.
     *
     * @param args application command line arguments
     */
    public static void main(String[] args) {
        
            RaceApp msp = new RaceApp();
            msp.run(args);
        
    }
}
