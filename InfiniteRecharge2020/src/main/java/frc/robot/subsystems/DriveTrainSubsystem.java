/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMVictorSPX;;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.*;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveTrainSubsystem.
   */
  DifferentialDrive m_drive; 
  PWMVictorSPX m_leftMotor;
  PWMVictorSPX m_rightMotor;
  public DriveTrainSubsystem() {
    m_leftMotor = new PWMVictorSPX(Constants.driveLeft);
    m_rightMotor = new PWMVictorSPX(Constants.driveRight);
    m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
