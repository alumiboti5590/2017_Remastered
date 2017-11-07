package org.usfirst.frc.team5590.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;
import org.usfirst.frc.team5590.robot.subsystems.RangeFinder;
import org.usfirst.frc.team5590.robot.Robot;
import org.usfirst.frc.team5590.robot.commands.TimedDrive;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Test command for driving the robot straight in autonomous
 */
public class RTBAutoGroup extends CommandGroup { //THIS IS NOT DONE
	private double [] pos;
	
    public RTBAutoGroup(double [] pos) {
    	requires(Robot.gyroSPI);
    	this.pos = pos;
    	
    	double dia = Math.sqrt((pos[0] * pos[0]) + (pos[1] * pos[1]));
    	double angle = 180 - Robot.gyroSPI.getAngle();
    	
    	double nowAng = Math.atan(pos[1]/pos[0]); //this ang
    	//nowAng = 90 - nowAng;
    	//addSequential(new TurnAng(-1*(nowAng - gyroSPI.getAngle() + 180),gyroSPI));
    	//addSequential(new TurnAng(nowAng,gyroSPI));
    	addSequential(new TurnAng(-1*(nowAng - Robot.gyroSPI.getAngle() + 180)));
    	addSequential(new TimedDrive(.5,3.5, pos)); //59" //100
    	addSequential(new TurnAng((nowAng - Robot.gyroSPI.getAngle() + 180)));
    	//double TURN = -nowAng;
    	//addSequential(new TurnAng(TURN, gyroSPI));
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    }
    
    private void addCommand (Command toDO)
    {
    	//LIST.add(toDO);
    }
    
}

