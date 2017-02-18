package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeElevator extends Command {

	Preferences prefs = Preferences.getInstance(); 
	
	public IntakeElevator(double speed) {
		requires(Robot.elevator);
		
	}
	protected void execute() {
		Robot.elevator.ElevatorIntake.setP(prefs.getDouble("ElevatorP", 0));
		Robot.elevator.ElevatorIntake.setI(prefs.getDouble("ElevatorI", 0));
		Robot.elevator.ElevatorIntake.setD(prefs.getDouble("ElevatorD", 0));
		Robot.elevator.ElevatorIntake.setF(prefs.getDouble("ElevatorF", 0));
		Robot.flywheel.go(prefs.getDouble("Elevator Speed", .5));
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
