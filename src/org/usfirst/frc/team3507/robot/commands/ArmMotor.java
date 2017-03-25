package org.usfirst.frc.team3507.robot.commands;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotUtil;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;



public class ArmMotor extends Command{
 
	static double deadzone = 0.05; 
		
	Preferences prefs = Preferences.getInstance();
		
	boolean reverse;
		
	public ArmMotor() {
		requires(Robot.Arm);
			
	}
			
	protected void execute() {
		double value = -RobotUtil.deadzone(Robot.oi.operator.getY(Hand.kLeft), deadzone);
		
		
		if (value < 0) {
			Robot.Arm.go(-value*value*.5);
		} else {
			Robot.Arm.go(value*value);
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
		}

		protected void end() {
			Robot.Arm.stop();
		}
		
		protected void interrupted() {
			end();
		}

}
