package za.co.directaxis.assessment.game.model;

import za.co.directaxis.assessment.game.util.Consts;

public class Car {
    private String model;
    private int acceleration;
    private int braking;
    private int corneringAbility;
    private int topSpeed;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getBraking() {
        return braking;
    }

    public void setBraking(int braking) {
        this.braking = braking;
    }

    public int getCorneringAbility() {
        return corneringAbility;
    }

    public void setCorneringAbility(int corneringAbility) {
        this.corneringAbility = corneringAbility;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getModel());
        sb.append(Consts.TAB);
        sb.append("  Acceleration: " + this.getAcceleration());
        sb.append("  Braking: " + this.getBraking());
        sb.append("  Cornering: " + this.getCorneringAbility());
        sb.append("  Top Speed: " + this.getTopSpeed());
        sb.append(Consts.NEW_LINE);
		return sb.toString();
    }
}
