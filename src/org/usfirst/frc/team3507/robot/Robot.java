
package org.usfirst.frc.team3507.robot;
import org.usfirst.frc.team3507.robot.RobotUtil;


import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3507.robot.commands.ExampleCommand;
import org.usfirst.frc.team3507.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3507.robot.subsystems.PracticeDriveTrain;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3507.robot.commands.DriveTrainTele;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final PracticeDriveTrain drivetrain = new PracticeDriveTrain();
	public static OI oi;
	
	public double speedL;
	public double speedR;
	
	static double deadzone = .01;

    Command autonomousCommand;
    SendableChooser<ExampleCommand> chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI(0);
        chooser = new SendableChooser<ExampleCommand>();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //Scheduler.getInstance().run();
    	double jAxisRight;
		double jAxisLeft;
		
		jAxisRight = RobotUtil.deadzone(Robot.oi.driver.getRawAxis(4), deadzone);
		jAxisLeft = RobotUtil.deadzone(Robot.oi.driver.getRawAxis(1), deadzone);
		
		arcade(jAxisRight, jAxisLeft);
		
		Robot.drivetrain.go(speedR, speedL);
    	//Robot.drivetrain.go(Robot.oi.driver.getRawAxis(5), Robot.oi.driver.getRawAxis(1));
    	//Robot.drivetrain.go(RobotUtil.deadzone(Robot.oi.driver.getRawAxis(4), deadzone), RobotUtil.deadzone(Robot.oi.driver.getRawAxis(5), deadzone));
    	//Robot.drivetrain.go(RobotUtil.deadzone(Robot.oi.driver.getRawAxis(0), deadzone), RobotUtil.deadzone(Robot.oi.driver.getRawAxis(1), deadzone));
    }
    
    public void arcade(double jR, double jL) {
    	double max;
    	double sum;
    	double dif;
    	
    	max = Math.abs(jR);
    	if (Math.abs(jL) > max) max = Math.abs(jL);
    	sum = jR + jL;
    	dif = jR - jL;
    	
    	if (jL <= 0) {
    		if (jR >= 0) {
    			speedL = max;
    			speedR = -sum;
    		} else {
    			speedL = dif;
    			speedR = max;
    		}
    	} else {
    		if (jR >= 0) {
    			speedL = dif;
    			speedR = -max;
    		} else {
    			speedL = -max;
    			speedR = -sum;
    		}
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
