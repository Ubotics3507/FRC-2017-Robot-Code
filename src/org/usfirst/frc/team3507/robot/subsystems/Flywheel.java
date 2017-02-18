package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flywheel extends Subsystem {

	public static CANTalon flywheel = new CANTalon(RobotMap.shooterMotor);
	
	public Flywheel() {
		flywheel.enableBrakeMode(true);
		flywheel.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void go(double speed) {
		flywheel.set(speed);
	}
	
	public void stop() {
		flywheel.set(0);
	}
	
	public double getSpeed() {
		return flywheel.getSpeed();
	}

}
