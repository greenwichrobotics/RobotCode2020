/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubSystem extends SubsystemBase {
  Spark climberMotor;
  double motorSpeed = 0.3;
  
  /**
   * Creates a new ClimberSubSystem.
   */
  public ClimberSubSystem() {
    climberMotor = new Spark(Constants.climber);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void upMotor(){
    climberMotor.set(motorSpeed);
  }

  public void downMotor(){
    climberMotor.set(motorSpeed * -1.0);
  }

  public void stopMotor(){
    climberMotor.set(0.0);
  }
}
