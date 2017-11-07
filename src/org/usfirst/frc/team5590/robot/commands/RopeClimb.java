package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command class that uses methods from the RopeClimber class to control how 
 * far the climber will go
 */
public class RopeClimb extends Command {

	private double inches;
	
    public RopeClimb(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.inches = inches;
    	requires(Robot.ropeClimber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Starting Climb");
    	Robot.ropeClimber.resetEncoder();
    	Robot.compressor.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ropeClimber.moveDistance(this.inches);
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.ropeClimber.isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Ending Climb");
    	Robot.ropeClimber.isFinished = false;
    	Robot.compressor.start();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.ropeClimber.stop();
    }
}