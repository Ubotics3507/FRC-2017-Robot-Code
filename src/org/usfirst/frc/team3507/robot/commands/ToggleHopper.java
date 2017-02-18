package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ToggleHopper extends InstantCommand {
	
	protected void execute() {
		Robot.hopper.toggleHopper();
	}

}
