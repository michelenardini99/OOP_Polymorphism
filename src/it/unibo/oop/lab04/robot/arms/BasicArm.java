package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
    
    private static final double ENERGY_REQUIRED_TO_MOVE = 0.2;
    private static final double ENERGY_REQUIRED_TO_GRAB = 0.1;
    
    private final String name;
    private boolean grabbing;

    public BasicArm(String name) {
        super();
        this.name = name;
        this.grabbing=false;
    }
    
    public boolean isGrabbing() {
        return this.grabbing;
    }
    
    public void pickUp() {
        this.grabbing=true;
    }
    
    public void dropDown() {
        this.grabbing = false;
    }
    
    public double getConsuptionForPickUp() {
        return BasicArm.ENERGY_REQUIRED_TO_GRAB+BasicArm.ENERGY_REQUIRED_TO_MOVE;
    }
    
    public double getConsuptionForDropDown() {
        return BasicArm.ENERGY_REQUIRED_TO_MOVE;
    }
    
    public String toString() {
        return this.name;
    }

}
