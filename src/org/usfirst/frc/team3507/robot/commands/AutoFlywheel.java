package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class AutoFlywheel extends InstantCommand {

	Preferences prefs = Preferences.getInstance();
	
	private boolean stop;
	
	public AutoFlywheel(boolean stop) {
		this.stop = stop;
	}
	
	protected void execute() {
		if (stop) {
			Robot.flywheel.stop();
		} else {
			Robot.flywheel.go();
		}
		
	}
	
}
