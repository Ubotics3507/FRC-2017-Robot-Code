package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {

	private boolean up = true;
	
	private Solenoid hopperSolenoid = new Solenoid(RobotMap.hopperSolenoid);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void toggleHopper() {
		up = !up;
		hopperSolenoid.set(up);
	}
	
	public void setHopper(boolean up) {
		this.up = up;
		hopperSolenoid.set(up);
	}
}