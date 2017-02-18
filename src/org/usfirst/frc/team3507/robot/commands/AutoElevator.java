package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class AutoElevator extends InstantCommand {
	
	Preferences prefs = Preferences.getInstance();
	

	protected void execute() {
		Robot.elevator.go(prefs.getDouble("Auto Elevator Speed", 0.7));
	}
	
}
