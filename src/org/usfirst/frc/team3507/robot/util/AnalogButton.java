package org.usfirst.frc.team3507.robot.util;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

public class AnalogButton extends Button {

	private GenericHID joystick;
	private int axis;
	
	public AnalogButton(GenericHID joystick, int axis) {
		this.joystick = joystick;
		this.axis = axis;
		
	}
	@Override
	public boolean get() {
		return joystick.getRawAxis(axis) > 0.1;
	}
	

}
