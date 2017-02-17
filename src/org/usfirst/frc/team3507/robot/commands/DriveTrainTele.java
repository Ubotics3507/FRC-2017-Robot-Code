package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.RobotUtil;

import org.usfirst.frc.team3507.robot.OI;
import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainTele extends Command {
	
	private double speedL;
	private double speedR;
	
	static double deadzone = 0.1;
	public DriveTrainTele() {
    	super("DriveTrainTele");
        requires(Robot.drivetrain);
    }
	protected void initialize() {
		
	}
	
	protected void execute() {
		double jAxisRight;
		double jAxisLeft;
		
		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getRawAxis(4), deadzone);
		jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getRawAxis(1), deadzone);
		
		arcade(jAxisRight, jAxisLeft);
		
		Robot.drivetrain.go(speedR, speedL);
		//Robot.drivetrain.go(RobotUtil.deadzone(Robot.oi.driver.getRawAxis(5), deadzone), RobotUtil.deadzone(Robot.oi.driver.getRawAxis(1), deadzone));
	}
	
	//public void execute() {
		/*speedR = Robot.drivetrain.go(, left); //same as below
		speedL = XboxController2017.leftStick.getRawAxis(); //need to define axis in parameters
		if(speedL > deadzone || speedR > deadzone) {
			PracticeDriveTrain.go(speedL, speedR);
		}
		else {
			PracticeDriveTrain.stop();
		} 
	} */
	
	public void arcade(double jR, double jL) {					//Check this and below
    	double max;
    	double sum;
    	double dif;
    	
    	max = Math.abs(jR);
    	if (Math.abs(jL) > max) max = Math.abs(jL);
    	sum = jR + jL;
    	dif = jR - jL;
    	
    	if (jL <= 0) {
    		if (jR >= 0) {
    			speedL = max;
    			speedR = -sum;
    		} else {
    			speedL = dif;
    			speedR = max;
    		}
    	} else {
    		if (jR >= 0) {
    			speedL = dif;
    			speedR = -max;
    		} else {
    			speedL = -max;
    			speedR = -sum;
    		}
    	}
    }																// Check this and above
	
	
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		
	}
	protected void interrupted() {
		
	}
}
