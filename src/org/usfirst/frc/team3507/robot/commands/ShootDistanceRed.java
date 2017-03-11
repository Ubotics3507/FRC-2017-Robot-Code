package org.usfirst.frc.team3507.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootDistanceRed extends CommandGroup {
	public ShootDistanceRed() {
		//addSequential(new AutoDistance(30000));
		addSequential(new AutoShootCommand());
		addSequential(new AutoDistance(-5000));
    	addSequential(new TurnAround(180, 3));
		addSequential(new AutoDriveTime(2, .6, .6));
    	//addSequential(new Delay(1));
	}
}