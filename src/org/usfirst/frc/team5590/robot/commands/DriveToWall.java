package org.usfirst.frc.team5590.robot.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;
import org.usfirst.frc.team5590.robot.subsystems.RangeFinder;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToWall extends Command{

	private double speed;
	private double time;
	private boolean wall;
	
	 public DriveToWall(double speed, int time) {
	        // Use requires() here to declare subsystem dependencies
	        // eg. requires(chassis);
		 	requires(Robot.drivetrain);
		 	requires(Robot.gyroSPI);
		 	requires(Robot.ranger);
		 	this.speed = speed;
	    	this.time = time;
	    	wall = false;
	 	}
	 
	 protected void initialize() {
	    	Robot.drivetrain.stop();
	    	wall = false;
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	
	    	if (Robot.ranger.getVoltage() < 3)
	    	{
	    		wall = true;
	    	}
	    	
	    	if (wall == false)
	    	{
	    		Robot.drivetrain.setSpeed(this.speed);
	    	}
	    	else if (wall == true){
	    		Robot.drivetrain.setSpeed(0);
	    	}
	    }

		@Override
		protected boolean isFinished() {
			// TODO Auto-generated method stub
			return wall;
		}
}