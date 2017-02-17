package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorIntake extends Subsystem {

	public com.ctre.CANTalon ElevatorIntake = new com.ctre.CANTalon(RobotMap.elevatorMotor);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	double speed;
	
	public ElevatorIntake() {
		//this.speed = speed;
	}
	
	public void go(double speed)
    {
    	if (speed > 0) {
    		ElevatorIntake.set(-.7);
    	}
    	else stop();
    }
    
    public void stop()
    {
    	ElevatorIntake.set(0);
    }
}
