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
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ChuteSubSystem extends SubsystemBase {
  Spark chuteMotor;
  ShuffleboardTab tab = Shuffleboard.getTab("Chute");
  NetworkTableEntry chuteMotorSpeed = tab.add("Chute", 0).getEntry();
  //double motorSpeed = -0.3;
  /**
   * Creates a new ChuteSubSystem.
   */
  public ChuteSubSystem() {
    chuteMotor = new Spark(Constants.chute);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void upMotor(){
    chuteMotor.set(chuteMotorSpeed.getDouble(0));
  }

  public void downMotor(){
    chuteMotor.set(chuteMotorSpeed.getDouble(0) * -1);
  }

  public void stopMotor(){
    chuteMotor.set(0.0);
  }
}
