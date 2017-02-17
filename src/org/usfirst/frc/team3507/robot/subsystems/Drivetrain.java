package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;

import org.usfirst.frc.team3507.robot.commands.DriveTrainTele;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	

	private RobotDrive robotDrive;
	
	public CANTalon leftSlave = new CANTalon(RobotMap.leftSlave);
    public CANTalon rightSlave = new CANTalon(RobotMap.rightSlave);
    public CANTalon leftSlave2 = new CANTalon(RobotMap.leftSlave2);
    public CANTalon rightSlave2 = new CANTalon(RobotMap.rightSlave2);
    public CANTalon leftMaster = new CANTalon(RobotMap.leftMaster);
    public CANTalon rightMaster = new CANTalon(RobotMap.rightMaster);
    
	public Drivetrain() {
		
		configureTalon(leftMaster, TalonControlMode.PercentVbus, 0);
		configureTalon(leftSlave, TalonControlMode.Follower, RobotMap.leftSlave);
		configureTalon(leftSlave2, TalonControlMode.Follower, RobotMap.leftSlave2);
		configureTalon(rightMaster, TalonControlMode.PercentVbus, 0);
		configureTalon(rightSlave, TalonControlMode.Follower, RobotMap.rightSlave);
		configureTalon(rightSlave2, TalonControlMode.Follower, RobotMap.rightSlave2);
		
    	rightSlave.enableBrakeMode(true);
    	leftSlave.enableBrakeMode(true);
    	rightSlave2.enableBrakeMode(true);
    	leftSlave2.enableBrakeMode(true);
    	rightMaster.enableBrakeMode(true);
    	leftMaster.enableBrakeMode(true);

    	leftSlave.set(RobotMap.leftMaster);
    	leftSlave.reverseOutput(true);
    	leftSlave2.set(RobotMap.leftMaster);
    	leftSlave2.reverseOutput(true);
    	rightSlave.set(RobotMap.rightMaster);
    	rightSlave.reverseOutput(true);
    	rightSlave2.set(RobotMap.rightMaster);
    	rightSlave2.reverseOutput(true);
    	rightMaster.setInverted(true);
    	
    	leftMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	
    	robotDrive = new RobotDrive(leftMaster, rightMaster);
    	robotDrive.setSafetyEnabled(false);
    }
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveTrainTele());
	}
	
	public void go(double right, double left) {
		leftMaster.set(left);
		rightMaster.set(right);
	}
	
	public void stop() {
		leftMaster.set(0);
		rightMaster.set(0);
	}
	
	public void arcadeDrive(double move, double rotate) {
		robotDrive.arcadeDrive(move, rotate);
	}
	
	public void tankDrive(double left, double right) {
		robotDrive.tankDrive(left, right);
	}
	
	private void configureTalon(CANTalon talon, TalonControlMode mode, double initialValue) {
		talon.changeControlMode(mode);
		talon.set(initialValue);
		talon.enableBrakeMode(false);
		
	}
	
}
	