/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubSystem extends SubsystemBase {
  VictorSP intakeMotor;
  ShuffleboardTab tab = Shuffleboard.getTab("Intake");
  NetworkTableEntry intakeMotorSpeed = tab.add("Intake", 0).getEntry();
  //double motorSpeed = -0.3;
  /**
   * Creates a new IntakeSubSystem.
   */
  public IntakeSubSystem() {
    intakeMotor = new VictorSP(Constants.intake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void inMotor(){
    intakeMotor.set(intakeMotorSpeed.getDouble(0));
  }

  public void outMotor(){
    intakeMotor.set(intakeMotorSpeed.getDouble(0) * -1.0);
  }

  public void stopMotor(){
    intakeMotor.set(0.0);
  }
}
