package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command class is designed to close the doors holding 
 * the gear utilizing methods from the GearHolder class
 */
public class GearHolderClose extends Command {

    public GearHolderClose(double holderseconds) 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearHolder);
    	setTimeout(holderseconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	System.out.println("Starting GearHolderClose");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.gearHolder.holderClose();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("Ending GearHolderClose");
    	Robot.gearHolder.holderOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	Robot.gearHolder.holderOff();
    }
}