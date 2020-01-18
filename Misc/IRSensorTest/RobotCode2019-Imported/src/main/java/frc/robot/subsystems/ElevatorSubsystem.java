/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ElevatorSubsystem extends Subsystem {
  Spark elevatorMotorController;
  Encoder elevatorEncoder;
  int level = 1;
  double upSpeed = 1.0;
  double downSpeed = 1.0;
  int level1 = 0; //Very Bottom
  int level2 = 800; //At hatch pickup and delivery
  int level3 = 1100; //At hatch remove and carry
  int level4 = 3000; //Middle hatch lower to deliver
  int level5 = 3300; //Middle hatch place

  public ElevatorSubsystem(){
    elevatorMotorController = new Spark(RobotMap.elevatorMotor); //todo: replace with elevator motor
    elevatorEncoder = new Encoder(RobotMap.elevatorEncoderA, RobotMap.elevatorEncoderB);
  }

  public void goToLevel1(){
    if(level > 1){
      goDown(level1);
      level = 1;
    }
  }

  public void goToLevel2(){
    if(level == 1){
      goUp(level2);
    }
    else if(level > 2){
      goDown(level2); 
    }
    level = 2;
  }

  public void goToLevel3(){
    if(level < 3){
      goUp(level3);
    }
    else if(level > 3){
      goDown(level3); 
    }
    level = 3;
  }

public void goToLevel4(){
    if(level < 4){
      goUp(level4);
    }
    else if(level > 4){
      goDown(level4); 
    }
    level = 4;
  }

public void goToLevel5(){
    if(level < 5){
      goUp(level5);
    }
    else if(level > 5){
      goDown(level5); 
    }
    level = 5;
  }


    public void goUp(int toLevel){
      while(elevatorEncoder.get() < toLevel){
        elevatorMotorController.set(upSpeed);
        SmartDashboard.putNumber("SubElevator:", elevatorEncoder.get());
      }
      elevatorMotorController.set(0.05);

    }
    
    public void goDown(int toLevel){
      while(elevatorEncoder.get() > toLevel){
        elevatorMotorController.set(-1*downSpeed);
        SmartDashboard.putNumber("SubElevator:", elevatorEncoder.get());
      }   
      elevatorMotorController.set(0.05);
    }

    public int getElevatorEncoder(){
      return elevatorEncoder.get();
    }

   
 
  @Override
  public void initDefaultCommand() {
    elevatorEncoder.reset();
    SmartDashboard.putNumber("SubElevator:", elevatorEncoder.get());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}