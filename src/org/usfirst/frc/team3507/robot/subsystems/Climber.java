package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	public CANTalon climber = new CANTalon(RobotMap.climberMotor);

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void go(double speed) {
		climber.set(speed);
	}

	
	public void stop() {
		climber.set(0);
	}
}
