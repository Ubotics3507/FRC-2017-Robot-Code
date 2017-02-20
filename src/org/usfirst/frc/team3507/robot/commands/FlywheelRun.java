package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class FlywheelRun extends Command {
	
	Preferences prefs = Preferences.getInstance();	
	
	public FlywheelRun () {
		requires(Robot.flywheel);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void execute() {
		Robot.flywheel.flywheel.setP(prefs.getDouble("FlywheelP", 0));
		Robot.flywheel.flywheel.setI(prefs.getDouble("FlywheelI", 0));
		Robot.flywheel.flywheel.setD(prefs.getDouble("FlywheelD", 0));
		Robot.flywheel.flywheel.setF(prefs.getDouble("FlywheelF", 0));
		Robot.flywheel.go();
	}
	
	protected void end() {
		Robot.flywheel.stop();
	}
	
	protected void interrupted() {
		end();
	}
	
}
