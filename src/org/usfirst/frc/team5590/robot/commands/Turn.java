package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command used to turn the robot in autonomous, after testing we found that this may not be 
 * needed based on the starting position of the robot on the field
 */
public class Turn extends Command { 
   
    private double time;
    private boolean isRight;
    
    public Turn(double time, boolean isRight) {	
    	requires(Robot.drivetrain);
    	this.time = time;
    	this.isRight = isRight;
    	setTimeout(this.time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.stop();
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.turn(isRight);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}