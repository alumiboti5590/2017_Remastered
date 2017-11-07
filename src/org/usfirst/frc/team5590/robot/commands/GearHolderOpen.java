package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command class is designed to open the doors holding the gear
 * using methods from the GearHolder class
 */
public class GearHolderOpen extends Command {

    public GearHolderOpen(double holderseconds) 
    {
    	requires(Robot.gearHolder);
    	setTimeout(holderseconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	System.out.println("Starting GearHolderOpen");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.gearHolder.holderOpen();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	System.out.println("Ending GearHolderOpen");
    	Robot.gearHolder.holderOff();	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	Robot.gearHolder.holderOff();
    }
}