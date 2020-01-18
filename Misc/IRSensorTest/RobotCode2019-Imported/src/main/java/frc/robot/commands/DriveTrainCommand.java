/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;

public class DriveTrainCommand extends Command {
  //get this from the screen
  double speedX = 0.9;
  // SmartDashboard.putNumber("Speed Factor:", speedX);
  public DriveTrainCommand() {
    requires(Robot.driveTrainSubSystem);
    //requires(Robot.ultrasonicSubSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   Robot.driveTrainSubSystem.arcadeDrive(OI.pilotController.getSquared(OI.pilotController.getTriggerValue())*speedX, OI.pilotController.getSquared(OI.pilotController.getLeftStickX()));
    // Robot.driveTrainSubSystem.arcadeDrive(OI.pilotController.getTriggerValue() * OI.pilotController.getTriggerValue(), 
    //                                         OI.pilotController.getLeftStickX() * OI.pilotController.getLeftStickX());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
