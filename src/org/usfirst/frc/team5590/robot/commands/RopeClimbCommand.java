package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command chain which combines both the RopeGrab and RopeClimb commands
 * to act in a sequence
 */
public class RopeClimbCommand extends CommandGroup {
	private static final double GRABBER_DEGREES = 240.0;
	
    public RopeClimbCommand() {
    	 // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	//addSequential(new RopeGrab(GRABBER_DEGREES));
    	addSequential(new Delay(.5), .5);
    	addSequential(new RopeClimb(11.0));
    	//addSequential(new RopeGrab(-15.0));
    	addSequential(new RopeClimb(40.0));
    	//addParallel(new RopeGrab(-100.0));
    	
    }
}
