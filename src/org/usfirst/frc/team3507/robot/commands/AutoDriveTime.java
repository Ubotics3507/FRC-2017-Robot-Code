package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveTime extends Command{
	
	private double leftSpeed;
	private double rightSpeed;
	
	public AutoDriveTime(int sec, double lspd, double rspd) {
		requires(Robot.drivetrain);
		setTimeout(sec);
		rightSpeed = rspd;
		leftSpeed = lspd;
	}
	
	public void init() {
		//Robot.drivetrain.res
	}
	
	public void execute() {
		Robot.drivetrain.arcadeDrive(rightSpeed, leftSpeed);
	}
	
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	protected void end() {
		Robot.drivetrain.stop();
	}
	
	protected void interrupted() {
		end();
	}

}
