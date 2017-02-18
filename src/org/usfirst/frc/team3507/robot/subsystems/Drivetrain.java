package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;
import org.usfirst.frc.team3507.robot.commands.DriveTrainTele;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private DoubleSolenoid driveSolenoid = new DoubleSolenoid(RobotMap.driveSolenoidA, RobotMap.driveSolenoidB);

	private RobotDrive robotDrive;
	
	private boolean highGear = false;
	
	//Sets all drivetrain Talons to named IDs
	public CANTalon leftSlave = new CANTalon(RobotMap.leftSlave);
    public CANTalon rightSlave = new CANTalon(RobotMap.rightSlave);
    public CANTalon leftSlave2 = new CANTalon(RobotMap.leftSlave2);
    public CANTalon rightSlave2 = new CANTalon(RobotMap.rightSlave2);
    public CANTalon leftMaster = new CANTalon(RobotMap.leftMaster);
    public CANTalon rightMaster = new CANTalon(RobotMap.rightMaster);
    
	public Drivetrain() {
		
		configureTalon(leftMaster, TalonControlMode.PercentVbus, 0);
		configureTalon(leftSlave, TalonControlMode.Follower, RobotMap.leftMaster);
		configureTalon(leftSlave2, TalonControlMode.Follower, RobotMap.leftMaster);
		configureTalon(rightMaster, TalonControlMode.PercentVbus, 0);
		configureTalon(rightSlave, TalonControlMode.Follower, RobotMap.rightMaster);
		configureTalon(rightSlave2, TalonControlMode.Follower, RobotMap.rightMaster);

    	leftSlave.reverseOutput(true);
    	leftSlave2.reverseOutput(true);
    	rightSlave.reverseOutput(true);
    	rightSlave2.reverseOutput(true);
    	
    	leftMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	
    	robotDrive = new RobotDrive(leftMaster, rightMaster);
    	robotDrive.setSafetyEnabled(false);
    }
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveTrainTele());
	}
	
	public void stop() {
		leftMaster.set(0);
		rightMaster.set(0);
	}
	
	public void arcadeDrive(double move, double rotate) {
		robotDrive.arcadeDrive(move, rotate, true);
	}
	
	public void tankDrive(double left, double right) {
		robotDrive.tankDrive(left, right, true);
	}
	
	private void configureTalon(CANTalon talon, TalonControlMode mode, double initialValue) {
		talon.changeControlMode(mode);
		talon.set(initialValue);
		talon.enableBrakeMode(false);
		
	}
	
	public void toggleHighGear() {
		highGear = !highGear;
		if (highGear = !highGear) {
			driveSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else {
			driveSolenoid.set(DoubleSolenoid.Value.kForward);
		}
	}
	
	public void setHighGear(boolean highGear) {
		this.highGear = highGear;
		if (this.highGear == !highGear) {
			driveSolenoid.set(DoubleSolenoid.Value.kForward);
		} else {
			driveSolenoid.set(DoubleSolenoid.Value.kReverse);
			
			
		}
	}
	
}
	