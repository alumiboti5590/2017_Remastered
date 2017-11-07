package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous command chain to be used when starting on the right side of the field
 */
public class RightGearAutoGroup extends CommandGroup {

    public RightGearAutoGroup() {
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
    	
       	addSequential(new GearHolderClose(.3), .3);
    	addSequential(new TimedDrive(.7, 1.7, null), 1.7);
    	addSequential(new GearPusherAutoCommand(), 2.3);
    	addSequential(new TimedDrive(-.5, .8, null), .8);
    }
}
