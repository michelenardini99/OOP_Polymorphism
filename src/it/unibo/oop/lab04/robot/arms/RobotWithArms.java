package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

public interface RobotWithArms extends Robot{
    
    /**
     * @return true if the action is successful
     */
    boolean pickUp();
    
    /**
     * @return true if the action is successful
     */
    boolean dropDown();
    
    /**
     * @return the number of objects this robot is currently transporting
     */
    int getCarriedItemsCount();
    
}
