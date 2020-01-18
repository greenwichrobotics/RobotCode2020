/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class HatchCommand extends Command {
    private boolean toggleRB = true;
    private boolean toggleLB = true;
    
    public HatchCommand(){
        requires(Robot.hatchSubSystem);
    }

    @Override
    protected void initialize() {
      //  motor.set(1);
    }

    @Override
    protected void execute() {
    if(OI.copilotController.isRBButtonPressed()) // Move out
    {
      //toggleRB = false;
      //Call subroutine to move arm out
      Robot.hatchSubSystem.moveOut();
    }
    else if(OI.copilotController.isLBButtonPressed())
    {
      Robot.hatchSubSystem.moveIn();
    }
     else if(!OI.copilotController.isRBButtonPressed() && !OI.copilotController.isLBButtonPressed()){
       Robot.hatchSubSystem.stop();
      //toggleRB = true;
    }
    else{
      Robot.hatchSubSystem.stop();
    }
  }

    @Override
    protected void end() {
       // Robot.hatchSubSystem.stop();
    }

  @Override
  protected boolean isFinished() {
    return false;
  }
}