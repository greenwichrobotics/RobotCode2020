/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class DriveTrainSubSystem extends Subsystem {
  DifferentialDrive m_drive;
	Spark m_frontLeft;
	Spark m_rearLeft;
	Spark m_frontRight;
	Spark m_rearRight;
	SpeedControllerGroup m_left;
	SpeedControllerGroup m_right;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DriveTrainSubSystem() {
    m_frontLeft = new Spark(RobotMap.frontLeft);
    m_rearLeft = new Spark(RobotMap.rearLeft);
    m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    m_frontRight = new Spark(RobotMap.frontRight);
    m_rearRight = new Spark(RobotMap.rearRight);
    m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    m_drive = new DifferentialDrive(m_left, m_right);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    m_drive.setSafetyEnabled(false);
    m_drive.arcadeDrive(xSpeed, zRotation);
  }
  public void curvatureDrive(double xSpeed, double zRotation, boolean isQuickTurn) {
    m_drive.curvatureDrive(xSpeed, zRotation, isQuickTurn);
  }
  public void stop() {
    m_drive.arcadeDrive(0.0, 0.0);
  }
  public void initDefaultCommand() {
    setDefaultCommand(new DriveTrainCommand());
  }
}
