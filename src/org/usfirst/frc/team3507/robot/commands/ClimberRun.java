package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class ClimberRun extends Command {

	Preferences prefs = Preferences.getInstance();
	
	public ClimberRun() {
		requires(Robot.climber);
		
	}
	protected void execute() {
		Robot.climber.go(prefs.getDouble("Climber Speed", .5));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		Robot.climber.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
