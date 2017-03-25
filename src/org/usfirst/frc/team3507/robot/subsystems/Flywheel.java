package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flywheel extends Subsystem {
public CANTalon flywheel = new CANTalon(RobotMap.shooterMotor);
	
	private static double speed;//wasnt always static
	//private double P, I, D, F;
	//Preferences prefs = Preferences.getInstance();	
	public Flywheel() {
		flywheel.enableBrakeMode(true);
		flywheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		flywheel.reverseSensor(true);
		flywheel.changeControlMode(TalonControlMode.Speed);
		flywheel.set(0);
		
		//speed = 1650;// middle
		//speed= 1550; //left side blue alliance(near boiler)
		//speed = 1800; // right side
		speed =2000; // defualt
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub    
		
	}
	
	public void go() {
		flywheel.set(speed);
	}
	
//	public void PIDgo() {
//		flywheel.setF(0.01);
//		flywheel.setP(0.1);
//		flywheel.setI(0);
//		flywheel.setD(0);
//		flywheel.set(speed);
//	}
//	
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
	
	public void middle_Side_speed() {
		flywheel.set(1650); //1650
		flywheel.setF(0.097);
		flywheel.setP(0.097);
		//flywheel.setI(0);
		flywheel.setD(0);
	}
	
	public void outer_Side_speed() {
		flywheel.set(1800);
	}
	
	public void inner_Side_speed() {
		flywheel.set(1550);
		flywheel.setF(0.097);
		flywheel.setP(0.091);
		//flywheel.setI(0);
		flywheel.setD(0);
	}
	
	public void point_blank_speed() {
		flywheel.set(1450);
		flywheel.setF(0.097);
		flywheel.setP(0.091);
		//flywheel.setI(0);
		flywheel.setD(0);
		
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void dashboardAutoSpeed() {
		switch(Robot.flywheelSpeed.getSelected()){
		case 0: outer_Side_speed(); break;
		case 1: middle_Side_speed();break;
		case 2: inner_Side_speed(); break;	
		case 3: point_blank_speed(); break; 
		
		}
	}
}
