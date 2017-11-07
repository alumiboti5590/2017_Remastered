
package org.usfirst.frc.team5590.robot;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team5590.robot.commands.DriveToWall;
import org.usfirst.frc.team5590.robot.commands.LeftGearAutoGroup;
import org.usfirst.frc.team5590.robot.commands.MidGearAutoGroup;
import org.usfirst.frc.team5590.robot.commands.ReturnAutoGroup;
import org.usfirst.frc.team5590.robot.commands.StraightAutoGroup;
import org.usfirst.frc.team5590.robot.commands.TimedDrive;
import org.usfirst.frc.team5590.robot.commands.Turn;
import org.usfirst.frc.team5590.robot.commands.TurnAng;
import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;
import org.usfirst.frc.team5590.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5590.robot.subsystems.GearHolder;
import org.usfirst.frc.team5590.robot.subsystems.GearPusher;
import org.usfirst.frc.team5590.robot.subsystems.GrabRope;
import org.usfirst.frc.team5590.robot.subsystems.RangeFinder;
import org.usfirst.frc.team5590.robot.subsystems.RopeClimber;
//import org.usfirst.frc.team5590.robot.subsystems.RopeGrabber;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	// All subsystems needed by the robot
    public static final Drivetrain drivetrain = new Drivetrain();
    public static final GearHolder gearHolder = new GearHolder();
    public static final GearPusher gearPusher = new GearPusher();
    public static final RopeClimber ropeClimber = new RopeClimber();
    public static final GrabRope ropeGrab = new GrabRope();
    //public static final RopeGrabber ropeGrabber = new RopeGrabber();
    public static final Compressor compressor = new Compressor();
    
    public static final ADXRS453Gyro gyroSPI = new ADXRS453Gyro();
    public static final RangeFinder ranger = new RangeFinder();
    public static final BuiltInAccelerometer accel = new BuiltInAccelerometer();
    public static OI oi;
   
    public static RangeFinder Ranger;
    public static double [] pos;

    Command autonomousCommand = new TimedDrive(-.5, 20, null);
    Command TURN = new Turn(10, true);
    Command WALL = new DriveToWall(.4, 20);
    
   
  
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
		oi = new OI();
		CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().startAutomaticCapture();
		gyroSPI.startThread();
		pos = new double [2];
		pos[0] = 0; //0 is X
		pos[1] = 0;//1 is Y
		 
		 //gyroSPI.calibrate();
		
		//System.out.println(accel.getX() + ", " + accel.getY() + ", " + accel.getZ());
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit()
    {

    }
	
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() 
    {
        //if (autonomousCommand != null) autonomousCommand.start();
        //WALL.start();
    	//Command NOW = new StraightAutoGroup(gyroSPI, Ranger);
    	Command NOW = new StraightAutoGroup(pos);
    	Command test = new TurnAng(180);
    	Command test1 = new DriveToWall(.4,10);
    	//NOW.start();
    	test.start();
    	//goFor.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
    	Scheduler.getInstance().run();
    	//System.out.println(Robot.drivetrain.gyro.getAngle());
    }

    public void teleopInit() 
    {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) 
        {
        	autonomousCommand.cancel();
        }
        drivetrain.stop();
        //gyroSPI.calibrate();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
       // double raw = ai.ReadOutVolts();
        drivetrain.joystickSpeed();
        //Robot.ropeGrab.
       //drivetrain.joystickSpeed();
        
       //drivetrain.joystickSpeed();
        	//System.out.println(accel.getX() + ", " + accel.getY() + ", " + accel.getZ());
        	//if (accel.getX() > 0.15 || accel.getY() > 0.15)
        	//{
        		//System.out.println("Going fast");
        	//}
        	//if ()
        	//double raw = ai.getValue();
        	
        	//System.out.println(gyroSPI.getAngle());
        	//System.out.println("X: " + accel.getX()+ " Y: " + accel.getY() + " Z: " + accel.getZ());
        	//System.out.println(Ranger.getValue());
        System.out.println(gyroSPI.getReducedAng());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
