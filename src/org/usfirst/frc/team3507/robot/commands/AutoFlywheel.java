package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class AutoFlywheel extends InstantCommand {

	Preferences prefs = Preferences.getInstance();
	
	public AutoFlywheel(boolean stop) {
		if (stop) {
			Robot.flywheel.stop();
		}
	}
	
	protected void execute() {
		Robot.flywheel.go(prefs.getDouble("Auto Flywheel Speed", 0.5));
	}
	
}
