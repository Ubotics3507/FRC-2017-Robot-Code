package org.usfirst.frc.team3507.robot.subsystems;

import org.usfirst.frc.team3507.robot.Robot;
import org.usfirst.frc.team3507.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	
	public com.ctre.CANTalon motor = new com.ctre.CANTalon(RobotMap.intakeMotor);
	
	boolean mainIntake;
	boolean mainIntake2;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public DigitalInput btn1;
	public DigitalInput btn2;
	
	public Intake() 
	{
		motor.enableBrakeMode(false);
    	btn1 =  new DigitalInput(0);
    	btn2 = new DigitalInput(1);
	}
	
    public void go(boolean speed)
    {
    	mainIntake = Robot.oi.driver.getAButton();
    	mainIntake2 = Robot.oi.driver.getXButton();
    	if (mainIntake == true && mainIntake2 == false) {
    		motor.set(.5);
    	}
    	else if (mainIntake2 == true && mainIntake == false) {
    		motor.set(-.5);
    	}
    	else stop();
    }
    
    public void stop()
    {
    	motor.set(0);
    }
}


