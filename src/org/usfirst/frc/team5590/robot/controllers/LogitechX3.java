package org.usfirst.frc.team5590.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Logitech controller with all of the buttons mapped out.
 * This can be reused if the controller is used.
 */
public class LogitechX3 extends Joystick{
	
	public Button button1,
			button2,
			button3 ,
			button4,
			button5,
			button6 ,
			button7 ,
			button8 ,
			button9,
			button10,
			button11,
			button12;
		
	public LogitechX3(int port) {
		super(port);
		button1 = new JoystickButton(this, 1);
		button2 = new JoystickButton(this, 2);
		button3 = new JoystickButton(this, 3);
		button4 = new JoystickButton(this, 4);
		button5 = new JoystickButton(this, 5);
		button6 = new JoystickButton(this, 6);
		button7 = new JoystickButton(this, 7);
		button8 = new JoystickButton(this, 8);
		button9 = new JoystickButton(this, 9);
		button10 = new JoystickButton(this, 10);
		button11 = new JoystickButton(this, 11);
		button12 = new JoystickButton(this, 12);	
	}
	
	public double getMainStickX() {
		return this.getRawAxis(0);
	}
	public double getMainStickY() {
		return this.getRawAxis(1);
	}
	public double getMainStickZ () {
		return this.getRawAxis(2);
	}
	public double getSliderY() {
		return this.getRawAxis(3);
	}
	public boolean getbutton1() {
		return button1.get();
	}
	public boolean getbutton2() {
		return button2.get();
	}
	public boolean getbutton3() {
		return button3.get();
	}
	public boolean getbutton4() {
		return button4.get();
	}
	public boolean getbutton5() {
		return button5.get();
	}
	public boolean getbutton6() {
		return button6.get();
	}
	public boolean getbutton7() {
		return button7.get();
	}
	public boolean getbutton8() {
		return button8.get();
	}
	public boolean getbutton9() {
		return button9.get();
	}
	public boolean getbutton10() {
		return button10.get();
	}
	public boolean getbutton11() {
		return button11.get();
	}
	public boolean getbutton12() {
		return button12.get();
	}
}
