package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorRun extends Command {

	Preferences prefs = Preferences.getInstance(); 
	
	public ElevatorRun() {
		requires(Robot.elevator);
		
	}
	protected void execute() {
		if (Robot.oi.operator.getTrigger(Hand.kRight)) {
			Robot.elevator.go(prefs.getDouble("Elevator Speed", .5));
		} else if(Robot.oi.operator.getBumper(Hand.kRight)) {
			Robot.elevator.go(prefs.getDouble("Reverse Elevator Speed", -.5));
		}
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		Robot.elevator.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
