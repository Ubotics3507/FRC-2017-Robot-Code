package org.usfirst.frc.team3507.robot.util;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboxControllerButtons extends XboxController {

	public Button a, b, x, y, leftBumper, rightBumper, back, start, leftStick,
			rightStick, leftTrigger, rightTrigger;

	public XboxControllerButtons(int port) {
		super(port);
		
		a = new JoystickButton(this, 1);
		b = new JoystickButton(this, 2);
		x = new JoystickButton(this, 3);
		y = new JoystickButton(this, 4);
		leftBumper = new JoystickButton(this, 5);
		rightBumper = new JoystickButton(this, 6);
		back = new JoystickButton(this, 7);
		start = new JoystickButton(this, 8);
		leftStick = new JoystickButton(this, 9);
		rightStick = new JoystickButton(this, 10);
		
		leftTrigger = new AnalogButton(this, 2);
		rightTrigger = new AnalogButton(this, 3);
	}

}
