package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeRollerRun extends Command {

	Preferences prefs = Preferences.getInstance();
	
	public IntakeRollerRun() {
		requires(Robot.Intake);
	}
	
	protected void execute() {
		Robot.Intake.go(prefs.getDouble("Intake Speed", .5));
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		Robot.Intake.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
