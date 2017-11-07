package org.usfirst.frc.team5590.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabRope extends Subsystem {

	//private static final int SOLENOID_IN = 0;
	//private static final int SOLENOID_OUT = 1;

	CANTalon grabRope;
	

	public GrabRope() {
		// Create a DoubleSolenoid
		grabRope = new CANTalon(0);
		
		grabRope.reverseSensor(true);
		grabRope.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		grabRope.configEncoderCodesPerRev(360);
		grabRope.setPosition(0);
		grabRope.setForwardSoftLimit(15.0); //lim of 15 rev
		grabRope.setReverseSoftLimit(-15.0); //lim of 15 rev
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	// Extends the pusher to eject the gear from where it is being held
	public void setSpeed(double speed) {
		//System.out.println("Test: " + grabRope.GetVelocityMeasurementPeriod());
		System.out.println("Test: " + grabRope.get());
		System.out.println("Test: " + grabRope.getPosition());
		System.out.println("Test: " + grabRope.getSpeed());
		//System.out.println("Test: " + grabRope.getAnalogInPosition());
		grabRope.set(speed);
		
		//gearPusher.set(DoubleSolenoid.Value.kForward);
	}

	// Returns the pusher from it's extended position to it's resting state
	public void pusherRetract() {
		//gearPusher.set(DoubleSolenoid.Value.kReverse);
	}

	// Deactivates the subsystem
	public void pusherOff() {
		//gearPusher.set(DoubleSolenoid.Value.kOff);
	}

}