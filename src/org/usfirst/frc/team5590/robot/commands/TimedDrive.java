package org.usfirst.frc.team5590.robot.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that takes speed and time as fields and drives the robot 
 * at that given speed for that given time in autonomous
 */
public class TimedDrive extends Command {
	
	private static double speed;
	private static double time;
	private boolean done = false;
	private static double [] pos;

    public TimedDrive(double speed, double time, double [] pos) {
  
    	requires(Robot.drivetrain);
    	requires(Robot.gyroSPI);
    	requires(Robot.ranger);
    	this.speed = speed;
    	this.time = time;
    	this.pos = pos;
    	setTimeout(this.time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (pos != null)
    	{
    		calc();
    	}
    	Robot.drivetrain.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setSpeed(this.speed); //does not work???
    	long end = (long) (System.currentTimeMillis() + (time*1000));
    	if (System.currentTimeMillis() > end)
    	{
    		Robot.drivetrain.stop();
    		done = true;
    	}
    	
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
    
    public String toString()
    {
    	return "TimedDrive " + speed + " " + time; //10 14
    }
    
    public double getSpeed()
    {
    	return speed;
    }
    
    public static void calc ()
    {
    			speed = speed;
    			time = time;
    			double angle = Robot.gyroSPI.getAngle(); //0 now 90 forward
    			double realAngle = 90 - angle;
    			double distance = 0;
    			
    			if (speed == 0.4)
    			{
    				distance = (20.1*time) - 1.5;
    			}
    			else if (speed == 0.5)
    			{
    				distance = (33.7*time) - 1.5;
    			}
    			else if (speed == 0.6)
    			{
    				distance = (50.4*time) - 1.0;
    			}
    			pos [0] = pos[0] + (Math.cos (Math.toRadians(realAngle)) * distance);
    			pos [1] = pos[1] + (Math.sin (Math.toRadians(realAngle)) * distance);
    			System.out.println(distance);
    			System.out.println("THE CURRENT ANG IS: " + realAngle);
    			
    			//System.out.println(pos[0] + " " + pos [1]);
        		double dia = Math.sqrt((pos[0] * pos[0]) + (pos[1] * pos[1]));
        		System.out.println("The distance is :" + dia); //really about 90
        		
        		System.out.println("Total X: " + pos [0] + "Total Y: " + pos[1]); 
    		}
    		
}