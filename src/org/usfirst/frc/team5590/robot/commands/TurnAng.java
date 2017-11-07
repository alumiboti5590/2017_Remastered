package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command turns the robot a given number of degrees with positive numbers being
 * right and negative numbers being left
 */
public class TurnAng extends Command { 
   
    private double ang;
    private double startAng;
    boolean done = false;
    
    public TurnAng(double ang) {	
    	requires(Robot.drivetrain);
    	requires(Robot.gyroSPI);  	
    	this.ang = ang;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.drivetrain.stop();
    	startAng = Robot.gyroSPI.getAngle();
    	if (ang > 0)
    	{
    	while (ang + startAng > Robot.gyroSPI.getAngle())
    	{
    			Robot.drivetrain.turn(true);
    	}
    	}
    	else if (ang < 0)
    	{
    		while (ang + startAng < Robot.gyroSPI.getAngle())
        	{
        			Robot.drivetrain.turn(false);
        			System.out.println("trying");
        	}
    	}
    	Robot.drivetrain.stop();
    	done = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
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
    
    public String toString ()
    {
    	return "TurnAng" + " " + ang;
    }
}
