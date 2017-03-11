package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearIntake extends Subsystem {

	private boolean up = true;
	
	private DoubleSolenoid hopperSolenoid = new DoubleSolenoid(RobotMap.hopperSolenoidA, RobotMap.hopperSolenoidB);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void toggleGearIntakeArm() {
		up = !up;
		if (up) {
			hopperSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else {
			hopperSolenoid.set(DoubleSolenoid.Value.kForward);
		}
		
	}
	
	public void setHopper(boolean up) {
		this.up = up;
		if (up) {
			hopperSolenoid.set(DoubleSolenoid.Value.kForward);
		} else {
			hopperSolenoid.set(DoubleSolenoid.Value.kReverse);
		}
	}
}