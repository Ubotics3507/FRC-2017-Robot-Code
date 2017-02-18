package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.RobotUtil;


import org.usfirst.frc.team3507.robot.OI;
import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrainTele extends Command {
	
	static double deadzone = 0.1;
	
	double jAxisRight;
	double jAxisLeft;
	
	public static SendableChooser<DriveControlType> tele;
	
	public DriveTrainTele() {
    	super("DriveTrainTele");
        requires(Robot.drivetrain);
        
        tele = new SendableChooser<>();
    	tele.addDefault("Arcade Mode", DriveControlType.ARCADE);
    	tele.addObject("Tank Mode", DriveControlType.TANK);
    	tele.addObject("Arcade Split", DriveControlType.ARCADE_SPLIT);
    	tele.addObject("Paralyze", DriveControlType.PARALYZE);
    	SmartDashboard.putData("Drivetrain", tele);

    }
	
	private enum DriveControlType {
		ARCADE,
		TANK,
		ARCADE_SPLIT,
		PARALYZE
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
    	DriveControlType controlType = tele.getSelected();
    	switch(controlType) {
    	case ARCADE_SPLIT:
    		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getX(Hand.kRight), deadzone);
        	jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kLeft), deadzone);
        	Robot.drivetrain.arcadeDrive(jAxisLeft, jAxisRight);
    	case TANK:
    		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kRight), deadzone);
        	jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kLeft), deadzone);
        	Robot.drivetrain.tankDrive(jAxisRight, jAxisLeft);
    	case ARCADE:
    		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getX(Hand.kLeft), deadzone);
    		jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kLeft), deadzone);
    		Robot.drivetrain.arcadeDrive(jAxisLeft, jAxisRight);
    	case PARALYZE:
    		Robot.drivetrain.stop();
    		break;
    	}
	}
	protected boolean isFinished() {
		return false;
	}
	protected void end() {
		
	}
	protected void interrupted() {
		
	}
}
