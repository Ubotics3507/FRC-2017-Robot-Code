package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class RollerIntake extends Command{


	Preferences prefs = Preferences.getInstance();
	
	boolean reverse;
	
	public RollerIntake(boolean reverse) {
		this.reverse = reverse;
		requires(Robot.Intake);
		
	}
		
	protected void execute() {
		if (reverse) {
			Robot.Intake.go(prefs.getDouble("Roller Speed", .75));
		} else if(!reverse) {
			Robot.Intake.go(prefs.getDouble("Reverse Roller Speed", -.75));
		}
		
	}
	@Override
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
