package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Command class that pulls in the gear pusher using methods from the GearPusher class
 */
public class GearPushOut extends Command {

	public GearPushOut(double seconds) 
	{	
		//Lets the command know that it is using a method that belongs to gearPusher
        requires(Robot.gearPusher);
        
        //Makes the command stop after 3 seconds
        setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	// Method to push the pusher out
    	System.out.println("Starting GearPushOut");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.gearPusher.pusherExtend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("Ending GearPushOut");
    	Robot.gearPusher.pusherOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	//Cancels command if pusher is required elsewhere.
    	Robot.gearPusher.pusherOff();
    }
}