package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;
import org.usfirst.frc.team3507.robot.commands.ArmMotor;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeArm extends Subsystem{

public com.ctre.CANTalon motor2 = new com.ctre.CANTalon(RobotMap.armMotor);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmMotor());
		// TODO Auto-generated method stub
	}

	public IntakeArm() {
		motor2.enableBrakeMode(true);
		
	}
	
    public void go(double speed) {
    	motor2.set(speed);
    }
    
    public void stop() {
    	motor2.set(0);
    }
	
}
