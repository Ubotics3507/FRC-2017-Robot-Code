package org.usfirst.frc.team3507.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootDistanceRed extends CommandGroup {
	public ShootDistanceRed() {
		/*
		 * RED Eleminations
		 */
		addSequential(new AutoShootCommand());
		addSequential(new AutoDriveTime(1, -.15, -.15));;
		addSequential(new TurnAround(45, 2));
		//addSequential(new AutoDistance(-10000));
		addSequential(new AutoDriveTime(2, -.65, -.65));
    	addSequential(new TurnAround(70, 3));
		
		
		/*
		 * RED 
		 */
		
//		//addSequential(new AutoDistance(30000));
//		//addSequential(new AutoShootCommand());
//		addSequential(new AutoDistance(-5000));
//		addSequential(new TurnAround(75, 1));
//		addSequential(new AutoDistance(-10000));
//    	addSequential(new TurnAround(70, 2));
//		addSequential(new AutoDriveTime(2, .65, .65));
//    	//addSequential(new Delay(1));
	}
}