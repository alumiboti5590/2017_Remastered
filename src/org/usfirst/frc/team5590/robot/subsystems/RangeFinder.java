package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * This is a subsystem that allows for access to the front rangefinder on the robot.
 */
public class RangeFinder extends Subsystem{
	static AnalogInput ai;
	
	public RangeFinder()
	{
		ai = new AnalogInput(3);
		int bits;
		ai.setOversampleBits(4);
		bits = ai.getOversampleBits();
		ai.setAverageBits(2);
		bits = ai.getAverageBits();
		ai.setGlobalSampleRate(62500);
	}
	
	public static double getVoltage ()
	{
		return ai.getVoltage();
	}
	public static double getValue ()
	{
		return ai.getValue();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
