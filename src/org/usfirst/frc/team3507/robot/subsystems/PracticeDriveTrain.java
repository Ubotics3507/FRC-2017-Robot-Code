package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;
import org.usfirst.frc.team3507.robot.commands.DriveTrainTele;
//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PracticeDriveTrain extends Subsystem {
	public com.ctre.CANTalon leftWheel = new com.ctre.CANTalon(RobotMap.left);
    public com.ctre.CANTalon rightWheel = new com.ctre.CANTalon(RobotMap.right);
    private boolean inverted = false;
	public PracticeDriveTrain() {
    	rightWheel.setInverted(true);
    	rightWheel.enableBrakeMode(true);
    	leftWheel.enableBrakeMode(true);
    }
	public void initDefaultCommand() {
		setDefaultCommand(new DriveTrainTele());
	}
	public void go(double right, double left) {
		leftWheel.set(left);
		rightWheel.set(right);
	}
	public void stop() {
		leftWheel.set(0);
		rightWheel.set(0);
	}
	public void direction_change() {
		inverted = !inverted;
		leftWheel.setInverted(inverted);
		rightWheel.setInverted(!inverted);
	}
}