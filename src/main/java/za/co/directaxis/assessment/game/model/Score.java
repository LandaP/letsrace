package za.co.directaxis.assessment.game.model;

import za.co.directaxis.assessment.game.util.Consts;

/**
 * Immutable value class which encapsulates items
 * related to a score.
 *
 * <P>All permitted values are specified by the constructor.
 */
public class Score  implements Comparable<Score>{
    private Car car;
    private Integer score;

    public Score(Car aCar, Integer aScore){
        this.car = aCar;
        this.score = aScore;
    }

    public Car getCar() {
        return car;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getCar().getModel());
        sb.append(Consts.SPACE);
        sb.append(this.getScore());
        sb.append(Consts.NEW_LINE);
        return sb.toString();
    }

    @Override
    public int compareTo(Score o) {
        return this.getScore().compareTo(o.getScore());
    }
}
