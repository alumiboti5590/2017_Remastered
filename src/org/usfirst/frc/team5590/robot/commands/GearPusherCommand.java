package org.usfirst.frc.team5590.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command chain to be used for gear delivery during the teleop stage of play
 */
public class GearPusherCommand extends CommandGroup {
    private static final double PUSHERSECONDS = 0.25;
    private static final double HOLDERSECONDS = 0.25;
    
    
    public  GearPusherCommand() 
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential(new GearHolderOpen(HOLDERSECONDS), .5);
    	addSequential(new GearPushOut(PUSHERSECONDS), .5);
    	addSequential(new GearPullIn(PUSHERSECONDS), .5);
    	addSequential(new Delay(5.0), 5.0);
    	addSequential(new GearHolderClose(1), 1);
    }
}