package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class Rollers extends InstantCommand{
	
	private double speed;
	
	public void execute(double speed) {
		Robot.Intake.go(speed);
	}
}
