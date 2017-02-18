package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeArmRun extends Command{

	Preferences prefs = Preferences.getInstance();
	
	public boolean reverse;
	
	public IntakeArmRun(boolean reverse) {
		requires(Robot.Arm);
		this.reverse = reverse;
	}
	
	protected void execute() {
		if (reverse == false) {
			Robot.Arm.go(prefs.getDouble("Intake Speed", .5));
		} else {
			Robot.Arm.go(-prefs.getDouble("Intake Speed", .5));
		}
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		Robot.Arm.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
