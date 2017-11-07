package org.usfirst.frc.team5590.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5590.robot.subsystems.ADXRS453Gyro;
import org.usfirst.frc.team5590.robot.subsystems.RangeFinder;
import org.usfirst.frc.team5590.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Test command for driving the robot straight in autonomous
 */
public class StraightAutoGroup extends CommandGroup {
	private ArrayList LIST;
	private static double [] pos;
	

    public StraightAutoGroup(double [] pos1) {
    	LIST = new ArrayList <Command>();
    	pos = pos1;
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	 //NEW
    	//addSequential(new Drive(.4, 3, 10, 0, gyroSPI));
    	//LIST.add(new Drive(.4, 3, 10, 0, gyroSPI)); //must be added
    	//calc(new Drive(.4, 3, 10, 0, gyroSPI), 0);
    	
    	//addSequential(new Orient(90, gyroSPI));
    	
    	//YESTmoERDAY
    	
    	addSequential(new TimedDrive(.4,3, pos)); //59"
    	//LIST.add(new TimedDrive(.4,3, pos));
    	//calc(new TimedDrive(.4,3, pos), 155);
    	
    	addSequential(new TurnAng(45));
    	//LIST.add (new TurnAng(45, gyroSPI));
    	//calc(new TimedDrive(.4,3), 155);//turn 45 so now at 45
    	addSequential(new TimedDrive(.4,3, pos));
    	addSequential(new RTBAutoGroup(pos));
    	
    	//LIST.add(new TimedDrive(.4,3, pos));
    	//addSequential(calc(new TimedDrive(.4,3), 155));
    	//calc(new TimedDrive(.4,3, pos), 155);//59"
    	//calc(new TimedDrive(.4,3), 155);
    	
    	//addSequential(new GearPusherAutoCommand());
    	//LIST.add(new TimedDrive(.4,3));
    	
    	
    	//addSequential(new ReturnAutoGroup(gyroSPI, Ranger, LIST));
    	//addSequential(new TurnAng(180,gyroSPI));
    	//LIST.add(new TurnAng(180,gyroSPI));
    	//addSequential(new TimedDrive(.4,2));
    	//LIST.add(new TimedDrive(.4,2));
    	//addSequential(new TurnAng(90,gyroSPI));
    	//LIST.add(new TurnAng(90,gyroSPI));
    	//addSequential(new ReturnAutoGroup (gyroSPI, Ranger, LIST));
    	
    	//this looks like it only goes for some time
    	
    	
    }
    

	public static void calc (Command now, double ang)
    {
    	
    		if (now.toString().substring(0, 10).equals("TimedDrive")) //try timed drive and pass ang 155 for test (should not matter)
    		{
    			int firstSpace = now.toString().indexOf(" ");
    			int secondSpace = now.toString().indexOf(" ", firstSpace + 1);
 
    			double speed = Double.parseDouble(now.toString().substring(firstSpace+1, secondSpace)); //other way
    			double time = Double.parseDouble(now.toString().substring(secondSpace+1, now.toString().length()));
    			double angle = Robot.gyroSPI.getAngle(); //0 now 90 forward
    			double realAngle = 90 - angle;
    			double distance = 0;
    			
    			if (speed == 0.4)
    			{
    				distance = (20.1*time) - 1.5;
    			}
    			else if (speed == 0.5)
    			{
    				distance = (33.7*time) - 1.5;
    			}
    			else if (speed == 0.6)
    			{
    				distance = (50.4*time) - 1.0;
    			}
    			pos [0] = pos[0] + (Math.cos (Math.toRadians(realAngle)) * distance);
    			pos [1] = pos[1] + (Math.sin (Math.toRadians(realAngle)) * distance);
    			System.out.println(distance);
    			System.out.println("THE CURRENT ANG IS: " + realAngle);
    		}
    		
    		//System.out.println(pos[0] + " " + pos [1]);
    		double dia = Math.sqrt((pos[0] * pos[0]) + (pos[1] * pos[1]));
    		System.out.println("The distance is :" + dia); //really about 90
    		
    		System.out.println("Total X: " + pos [0] + "Total Y: " + pos[1]); 
    		 
    	}
    }
