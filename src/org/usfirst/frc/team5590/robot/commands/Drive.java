package org.usfirst.frc.team5590.robot.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that takes speed and time as fields and drives the robot 
 * at that given speed for that given time in autonomous
 */
public class Drive extends Command {
	
	private static double speed;
	private double time;
	private static double distance;
	private double angle;
	private static double BetaTime; //BETA FEATURE
	private ADXRS453Gyro gyroSPI;
	private boolean done = false;

    public Drive(double speed, double time, double distance, double angle, ADXRS453Gyro gyroSPI) 
    {
    	this.speed = speed;
    	this.time = time;
    	this.distance = distance;
    	this.angle = angle;
    	this.gyroSPI = gyroSPI;
    	requires(Robot.drivetrain);
    	setTimeout(this.time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.stop();
    	if (angle != 0)
    	{
    		Command turn = new TurnAng(angle);
    		while (turn.isRunning())
    		{
    			//try this on bot (wait)
    		}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setSpeed(this.speed);
    	long start = System.currentTimeMillis();
    	if (System.currentTimeMillis() > start + (time*1000))
    	{
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
    	return "Drive  Speed:" + speed + "Time:" + time + "Distance:" + distance + "Angle:" + angle + "END"; //10 14
    }
    
    public double getSpeed()
    {
    	return speed;
    }
    
    public static void BetaTime ()
    {
    	if (speed == 0.4)
    	{
    		BetaTime = (distance + 1.5) / 20.1;
    	}
    	else if (speed == 0.5)
		{
    		BetaTime = (distance + 1.5) / 33.7;
		}
    	else if (speed == 0.6)
		{
    		BetaTime = (distance + 1.0) / 50.4;
		}
    	
    }

}
