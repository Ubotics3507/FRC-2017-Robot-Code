package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Autonomous extends Command{
	
	private double leftSpeed;
	private double rightSpeed;
	

	static final double auton_rF = 0.0;
	static final double auto_rP = 0.0;
	static final double auton_rI = 0.0;
	static final double auton_rD = 0.0;
	
	static final double auton_lF = 0.0;
	static final double auton_lP = 0.0;
	static final double auton_lI = 0.0;
	static final double auton_lD = 0.0;
	
	public Autonomous(int sec, double lspd, double rspd) {
		requires(Robot.drivetrain);
		setTimeout(sec);
		rightSpeed = rspd;
		leftSpeed = lspd;
		

		
	}
	
	public void init() {
		//Robot.drivetrain.res
	}
	
	public void execute() {
		Robot.drivetrain.go(rightSpeed, leftSpeed);
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
