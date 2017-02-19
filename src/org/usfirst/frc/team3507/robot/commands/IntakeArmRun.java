package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeArmRun extends Command{
	
	public boolean reverse;
	
	public IntakeArmRun(boolean reverse) {
		requires(Robot.arm);
		this.reverse = reverse;
	}
	
	protected void execute() {
		if (reverse == false) {
			Robot.arm.go(Robot.prefs.getDouble("Intake Speed", .5));
		} else {
			Robot.arm.go(-Robot.prefs.getDouble("Intake Speed", .5));
		}
	}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		Robot.arm.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
