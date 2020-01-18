/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ElevatorCommand extends Command {
  int level = 1;
  private boolean toggleY = true;
  private boolean toggleX = true;
  private boolean toggleA = true;
  private boolean toggleB = true;
  private DigitalInput FLirSensor;
  private DigitalInput FRirSensor;
  private DigitalInput BRirSensor;
  private DigitalInput BLirSensor;
  public ElevatorCommand() {
   requires(Robot.elevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
     FLirSensor = new DigitalInput(RobotMap.FLinfraredSensor);
     FRirSensor = new DigitalInput(RobotMap.FRinfraredSensor);
     BRirSensor = new DigitalInput(RobotMap.BRinfraredSensor);
     BLirSensor = new DigitalInput(RobotMap.BLinfraredSensor);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(toggleA && OI.copilotController.isAButtonPressed()) // Go to Level 2
    {
      toggleA = false;
      Robot.elevatorSubsystem.goToLevel2(); 
      level = 2;   
    }
    else if(!OI.pilotController.isAButtonPressed())
    {
      toggleA = true;
    }

    if(toggleB && OI.copilotController.isBButtonPressed()) // Go to Level 3
    {
      toggleB = false;
      Robot.elevatorSubsystem.goToLevel3();    
      level = 3;
    }
    else if(!OI.pilotController.isBButtonPressed())
    {
      toggleB = true;
    }

    if(toggleX && OI.copilotController.isXButtonPressed()) //Go to Level 4 
    {
      toggleX = false;
      Robot.elevatorSubsystem.goToLevel4();
      level = 4;
    }
    else if(!OI.pilotController.isXButtonPressed())
    {
      toggleX = true;
    } 

    if(toggleY && OI.copilotController.isYButtonPressed()) //Go to Level 5
    {
      toggleY = false;
      Robot.elevatorSubsystem.goToLevel5();
      level = 5;
    }
    else if(!OI.pilotController.isYButtonPressed())
    {
      toggleY = true;
    }
    SmartDashboard.putNumber("Elevator:", Robot.elevatorSubsystem.getElevatorEncoder());
    SmartDashboard.putNumber("Level:", level);
    SmartDashboard.putBoolean("FLInfrared", !(FLirSensor.get()));
    SmartDashboard.putBoolean("FRInfrared", !(FRirSensor.get()));
    SmartDashboard.putBoolean("BRInfrared", !(BRirSensor.get()));
    SmartDashboard.putBoolean("BLInfrared", !(BLirSensor.get()));
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
