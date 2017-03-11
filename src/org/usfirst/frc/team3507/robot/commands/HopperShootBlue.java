package org.usfirst.frc.team3507.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HopperShootBlue extends CommandGroup{
	public HopperShootBlue() {
		//addSequential(new AutoDistance(-30000));
		addSequential(new AutoDriveTime(1, .70, .7));
		addSequential(new Delay(1));
		addSequential(new TurnAround(-85, 2));
		addSequential(new AutoDriveTime(2, .5, .5));
		addSequential(new TurnAround(10, 1));
		//addSequential(new AutoDriveTime(1, .75, .75));
		addParallel(new AutoShootCommand());
		
	}
}
