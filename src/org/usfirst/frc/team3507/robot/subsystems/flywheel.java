package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class flywheel extends Subsystem {

	public static CANTalon flywheel = new CANTalon(RobotMap.shooterMotor);
	
	public flywheel() {
		flywheel.enableBrakeMode(true);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void go(double speed) {
		if (speed > 0) {
			flywheel.set(0.7);
		}
		else stop();
		
	}
	
	public void stop() {
		flywheel.set(0);
	}

}
