package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorIntake extends Subsystem {

	public CANTalon elevator = new CANTalon(RobotMap.elevatorMotor);
	
	public ElevatorIntake() {
		elevator.enableBrakeMode(true);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void go(double speed) {
    	elevator.set(speed);
    }
	
    public void stop() {
    	elevator.set(0);
    }
}
