package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class AutoElevator extends InstantCommand {
	
	Preferences prefs = Preferences.getInstance();
	
	private boolean stop;
	
	public AutoElevator(boolean stop) {
		this.stop = stop;
	}
	
	protected void execute() {
		if (stop) {
			Robot.elevator.stop();
		} else {
			Robot.elevator.go(prefs.getDouble("Auto Elevator Speed", 0.7));
		}
		
	}
	
}
