package org.usfirst.frc.team5590.robot.subsystems;

import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *This is the subsystem to represent the Drivetrain
 */
public class Drivetrain extends Subsystem {
    
	// Port values 
	private static final int LEFTCONTROLLERPWM = 1;
    private static final int RIGHTCONTROLLERPWM = 0;
    private static final double MINSPEED = -1.0;
    private static final double MAXSPEED = 1.0;
    
    private static final double KP = .03;
    private static final double DEADZONE_TOLERANCE_LEFT = .15;
    private static final double DEADZONE_TOLERANCE_RIGHT = .18;
    
    private static final int DISTANCE_SENSOR_INPUT = 1;
    
    // RobotDrive from FRC
    private RobotDrive robotDrive;
    public Gyro gyro;
    //public static AnalogInput distanceSensor;
    
    // Constructs the drivetrain on the robot
    public Drivetrain()
    {
    	robotDrive = new RobotDrive(LEFTCONTROLLERPWM, RIGHTCONTROLLERPWM);
    	robotDrive.setSafetyEnabled(false);
    	robotDrive.setExpiration(.1);
    	
    	gyro = new AnalogGyro(1);
    	//gyro.reset();
    	//gyro.calibrate();
    	
    	//test.
    	//test.s
    	//distanceSensor = new AnalogInput(DISTANCE_SENSOR_INPUT);
    }
    
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * This method will set the speed of the drivetrain 
     * motors according to the joystick controllers.
     */
    public void joystickSpeed() 
    {
    	double left, right;
    	
    	if (Robot.oi.xbox.getRightTrigger() < .5) //change
    	{
    		// Standard drive
			left = -1 * Robot.oi.xbox.getLeftStickY();
			right = -1 * Robot.oi.xbox.getRightStickY();
    	} 
    	else 
    	{
    		left = Robot.oi.xbox.getRightStickY();
    		right = Robot.oi.xbox.getLeftStickY();
    	}
    	
    	double validLeft =  ensureDeadzone(this.ensureRange(left, MINSPEED, MAXSPEED), DEADZONE_TOLERANCE_LEFT);
    	double validRight = ensureDeadzone(this.ensureRange(right, MINSPEED, MAXSPEED), DEADZONE_TOLERANCE_RIGHT);
    	
    	robotDrive.tankDrive(validLeft, validRight); //tank drive
    }
    
    /**
     * This method will set the speed of the motors
     * in the drivetrain to whatever *speed* is.
     */
    public void setSpeed(double speed) 
    {
    	////This ensures that the speed received is valid
    	//double validSpeed = this.ensureRange(speed, MINSPEED, MAXSPEED);
    	
    	//double angle = gyro.getAngle();
    	//robotDrive.drive(-validSpeed, -angle * KP);
    	robotDrive.tankDrive(speed, speed + .05);
    }
     
    public boolean setSpeedandDistance(double speed, double distance)
    {
    	return true;
    }
    
    /**
     * This method will be called to STOP the robot.
     */
    public void stop() 
    {
    	this.setSpeed(0);
    	
    }
    
    public void resetGyro()
    {
    	gyro.reset();
    }
    
    // Method used to turn the robot. Used in Turn command
    public void turn(boolean isRight)
    {
    	if(isRight)
    	{
    		robotDrive.tankDrive(0.4, -0.4);
    	}
    	else
    	{
    		robotDrive.tankDrive(-0.4, 0.4);
    	}
    }
    
    private  double ensureRange(double value, double min, double max) 
    {
    	return Math.min(Math.max(value, min), max);
    }
    
    private double ensureDeadzone(double speed, double tolerance) 
    {
    	double pos = Math.abs(speed);
    	if (pos < tolerance) 
    	{
    		return 0;
    	}
    	return speed;
    }
}