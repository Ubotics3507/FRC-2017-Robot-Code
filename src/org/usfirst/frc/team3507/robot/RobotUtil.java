package org.usfirst.frc.team3507.robot;

public class RobotUtil {
	
	public static double deadzone(double side, double dead) {
		double square;
		if (side > dead || side < -dead) {
    		square = ((side-(Math.abs(side)/side*dead))/(1-dead));
    		if (square < 0) {
    			return -square * square;
    		} else {
    			return square * square;
    		}
    	} else {
    		return 0.0;
    	}
	}

}
