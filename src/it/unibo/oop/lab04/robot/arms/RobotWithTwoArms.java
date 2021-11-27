package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms{
    
    BasicArm leftArm;
    BasicArm rightArm;

    public RobotWithTwoArms(String robotName) {
        super(robotName);
        leftArm = new BasicArm("leftArm");
        rightArm = new BasicArm("rightArm");
    }

    public boolean pickUp() {
        if(leftArm.isGrabbing() && rightArm.isGrabbing()) {
            return false;
        }else {
            if(!rightArm.isGrabbing()) {
                rightArm.pickUp();
            }else {
                leftArm.pickUp();
            }
            return true;
        }
    }

    public boolean dropDown() {
        if(leftArm.isGrabbing()) {
            leftArm.dropDown();
            return true;
        }
        if(rightArm.isGrabbing()) {
            rightArm.dropDown();
            return true;
        }
        return false;
    }

    @Override
    public int getCarriedItemsCount() {
        return (leftArm.isGrabbing() ? 1 : 0) + (rightArm.isGrabbing() ? 1 : 0);
    }

}
