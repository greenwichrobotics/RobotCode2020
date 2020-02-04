/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.RobotMap;

public class ExampleSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private static final AnalogInput mb1013 = new AnalogInput(RobotMap.ultrasonic);
	private static final double VOLTS_TO_DIST = 1.0;

	public static double getVoltage() {
		return mb1013.getVoltage();
	}
	
	public static double getDistance() {
		return getVoltage() * VOLTS_TO_DIST;
	}


  public ExampleSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
