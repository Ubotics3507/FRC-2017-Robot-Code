package org.usfirst.frc.team3507.robot;

import org.usfirst.frc.team3507.robot.commands.ClimberRun;
import org.usfirst.frc.team3507.robot.commands.ElevatorRun;
import org.usfirst.frc.team3507.robot.commands.FlywheelAdjust;
import org.usfirst.frc.team3507.robot.commands.FlywheelRun;
import org.usfirst.frc.team3507.robot.commands.FlywheelSet;
import org.usfirst.frc.team3507.robot.commands.ToggleHighGear;
import org.usfirst.frc.team3507.robot.commands.ToggleHopper;
import org.usfirst.frc.team3507.robot.util.XboxControllerButtons;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public XboxControllerButtons driver = new XboxControllerButtons(RobotMap.driver);
	public XboxControllerButtons operator = new XboxControllerButtons(RobotMap.operator);
	
	public OI() {
//		driver.leftBumper.whileHeld(new IntakeArmRun(true));
//		driver.rightBumper.whileHeld(new IntakeArmRun(false));
//		driver.y.whileHeld(new IntakeRollerRun());
		driver.a.whenPressed(new ToggleHighGear());
		driver.b.whenPressed(new ToggleHopper());
		driver.rightTrigger.whileHeld(new ClimberRun());
		
		operator.y.whenPressed(new FlywheelAdjust(false));
		operator.a.whenPressed(new FlywheelAdjust(true));
		operator.x.whenPressed(new FlywheelSet());
		operator.leftTrigger.whileHeld(new FlywheelRun());
		operator.rightTrigger.whileHeld(new ElevatorRun());
	}
	
}

