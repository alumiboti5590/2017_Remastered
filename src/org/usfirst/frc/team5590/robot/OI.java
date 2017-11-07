package org.usfirst.frc.team5590.robot;

import org.usfirst.frc.team5590.robot.commands.DriveToWall;
import org.usfirst.frc.team5590.robot.commands.GearHolderClose;
import org.usfirst.frc.team5590.robot.commands.GearHolderOpen;
import org.usfirst.frc.team5590.robot.commands.GearPullIn;
import org.usfirst.frc.team5590.robot.commands.GearPushOut;
import org.usfirst.frc.team5590.robot.commands.GearPusherCommand;
import org.usfirst.frc.team5590.robot.commands.GrabTheRope;
import org.usfirst.frc.team5590.robot.commands.Orient;
import org.usfirst.frc.team5590.robot.commands.RopeClimbCommand;
//import org.usfirst.frc.team5590.robot.commands.RopeGrab;
import org.usfirst.frc.team5590.robot.commands.TimedDrive;
import org.usfirst.frc.team5590.robot.commands.Turn;
import org.usfirst.frc.team5590.robot.commands.TurnAng;
import org.usfirst.frc.team5590.robot.controllers.LogitechX3;
import org.usfirst.frc.team5590.robot.controllers.XboxController;
import org.usfirst.frc.team5590.robot.subsystems.Drivetrain;
//import org.usfirst.frc.team5590.robot.subsystems.RopeGrab;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	// Ports for controllers
	private static final int XBOX_PORT = 0;
	private static final int LOGITECH_PORT = 1;
	
	// Controller objects
	public XboxController xbox;
	public LogitechX3 logitech;
	
	public OI() 
	{
		xbox = new XboxController(XBOX_PORT);
		logitech = new LogitechX3(LOGITECH_PORT);
		//Command TURN = new Turn(10, true);
		
		// pusher test
		logitech.button12.whenPressed(new GearPushOut(0.25));
		logitech.button11.whenPressed(new GearPullIn(0.25));
		//xbox.buttonA.whenPressed(new TimedDrive(.7,3));
		//xbox.buttonB.whenPressed(new TimedDrive(.8,1));
		//xbox.buttonX.whenPressed(new TimedDrive(.8,2));
		//xbox.buttonY.whenPressed(new TimedDrive(.8,3));
		//xbox.buttonStart.whenPressed(new Orient(90, gyroSPI));
		
		
		// holder manual controls in case gear needs to be loaded manually
		logitech.button10.whenPressed(new GearHolderOpen(0.25));
		logitech.button9.whenPressed(new GearHolderClose(0.25));
		//xbox.buttonX.whenPressed(new GearHolderClose(0.25));
		//xbox.buttonY.whenPressed(new GearHolderClose(0.25));
		//xbox.buttonStart.whenPressed(new Back (0.25));
		//xbox.buttonY.whenPressed(TURN.start());
		
		//logitech.button10.whenPressed(new RopeGrab(-155));
		//xbox.buttonA.toggleWhenPressed(new RopeGrab());
		//xbox.buttonA.whenPressed(new GrabTheRope(.2));
		//xbox.buttonB.whenPressed(new GrabTheRope(0));
		//xbox.buttonX.whenPressed(new GrabTheRope(-.2));
		xbox.buttonA.whenPressed(new TurnAng(180));
		xbox.buttonB.whenPressed(new Orient(180));
		xbox.buttonX.whenPressed(new DriveToWall(.4, 10)); 
		xbox.buttonY.whenPressed(new TimedDrive(0.4, 2, null)); //broken??
		
		// Executes gear pusher command sequence when pressed
		logitech.button5.whenPressed(new GearPusherCommand());
		
		//logitech.button8.whenPressed(new RopeGrab(155));
		//logitech.button7.whenPressed(new RopeClimb(42.0));
		
		// Executes rope climb command sequence when pressed
		logitech.button6.whenPressed(new RopeClimbCommand());
	}
}