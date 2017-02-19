package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FlywheelSet extends InstantCommand {

	protected void execute() {
		Robot.flywheel.setSpeed(Robot.prefs.getDouble("Default Flywheel Speed", 0.5));
	}
}
