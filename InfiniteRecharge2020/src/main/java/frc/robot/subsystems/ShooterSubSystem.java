/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.*;
import edu.wpi.first.wpilibj.shuffleboard.*;


public class ShooterSubSystem extends SubsystemBase {
  PWMVictorSPX top_Shooter;
  PWMVictorSPX bottom_Shooter;
  //Double topMotorSpeed = 0.0;
  //Double bottomMotorSpeed = 0.0;
  ShuffleboardTab tab = Shuffleboard.getTab("Test Shooter");
  NetworkTableEntry topMotorSpeed = tab.add("Top Shooter", 0).getEntry();
  NetworkTableEntry bottomMotorSpeed = tab.add("Bottom Shooter", 0).getEntry();
 

  /**
   * Creates a new ShooterSubSystem.
   */
  public ShooterSubSystem() {
      top_Shooter = new PWMVictorSPX(Constants.shooterHigh);
      bottom_Shooter = new PWMVictorSPX(Constants.shooterLow);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //Put the values that are read onto the shuffleboard. 
  }

  public void startMotors(){
    top_Shooter.set(topMotorSpeed.getDouble(0));
    bottom_Shooter.set(bottomMotorSpeed.getDouble(0));
  }

  public void stopMotors(){
    top_Shooter.set(0);
    bottom_Shooter.set(0);
  }
}
