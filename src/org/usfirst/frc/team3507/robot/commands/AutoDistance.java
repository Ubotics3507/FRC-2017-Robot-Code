package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDistance extends Command {
	
	private double distance;
	
	private double tolerance;
	
	public AutoDistance(double distance) {
		requires(Robot.drivetrain);
		Preferences prefs = Preferences.getInstance();
		
		this.distance = distance;
		this.tolerance = prefs.getDouble("tolerance", 10);
	}
	
	protected void initialize() {
		
		Robot.drivetrain.leftMaster.setPosition(0);
		Robot.drivetrain.rightMaster.setPosition(0);
	}
	
	protected void execute() {
		Preferences prefs = Preferences.getInstance();
		Robot.drivetrain.leftMaster.changeControlMode(TalonControlMode.Position);
		Robot.drivetrain.rightMaster.changeControlMode(TalonControlMode.Position);
//		Robot.drivetrain.leftMaster().enableControl();
//		Robot.drivetrain.rightMaster().enableControl();
		
		Robot.drivetrain.leftMaster.setPID(prefs.getDouble("AutoDriveP", 0.2), 0, 0);
		Robot.drivetrain.rightMaster.setPID(prefs.getDouble("AutoDriveP", 0.2), 0, 0);
		
		Robot.drivetrain.leftMaster.set(distance);
		Robot.drivetrain.rightMaster.set(-distance);
		//Robot.drivetrain.go(rightSpeed, leftSpeed);
	}
	
	@Override
	protected boolean isFinished() {
		double leftError = Math.abs(distance - Robot.drivetrain.leftMaster.get());
    	double rightError = Math.abs(-distance - Robot.drivetrain.rightMaster.get());
    	SmartDashboard.putNumber("Left Error", Robot.drivetrain.leftMaster.getError());
    	SmartDashboard.putNumber("Right Error", Robot.drivetrain.rightMaster.getError());
        return leftError < tolerance 
        		&& rightError < tolerance;
	}
	
	protected void end(){
		Robot.drivetrain.leftMaster.changeControlMode(TalonControlMode.PercentVbus);
		Robot.drivetrain.rightMaster.changeControlMode(TalonControlMode.PercentVbus);
	}


	
	
}
