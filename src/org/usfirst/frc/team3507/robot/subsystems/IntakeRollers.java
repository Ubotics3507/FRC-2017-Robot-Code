package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeRollers extends Subsystem {

	
	public com.ctre.CANTalon motor = new com.ctre.CANTalon(RobotMap.intakeMotor);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	public IntakeRollers() {
		motor.enableBrakeMode(false);
		
	}
	
    public void go(double speed) {
    	motor.set(speed);
    }
    
    public void stop() {
    	motor.set(0);
    }
}


