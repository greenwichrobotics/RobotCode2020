/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a sample program demonstrating how to use an ultrasonic sensor and
 * proportional control to maintain a set distance from an object.
 */

public class Robot extends TimedRobot {
  // distance in inches the robot wants to stay from an object
   // proportional speed constant
  private static final int kAnalog1 = 1;
  private static final int kAnalog3 = 3;

  private final AnalogInput m_analog1 = new AnalogInput(kAnalog1);
  private final AnalogInput m_analog3 = new AnalogInput(kAnalog3);

  /**
   * Tells the robot to drive to a set distance (in inches) from an object
   * using proportional control.
   */
  @Override
  public void teleopPeriodic() {
  //  SmartDashboard.putNumber("Analog1", m_analog1.getVoltage()/0.00977);
  //  SmartDashboard.putNumber("Analog3", m_analog3.getVoltage()/0.00977);
  double sensorValue = m_analog1.getVoltage();
    final double scaleFactor = 1/(5./1024.); //scale converting voltage to distance
    double distance = 5*sensorValue*scaleFactor; //convert the voltage to distance
    SmartDashboard.putNumber("Analog 1", distance); //write the value to the LabVIEW DriverStation  
  }
}
