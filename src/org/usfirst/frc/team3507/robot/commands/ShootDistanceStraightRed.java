package org.usfirst.frc.team3507.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootDistanceStraightRed extends CommandGroup {

    public ShootDistanceStraightRed() {
    	
    	/*
    	 * For Blue eleminations
    	 * */
    	 
    	addSequential(new AutoShootCommand());
    	addSequential(new AutoDriveTime(2, -.6, -.605));
		//addSequential(new TurnAround(-35, 2));
		////addSequential(new AutoDistance(15000));
    	//addSequential(new AutoDriveTime(4, .55, .55));
    	//addSequential(new TurnAround(-95, 2));
    	//addSequential(new AutoDriveTime(2, .85, .85));
    	
    	/*
    	 * For Blue 
    	 * */
    	
//    	addSequential(new AutoShootCommand()); //for boiler side blue open field
//    	addSequential(new AutoDistance(5000));
//		addSequential(new TurnAround(20, 2));
//		addSequential(new AutoDistance(10000));
//    	addSequential(new TurnAround(-60, 2));
//		addSequential(new AutoDriveTime(2, .65, .65));
//		
		
    	//addSequential(new AutoDriveTime(3, .70, .70));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
