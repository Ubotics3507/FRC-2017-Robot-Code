
package org.usfirst.frc.team3507.robot;
import org.usfirst.frc.team3507.robot.RobotUtil;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3507.robot.commands.ExampleCommand;
import org.usfirst.frc.team3507.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3507.robot.subsystems.ElevatorIntake;
import org.usfirst.frc.team3507.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3507.robot.subsystems.Flywheel;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3507.robot.commands.AutoDistance;
import org.usfirst.frc.team3507.robot.commands.Autonomous;
import org.usfirst.frc.team3507.robot.commands.DriveTrainTele;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Compressor mainCompressor = new Compressor(0);
	public static final Flywheel flywheel = new Flywheel();
	public static final ElevatorIntake elevator = new ElevatorIntake();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final org.usfirst.frc.team3507.robot.subsystems.Intake Intake = new org.usfirst.frc.team3507.robot.subsystems.Intake();
	public static OI oi;
	
	public double speedL;
	public double speedR;
	
	public Autonomous auton;
	
	static double deadzone = .09;

    Command autonomousCommand;
   // SendableChooser<ExampleCommand> chooser;
   public static SendableChooser auto;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		//auto = new Autonomous(6,0.5,0.5)
		
		auto= new SendableChooser();
		auto.addObject("Auto Drive Only ", new Autonomous(4,0.5,0.5));
		auto.addDefault("PID Straight ", new AutoDistance(10));
		SmartDashboard.putData("Auto mode", auto);
		
		
		
//		
//		tele = new SendableChooser();
//        //chooser.addDefault("Default tELE", new ExampleCommand());
//        tele.addDefault("Tele Option", object);
////        chooser.addObject("My Auto", new MyAutoCommand());
//        SmartDashboard.putData("Tele", tele);
        
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
    	
//        autonomousCommand = (Command) chooser.getSelected();
        Command autoCommand = (Command) auto.getSelected();
    	autoCommand.start();
    	//auto.int();
    	Autonomous test = new Autonomous(5,0.5,0.5);
    	test.execute();
    	
 
    	
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
		
		/*Robot.elevator.go(elevatorSpeed);
		Robot.flywheel.go(flywheelSpeed);
		Robot.Intake.go(mainIntake || mainIntake2); */
		
		
		SmartDashboard.putNumber("Left", Robot.drivetrain.leftMaster.getSpeed());
		SmartDashboard.putNumber("Right", Robot.drivetrain.rightMaster.getSpeed());
		SmartDashboard.putNumber("Flywheel Speed", Robot.flywheel.getSpeed());
    }
    
     
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
