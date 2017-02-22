package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotUtil;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrainTele extends Command {
	
	static double deadzone = 0.05;
	
	double jAxisRight;
	double jAxisLeft;
	
	public static SendableChooser<DriveControlType> tele;
	
	Preferences prefs = Preferences.getInstance();
	
	public DriveTrainTele() {
    	super("DriveTrainTele");
        requires(Robot.drivetrain);
        
        tele = new SendableChooser<>();
    	tele.addObject("Arcade Mode", DriveControlType.ARCADE);
    	tele.addObject("Tank Mode", DriveControlType.TANK);
    	tele.addDefault("Arcade Split", DriveControlType.ARCADE_SPLIT);
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
//    		jAxisRight += prefs.getDouble("Drivetrain right arcade multiplier", 0);
        	jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kLeft), deadzone);
        	Robot.drivetrain.arcadeDrive(jAxisLeft, jAxisRight);
        	break;
    	case TANK:
    		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kRight), deadzone);
        	jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kLeft), deadzone);
//        	if(jAxis)
//        	jAxisLeft *= prefs.getDouble("Drivetrain right tank multiplier", 1);
        	Robot.drivetrain.tankDrive(jAxisRight, jAxisLeft);
        	break;
    	case ARCADE:
    		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getX(Hand.kLeft), deadzone);
    		jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getY(Hand.kLeft), deadzone);
    		Robot.drivetrain.arcadeDrive(jAxisLeft, jAxisRight);
    		break;
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
