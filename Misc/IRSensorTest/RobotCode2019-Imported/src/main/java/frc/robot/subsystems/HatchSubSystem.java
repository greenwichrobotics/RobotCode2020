/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class HatchSubSystem extends Subsystem {
  VictorSP hatchMotorController;
  double hatchMotorSpeed = 1.0;

  public HatchSubSystem(){
    hatchMotorController = new VictorSP(RobotMap.hatchMotor);
  }

  public void moveOut()
  {
      hatchMotorController.set(hatchMotorSpeed);
  }

  public void moveIn()
  {
      hatchMotorController.set(-1 * hatchMotorSpeed);
  }

  public void stop()
  {
      hatchMotorController.set(0);
  }
  
    @Override
    protected void initDefaultCommand() {
    }
}