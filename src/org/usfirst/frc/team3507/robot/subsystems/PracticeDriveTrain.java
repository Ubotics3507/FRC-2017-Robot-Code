package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.RobotMap;
import org.usfirst.frc.team3507.robot.commands.DriveTrainTele;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PracticeDriveTrain extends Subsystem {
	
	public com.ctre.CANTalon leftSlave = new com.ctre.CANTalon(RobotMap.leftSlave);
    public com.ctre.CANTalon rightSlave = new com.ctre.CANTalon(RobotMap.rightSlave);
    public com.ctre.CANTalon leftSlave2 = new com.ctre.CANTalon(RobotMap.leftSlave2);
    public com.ctre.CANTalon rightSlave2 = new com.ctre.CANTalon(RobotMap.rightSlave2);
    public com.ctre.CANTalon leftMaster = new com.ctre.CANTalon(RobotMap.leftMaster);
    public com.ctre.CANTalon rightMaster = new com.ctre.CANTalon(RobotMap.rightMaster);
    
	public PracticeDriveTrain() {
    	rightSlave.enableBrakeMode(true);
    	leftSlave.enableBrakeMode(true);
    	rightSlave2.enableBrakeMode(true);
    	leftSlave2.enableBrakeMode(true);
    	rightMaster.enableBrakeMode(true);
    	leftMaster.enableBrakeMode(true);
    	
    	leftSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
    	leftSlave.set(RobotMap.leftMaster);
    	leftSlave.reverseOutput(true);
    	leftSlave2.changeControlMode(CANTalon.TalonControlMode.Follower);
    	leftSlave2.set(RobotMap.leftMaster);
    	leftSlave2.reverseOutput(true);
    	rightSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
    	rightSlave.set(RobotMap.rightMaster);
    	rightSlave.reverseOutput(true);
    	rightSlave2.changeControlMode(CANTalon.TalonControlMode.Follower);
    	rightSlave2.set(RobotMap.rightMaster);
    	rightSlave2.reverseOutput(true);
    	rightMaster.setInverted(true);
    	
    	leftMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
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
}