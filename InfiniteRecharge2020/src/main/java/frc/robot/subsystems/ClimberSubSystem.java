/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubSystem extends SubsystemBase {
  Spark climberMotorX1;
  Spark climberMotorX2;
  ShuffleboardTab tab = Shuffleboard.getTab("Climber");
  NetworkTableEntry x1MotorSpeed = tab.add("X1 Motor", 0).getEntry();
  NetworkTableEntry x2MotorSpeed = tab.add("X2 Motor", 0).getEntry();
  //double motorSpeed = 1.0;
 // double reducer = 0.972;
  
  /**
   * Creates a new ClimberSubSystem.
   */
  public ClimberSubSystem() {
    climberMotorX1 = new Spark(Constants.climberX1);
    climberMotorX2 = new Spark(Constants.climberX2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void upMotor(){
    climberMotorX1.set(x1MotorSpeed.getDouble(0));
    climberMotorX2.set(x2MotorSpeed.getDouble(0));
  }

  public void downMotor(){
    climberMotorX1.set(x1MotorSpeed.getDouble(0) * -1.0);
    climberMotorX2.set(x2MotorSpeed.getDouble(0) * -1.0);
  }

  public void stopMotor(){
    climberMotorX1.set(0.0);
    climberMotorX2.set(0.0);
  }
}
