/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChuteSubSystem;
import frc.robot.subsystems.ShooterSubSystem;

public class ShooterCommand extends CommandBase {
  private final ShooterSubSystem shooterSubSystem;
  private final ChuteSubSystem chuteSubSystem;
  private double timerDelay = 3.0;
  private Timer timer = new Timer();
  /**
   * Creates a new ShooterCommand.
   */
  public ShooterCommand(ShooterSubSystem shooterSubsystem, ChuteSubSystem chuteSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooterSubSystem = shooterSubsystem;
    chuteSubSystem = chuteSubsystem;
    addRequirements(shooterSubsystem);
    addRequirements(chuteSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    shooterSubSystem.startMotors();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() >= timerDelay )
      {
        //Run the chute
        chuteSubSystem.upMotor();
      }
    //shooterSubSystem.showValues();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubSystem.stopMotors();
    chuteSubSystem.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public void interrupted(){
    end(true);
  }
}
