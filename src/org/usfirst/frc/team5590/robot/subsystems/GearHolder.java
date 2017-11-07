package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
/*
 * 
 */
public class GearHolder extends Subsystem{
	
	private static final int SOLENOID_IN = 2;
	private static final int SOLENOID_OUT = 3;
	
	DoubleSolenoid gearHolder;
	public void initDefaultCommand(){
		//Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		gearHolder = new DoubleSolenoid(SOLENOID_IN,SOLENOID_OUT);
		holderClose();
	}
	
	// Opens the doors that hold in the gear
	public void holderOpen(){
		gearHolder.set(DoubleSolenoid.Value.kForward);
	}
	
	// Closes the doors that hold in the gear
	public void holderClose(){
		gearHolder.set(DoubleSolenoid.Value.kReverse);
	}
	
	// Deactivates the subsystem
	public void holderOff(){
		gearHolder.set(DoubleSolenoid.Value.kOff);
	}
}