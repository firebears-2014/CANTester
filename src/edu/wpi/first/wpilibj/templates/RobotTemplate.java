/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.can.*;
import java.util.Vector;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {

	// DriverStation ds;
	// Joystick rstick;
	// Joystick lstick;
	CANJaguar frontl, rearl, frontr, rearr, extra1, extra2, extra3, extra4,
			extra5, extra6, extra7;
	RobotDrive drive;
	// Timer time;
	boolean printtime;
	int Test_Jag;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		Vector list = new Vector();
		for (Test_Jag = 1; Test_Jag <= 63; Test_Jag++) {

			try {
				// System.out.println("Initialization started");
				// time = new Timer();
				// ds = DriverStation.getInstance();
				// rstick = new Joystick(1);
				Thread.sleep(100);
				extra1 = new CANJaguar(Test_Jag);
				list.addElement(new Integer(Test_Jag));
				System.out.println("FOUND Jag ID = " + Test_Jag
						+ "  ***************");
				// Timer.delay(.5d);
				printStats();
				// Timer.delay(.5d);
			} catch (Exception ex) {
				System.out.println("NO JAGUAR " + Test_Jag);
				// Timer.delay(.5d);
				// ex.printStackTrace();

			} 
				
		}
		System.out.println("*** Found: " + list);
	}

	public void autonomousInit() {
		// time.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Watchdog.getInstance().feed();
		// printStats();

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Watchdog.getInstance().feed();
		// printStats();
	}

	public void disabledInit() {
		Watchdog.getInstance().feed();
		// printStats();
	}

	public void disabledPeriodic() {
		Watchdog.getInstance().feed();
		// printStats();
	}

	protected void printStats() {
		try {
			System.out.print(extra1.getBusVoltage());
			System.out.print("V  Out: ");
			System.out.print(extra1.getOutputVoltage());
			System.out.print("V  Temp: ");
			System.out.print(extra1.getTemperature());
			System.out.print(" degC Limits (f,r):");
			System.out.print(extra1.getForwardLimitOK());
			System.out.print(" " + extra1.getReverseLimitOK() + " Current: ");
			System.out.println(extra1.getOutputCurrent());
		} catch (CANTimeoutException ex) {
			ex.printStackTrace();
			System.out.println("Failure");
		}

	}
	// protected void drivePulse(double multiplier) {
	// if (time.get()%2000 <= 1000){
	// drive.drive(multiplier,0.0);
	// } else {
	// drive.drive(0.0,0.0);
	// }
	// }
	// protected void motorPulse(CANJaguar motor, double multiplier) {
	// if (time.get()%2000 <= 1000){
	// motor.set(multiplier);
	// } else {
	// motor.set(0.0);
	// }
	// }
}
