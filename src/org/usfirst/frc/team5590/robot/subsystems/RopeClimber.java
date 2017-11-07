package org.usfirst.frc.team5590.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RopeClimber extends Subsystem {
	static Encoder climbEnc;
	static SpeedController ropeSpeed;
	public static AnalogInput    safetySwitch;

	// creates two variables that tell the signals and are equal to the ports
	// they are in
	private static final int ROTATIONAL_ENCODER_SIGNAL_INPUT = 0;
	private static final int ROTATIONAL_ENCODER_SIGNAL_OUTPUT = 1;
	private static final int SAFETY_SWITCH_PORT = 0;

	// creates a variable for the speed controller PWM
	private static final int ROPE_CLIMB_PWM = 2;

	// How many inches per pulse the encoder measures
	private static final double DISTANCE_PER_PULSE = .02213280569;

	// How many degrees per pulse the encoder measures
	private static final double DEGREES_PER_PULSE = 1.380555556;

	// Amount allowed to account for over or under shooting
	private static final double ERROR_ALLOWED = 0.5;
	
	private static final double SPEED_MULTIPLIER = 1.0;

	private int speed;
	
	public static boolean isFinished = false;

	// constructs the speed controller and the encoder
	public RopeClimber() {
		climbEnc = new Encoder(ROTATIONAL_ENCODER_SIGNAL_INPUT, ROTATIONAL_ENCODER_SIGNAL_OUTPUT, true,
				EncodingType.k2X);
		climbEnc.setDistancePerPulse(DISTANCE_PER_PULSE);
		ropeSpeed = new TalonSRX(ROPE_CLIMB_PWM);
		
		ropeSpeed.stopMotor();
		safetySwitch = new AnalogInput(SAFETY_SWITCH_PORT);
	}

	// sets the speed controller to a speed while the encoder count is less than
	// a certain number
	public void moveDistance(double inches) {
		
		//System.out.println(safetySwitch.get());
		
		if ((Math.abs(climbEnc.getDistance() - inches) < ERROR_ALLOWED) ||  safetySwitch.getVoltage() < 0.5) {
			ropeSpeed.set(0.7);
			isFinished = true;
			return;
		}
		
		double validSpeed;
		
		validSpeed = ensureRange(1.0 * SPEED_MULTIPLIER, -1, 1);
		ropeSpeed.set(validSpeed);
		
		System.out.println("Raw distance " + climbEnc.getDistance() + "     " + inches);
		
	}

	// resets the encoder count and sets the speed controller to 0
	public void resetWinch() {

	}
	
	// Gets the value that the encoder is currently reading. Used for testing purposes
	public int getEncoder() {
		return climbEnc.get();
	}

	// resets the encoder count
	public void resetEncoder() {
		climbEnc.reset();
	}
	
	// Stops the climber
	public void stop() {
		climbEnc.reset();
		ropeSpeed.stopMotor();
	}


	// ensures the speed value is between -1.0 and 1.0
	private double ensureRange(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}