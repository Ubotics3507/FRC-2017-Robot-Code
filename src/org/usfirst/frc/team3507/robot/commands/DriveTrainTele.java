package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.RobotUtil;
import org.usfirst.frc.team3507.robot.OI;
import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.subsystems.PracticeDriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTrainTele extends Command {
	static double speedL;
	static double speedR;
	static double deadzone = 0.1;
	public DriveTrainTele() {
    	super("DriveTrainTele");
        requires(Robot.drivetrain);
    }
	protected void initialize() {
		
	}
	
	protected void execute() {
		double JAxisLeft;
		double JAxisRight;
		
		JAxisRight = Robot.drivetrain.go(Robot.oi.driver.getRawAxis(4), Robot.oi.driver.getRawAxis(1));
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
	
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		
	}
	protected void interrupted() {
		
	}
}
