package org.usfirst.frc.team5590.robot.commands;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This will orient the robot to any angle based on a normal rectangular coordinate system
 * with the robot beginning at a bearing of 90 degrees.
 */
public class Orient extends Command { //NOT DONE
   
    //private double time;
    private double ang;
    private double startAng;
    boolean done = false;
    
    public Orient(double ang) {	
    	requires(Robot.drivetrain);
    	requires(Robot.gyroSPI);
    	this.ang = ang;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.stop();
    	if (ang > 0) //start at 90 ex want to go to -90
    	{
    		//0 ang = 90
    		if (Robot.gyroSPI.getReducedAng() > ang)
    		{
    			while (Robot.gyroSPI.getReducedAng() > ang)
    			{
    				Robot.drivetrain.turn(true);
    				System.out.println(Robot.gyroSPI.getReducedAng());
    			}
    			Robot.drivetrain.stop();
    		}
    		else if (Robot.gyroSPI.getReducedAng() < ang)
    		{
    			while (Robot.gyroSPI.getReducedAng() < ang)
    			{
    				Robot.drivetrain.turn(false);
    				System.out.println(Robot.gyroSPI.getReducedAng());
    			}
    			Robot.drivetrain.stop();
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

