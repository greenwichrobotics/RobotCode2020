/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import frc.robot.commands.DriveTrainCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubSystem;
//import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.ShooterSubSystem;
import frc.robot.subsystems.ChuteSubSystem;
import frc.robot.subsystems.ClimberSubSystem;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
//import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static edu.wpi.first.wpilibj.XboxController.Button;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final DriveTrainSubsystem m_driveTrainSubsystem = new DriveTrainSubsystem();
  private final ShooterSubSystem m_shooter = new ShooterSubSystem();
  private final ClimberSubSystem m_climber = new ClimberSubSystem();
  private final IntakeSubSystem m_intake = new IntakeSubSystem();
  private final ChuteSubSystem m_chute = new ChuteSubSystem();
  // private final DriveTrainCommand m_driveTrainCommand = new DriveTrainCommand(m_driveTrainSubsystem, null, null);

  XboxController m_pilotController = new XboxController(Constants.pilotControllerPort);
  XboxController m_copilotController = new XboxController(Constants.copilotControllerPort);
  SendableChooser<Command> m_chooser = new SendableChooser<>();


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // m_driveTrainSubsystem.setDefaultCommand(
    //   new DriveTrainCommand(
    //     m_driveTrainSubsystem, 
    //     () -> m_pilotController.getTriggerAxis(Hand.kRight)-m_pilotController.getTriggerAxis(Hand.kLeft),
    //     () -> m_pilotController.getX(Hand.kLeft)
    //   )
    //);
    m_driveTrainSubsystem.setDefaultCommand(
      new RunCommand(() -> m_driveTrainSubsystem.arcadeDrive(
        m_pilotController.getTriggerAxis(Hand.kRight)-m_pilotController.getTriggerAxis(Hand.kLeft), 
        m_pilotController.getX(Hand.kLeft)),m_driveTrainSubsystem));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //Shooter -------(Co-Pilot Hold A) ------------------------------------
    new JoystickButton(m_copilotController,Button.kA.value)
    .whenHeld(new InstantCommand(m_shooter::startMotors, m_shooter));
    new JoystickButton(m_copilotController,Button.kA.value)
    .whenReleased(new InstantCommand(m_shooter::stopMotors, m_shooter));

    // new JoystickButton(m_copilotController,Button.kB.value)
    // .whenHeld(new InstantCommand(m_shooter::stopMotors, m_shooter));

    //Climber ----------(Pilot Hold A climb, Hold B decend )---------------
    //Raise climber
    new JoystickButton(m_pilotController,Button.kA.value)
    .whenHeld(new InstantCommand(m_climber::upMotor, m_climber));
    new JoystickButton(m_pilotController,Button.kA.value)
    .whenReleased(new InstantCommand(m_climber::stopMotor, m_climber));
    //Lower climber
    new JoystickButton(m_pilotController,Button.kB.value)
    .whenHeld(new InstantCommand(m_climber::downMotor, m_climber));
    new JoystickButton(m_pilotController,Button.kB.value)
    .whenReleased(new InstantCommand(m_climber::stopMotor, m_climber));
    //Stop climber
    // new JoystickButton(m_pilotController,Button.kX.value)
    // .whenPressed(new InstantCommand(m_climber::stopMotor, m_climber));

    //Intake --------------(Pilot Hold X) ---------------------------
    new JoystickButton(m_pilotController,Button.kX.value)
    .whenHeld(new InstantCommand(m_intake::inMotor, m_intake));
    new JoystickButton(m_pilotController,Button.kX.value)
    .whenReleased(new InstantCommand(m_intake::stopMotor, m_intake));

    //Chute --------------(Pilot Hold Y) ---------------------------
    new JoystickButton(m_pilotController,Button.kY.value)
    .whenHeld(new InstantCommand(m_chute::upMotor, m_chute));
    new JoystickButton(m_pilotController,Button.kY.value)
    .whenReleased(new InstantCommand(m_chute::stopMotor, m_chute));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_chooser.getSelected();
  }
}
