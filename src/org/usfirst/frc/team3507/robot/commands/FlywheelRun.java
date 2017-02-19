package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class FlywheelRun extends Command {
	
	public FlywheelRun () {
		requires(Robot.flywheel);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void execute() {
		Robot.flywheel.flywheel.setP(Robot.prefs.getDouble("FlywheelP", 0));
		Robot.flywheel.flywheel.setI(Robot.prefs.getDouble("FlywheelI", 0));
		Robot.flywheel.flywheel.setD(Robot.prefs.getDouble("FlywheelD", 0));
		Robot.flywheel.flywheel.setF(Robot.prefs.getDouble("FlywheelF", 0));
		Robot.flywheel.go();
	}
	
	protected void end() {
		Robot.flywheel.stop();
	}
	
	protected void interrupted() {
		end();
	}
	
}
