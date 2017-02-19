package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class FlywheelAdjust extends InstantCommand {
	
	Preferences prefs = Preferences.getInstance();
	
	boolean backwards;
	
	public FlywheelAdjust(boolean backwards) {
		this.backwards = backwards;
	}

	protected void execute() {
		if (!backwards) {
			Robot.flywheel.changeSpeed(prefs.getDouble("Flywheel Adjust", 100));
		} else {
			Robot.flywheel.changeSpeed(prefs.getDouble("Flywheel Adjust", -100));
		}
	}
	
}
