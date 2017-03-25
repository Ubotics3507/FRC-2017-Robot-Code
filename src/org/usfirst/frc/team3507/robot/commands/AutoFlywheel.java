package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoFlywheel extends InstantCommand {

	Preferences prefs = Preferences.getInstance();
	
	private boolean stop;
	private double speed;
	
	public AutoFlywheel(boolean stop) {
		this.stop = stop;
	}
	
//protected void initialize() {
//		
//		Robot.flywheelSpeed.getSelected();
//	}
//	
	protected void execute() {
		if (stop) {
			Robot.flywheel.stop();
		} else {
			//Robot.flywheel.PIDgo();
			//Robot.flywheel.go();
			Robot.flywheel.dashboardAutoSpeed();//1550
			//Robot.flywheel.outer_Side_speed();//1800
			//Robot.flywheel.middle_Side_speed();//1650
			
			
		}
	}
	
}
