package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Flywheel extends Subsystem {

	public CANTalon flywheel = new CANTalon(RobotMap.shooterMotor);
	
	private double speed;
	
	public Flywheel() {
		flywheel.enableBrakeMode(true);
		flywheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		flywheel.reverseSensor(true);
		flywheel.changeControlMode(TalonControlMode.Speed);
		flywheel.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub    
		
	}
	
	public void go() {
		flywheel.set(speed);
	}
	
	public double flywheelSpeed() {
		return speed;
	}
	
	public void stop() {  
		flywheel.set(0);
	}
	
	public double getSpeed() {
		return flywheel.getSpeed();
	}
	
	public void changeSpeed(double change) {
		speed += change;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
