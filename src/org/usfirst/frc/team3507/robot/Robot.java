
package org.usfirst.frc.team3507.robot;
import org.usfirst.frc.team3507.robot.commands.AutoDistance;
import org.usfirst.frc.team3507.robot.commands.AutoDriveTime;
import org.usfirst.frc.team3507.robot.commands.AutoShootCommand;
import org.usfirst.frc.team3507.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3507.robot.subsystems.ElevatorIntake;
import org.usfirst.frc.team3507.robot.subsystems.Flywheel;
import org.usfirst.frc.team3507.robot.subsystems.Hopper;
import org.usfirst.frc.team3507.robot.subsystems.IntakeArm;
import org.usfirst.frc.team3507.robot.subsystems.IntakeRollers;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	// Velocity - 2500 / 60 
	
	Compressor mainCompressor = new Compressor(0);
	public static final Hopper hopper = new Hopper();
	public static final Flywheel flywheel = new Flywheel();
	public static final ElevatorIntake elevator = new ElevatorIntake();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final IntakeRollers Intake = new IntakeRollers();
	public static final IntakeArm Arm = new IntakeArm();
	public static OI oi;
	
	public AutoDriveTime auton;

    Command autonomousCommand;
    
   public static SendableChooser auto;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		auto= new SendableChooser();
		auto.addObject("Auto Drive Only ", new AutoDriveTime(4,0.5,0.5));
		auto.addDefault("PID Straight ", new AutoDistance(10));
		auto.addObject("Shoot", new AutoShootCommand());
		SmartDashboard.putData("Auto mode", auto);
        
        SmartDashboard.putData(Scheduler.getInstance());
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
    	
//      autonomousCommand = (Command) chooser.getSelected();
//      Command autoCommand = (Command) auto.getSelected();
//    	autoCommand.start();
//    	auto.int();
//    	AutoDriveTime test = new AutoDriveTime(5,0.5,0.5);
//    	test.execute();
    	AutoShootCommand test = new AutoShootCommand();
    	test.start();
    	
 
    	
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
      //  if (autonomousCommand != null) autonomousCommand.start();
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
        Scheduler.getInstance().run();
        
		SmartDashboard.putNumber("Left", Robot.drivetrain.leftMaster.getSpeed());
		SmartDashboard.putNumber("Right", Robot.drivetrain.rightMaster.getSpeed());
		SmartDashboard.putNumber("PositionL", Robot.drivetrain.leftMaster.getPosition());
		SmartDashboard.putNumber("PositionR", Robot.drivetrain.rightMaster.getPosition());
		SmartDashboard.putNumber("Flywheel Speed", Robot.flywheel.getSpeed());
		SmartDashboard.putData("Compressor", mainCompressor);
    }
    
     
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
