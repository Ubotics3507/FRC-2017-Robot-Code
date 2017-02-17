package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeElevator extends Command {

	
	public IntakeElevator(double speed) {
		requires(Robot.elevator);
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
