package org.usfirst.frc.team3507.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootCommand extends CommandGroup {

    public AutoShootCommand() {
    	
//    	addSequential(new AutoDriveTime(5, 0.5, 0.5));
//    	addSequential(new Delay(5));
    	addSequential(new AutoFlywheel(false));
    	addSequential(new Delay(1));
    	addSequential(new AutoElevator(false));
    	addSequential(new Delay(6));
    	addSequential(new AutoFlywheel(true));
    	addSequential(new AutoElevator(true));
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
    
    protected void execute() {
    	
    }
}
