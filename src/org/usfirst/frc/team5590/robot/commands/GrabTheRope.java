package org.usfirst.frc.team5590.robot.commands;

import java.util.concurrent.TimeUnit;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;

import edu.wpi.first.wpilibj.command.Command;


/**
 * Command that takes speed and time as fields and drives the robot 
 * at that given speed for that given time in autonomous
 */
public class GrabTheRope extends Command {

	//public static CANTalon test;

	private double speed;

    public GrabTheRope(double speed) 
    {
    	requires(Robot.ropeGrab);
    	//test = new CANTalon(0);
    	this.speed = speed;
    	
    	
    }

	@Override
	protected void initialize() 
    {
    	// Method to push the pusher out
    	//System.out.println("Starting GearPushOut");
    }

    // Called repeatedly when this Command is scheduled to run
    @SuppressWarnings("deprecation")
	protected void execute() 
    {
    	//Robot.gearPusher.pusherExtend();
    	Robot.ropeGrab.setSpeed(speed);
    	
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