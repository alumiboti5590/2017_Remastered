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
public class ReturnAutoGroup extends CommandGroup { //NEED TO ADD TURN
	private ArrayList LIST;
    public ReturnAutoGroup(ArrayList LIST) {
    	requires(Robot.drivetrain);
    	requires(Robot.gyroSPI);
    	requires(Robot.ranger);
    	this.LIST = LIST;
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
    	for (int i = LIST.size()-1; i >= 0; i--)
    	{
    		if (LIST.get(i).toString().substring(0, 10).equals("TimedDrive"))
    		{
    			int firstSpace = LIST.get(i).toString().indexOf(" ");
    			int secondSpace = LIST.get(i).toString().indexOf(" ", firstSpace + 1);
    			System.out.println(secondSpace);
    			System.out.println(firstSpace + " "  + secondSpace);
    			double speed = Double.parseDouble(LIST.get(i).toString().substring(firstSpace+1, secondSpace));
    			speed = speed * -1; //other way
    			System.out.println(speed);
    			System.out.println(LIST.get(i).toString());
    			double time = Double.parseDouble(LIST.get(i).toString().substring(secondSpace+1, LIST.get(i).toString().length()));
    			System.out.println(time);
    			addSequential(new TimedDrive(speed,time, null));
    			System.out.println("Test");
    		}
    		else if (LIST.get(i).toString().substring(0, 7).equals("TurnAng"))
    		{
    			int firstSpace = LIST.get(i).toString().indexOf(" ");
    			double ang = Double.parseDouble(LIST.get(i).toString().substring(firstSpace+1, LIST.get(i).toString().length()));
    			//other way
    			ang = ang * -1;
    			addSequential(new TurnAng(ang));
    			//System.out.println("Test");
    		}	 
    	}
    }
    
    private void addCommand (Command toDO)
    {
    	LIST.add(toDO);
    }
    
}
