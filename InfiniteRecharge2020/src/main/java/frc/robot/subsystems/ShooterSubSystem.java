/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.PWMSparkMax;
import frc.robot.*;
import edu.wpi.first.wpilibj.shuffleboard.*;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSubSystem extends SubsystemBase {
  PWMSparkMax top_Shooter;
  PWMSparkMax bottom_Shooter;
  //Double topMotorSpeed = 0.0;
  //Double bottomMotorSpeed = 0.0;
  ShuffleboardTab tab = Shuffleboard.getTab("Primary");
  NetworkTableEntry topMotorSpeed = tab.add("Top Shooter", 0).getEntry();
  NetworkTableEntry bottomMotorSpeed = tab.add("Bottom Shooter", 0).getEntry();
  /**
   * Creates a new ShooterSubSystem.
   */
  public ShooterSubSystem() {
      top_Shooter = new PWMSparkMax(Constants.shooterHigh);
      bottom_Shooter = new PWMSparkMax(Constants.shooterLow);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //Put the values that are read onto the shuffleboard. 


  }

  public void startMotors(){
    top_Shooter.set(0.2);
    bottom_Shooter.set(-0.2);
    //SmartDashboard.putNumber("Top Motor", topMotorSpeed.getDouble(0));
    //SmartDashboard.putNumber("Bottom Motor", bottomMotorSpeed.getDouble(0));
  }

  public void stopMotors(){
    top_Shooter.set(0);
    bottom_Shooter.set(0);
    //SmartDashboard.putNumber("Top Motor", 0);
    //SmartDashboard.putNumber("Bottom Motor", 0);
  }
}
