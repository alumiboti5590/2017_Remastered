package org.usfirst.frc.team5590.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Xbox controller with all of the buttons mapped out.
 * This can be reused if the controller is used.
 */
public class XboxController extends Joystick {
	
	public Button buttonA, 
			buttonB,
			buttonX,
			buttonY,
			buttonSelect,
			buttonStart,
			buttonLogo;
	public Button leftBumper;
	public Button rightBumper;	
	
	public XboxController(int port) 
	{
		super(port);
		buttonA = new JoystickButton(this, 1);
		buttonB = new JoystickButton(this, 2);
		buttonX = new JoystickButton(this, 3);
		buttonY = new JoystickButton(this, 4);
		buttonSelect= new JoystickButton(this, 5);
		buttonStart = new JoystickButton(this, 6);
		buttonLogo = new JoystickButton(this, 7);
		leftBumper = new JoystickButton(this, 8);
		rightBumper = new JoystickButton(this, 9);
	}

	public double getLeftTrigger() 
	{
		return this.getRawAxis(2);
	}
	public double getRightTrigger() 
	{
		return this.getRawAxis(3);
	}
	public double getLeftStickX() 
	{
		return this.getRawAxis(0);
	}
	public double getLeftStickY() 
	{
		return this.getRawAxis(1);
	}
	public double getRightStickX() 
	{
		return this.getRawAxis(4);
	}
	public double getRightStickY() 
	{
		return this.getRawAxis(5);
	}
	public double getDPadX () 
	{
		return 0;
	}
	public double getDPadY () 
	{
		return 0;
	}
	public boolean getbuttonA() 
	{
		return buttonA.get();
	}
	public boolean getbuttonB() 
	{
		return buttonB.get();
	}
	public boolean getbuttonX() 
	{
		return buttonX.get();
	}
	public boolean getbuttonY() 
	{
		return buttonY.get();
	}
	public boolean getbuttonSelect() 
	{
		return buttonSelect.get();
	}
	public boolean getbuttonStart() 
	{
		return buttonStart.get();
	}
	public boolean getbuttonLogo() 
	{
		return buttonLogo.get();
	}
}