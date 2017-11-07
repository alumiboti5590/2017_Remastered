package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command chain which is used for the autonomous gear delivery process
 */
public class GearPusherAutoCommand extends CommandGroup {
    private static final double PUSHERSECONDS = 0.25;
    private static final double HOLDERSECONDS = 0.25;
    
    public  GearPusherAutoCommand() 
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new GearHolderOpen(HOLDERSECONDS), .5);
    	addSequential(new GearPushOut(PUSHERSECONDS), .5);
    	addSequential(new GearPullIn(PUSHERSECONDS), .5);
    	addSequential(new Delay(.5), .5);
    	addSequential(new GearHolderClose(.3), .3);
    }
}