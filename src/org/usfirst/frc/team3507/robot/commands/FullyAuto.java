package org.usfirst.frc.team3507.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FullyAuto extends CommandGroup {

    public FullyAuto() {
    	
    	addSequential(new AutoDistance(29000));
    	addSequential(new TurnAround(30, 1));
    	addParallel(new Delay(1));
    	addSequential(new AutoDistance(6000));
    	addSequential(new Delay(1));
    	addSequential(new AutoDistance(-6000));
    	addSequential(new TurnAround(200, 5));
    	addSequential(new AutoDistance(28000));
    	addParallel(new AutoFlywheel(false));
    	addParallel(new Delay(0.5));
    	addSequential(new AutoElevator(false));	
    	
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
