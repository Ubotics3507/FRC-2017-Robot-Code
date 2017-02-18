package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ElevatorIntake extends Subsystem {

	public com.ctre.CANTalon ElevatorIntake = new com.ctre.CANTalon(RobotMap.elevatorMotor);
	
	public CANTalon elevator = new CANTalon(RobotMap.elevatorMotor);
	
	public ElevatorIntake() {
		elevator.enableBrakeMode(true);
		elevator.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		elevator.reverseSensor(true);
		elevator.changeControlMode(TalonControlMode.Speed);
		elevator.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	double speed;
	
	public void go(double speed)
    {
    	if (speed > 0) {
    		//ElevatorIntake.set(-.7);
    	}
    	else stop();
    }
	
    public void stop()
    {
    	ElevatorIntake.set(0);
    }
}
