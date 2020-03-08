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
import frc.robot.subsystems.IntakeSubSystem;

public class IntakeCommand extends CommandBase {
  private final ChuteSubSystem chuteSubSystem;
  private final IntakeSubSystem intakeSubSystem;
  private double timerDelay = 3.0;
  private Timer timer = new Timer();
  /**
   * Creates a new IntakeCommand.
   */
  public IntakeCommand(ChuteSubSystem chuteSubsystem, IntakeSubSystem intakeSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    chuteSubSystem = chuteSubsystem;
    intakeSubSystem = intakeSubsystem;
    addRequirements(chuteSubsystem);
    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    intakeSubSystem.inMotor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() >= timerDelay){
      chuteSubSystem.upMotor();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubSystem.stopMotor();
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
