// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Autonomous;
import frc.robot.commands.PickupPlant;
import frc.robot.commands.Intake;
import frc.robot.commands.Regurgitate;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeFeederTreadmill;
import frc.robot.Constants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public final Joystick leftJoy = new Joystick(Constants.OI.LeftJoy.port);
  public final Joystick rightJoy = new Joystick(Constants.OI.RightJoy.port);
  public final Joystick controller = new Joystick(Constants.Controller.port);

  private final Drivetrain dt = new Drivetrain();
  private final IntakeFeederTreadmill intake = new IntakeFeederTreadmill();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindingsLeftJoy();
    configureButtonBindingsRightJoy();

    dt.setDefaultCommand(new TeleopDrive(dt, leftJoy, rightJoy));
    intake.setDefaultCommand(new Intake(intake));
    // CommandScheduler.getInstance().schedule(new Intake(intake));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindingsLeftJoy() {
    new JoystickButton(leftJoy, Constants.OI.LeftJoy.toggleMode).whenPressed(new InstantCommand(() -> TeleopDrive.switchMode()));
    new JoystickButton(leftJoy, Constants.OI.LeftJoy.plantIntake).whenPressed(new PickupPlant(intake, dt, leftJoy, rightJoy));
  }
  private void configureButtonBindingsRightJoy() {
    new JoystickButton(rightJoy, Constants.OI.RightJoy.regurgitate).whileHeld(new Regurgitate(intake));
    new JoystickButton(rightJoy, Constants.OI.RightJoy.intakeToggle).whenPressed(new InstantCommand(() -> Intake.onOff()));
  }

  private void configureButtonBindingsController() { // Idk what the problem is here.
    new JoystickButton(controller, Constants.Controller.toggleMode).whenPressed(new InstantCommand(() -> TeleopDrive.switchMode()));
    new JoystickButton(controller, Constants.Controller.plantIntake).whenPressed(new PickupPlant(intake, dt, leftJoy, rightJoy));
    new JoystickButton(controller, Constants.Controller.regurgitate).whileHeld(new Regurgitate(intake));
    new JoystickButton(controller, Constants.Controller.intakeToggle).whenPressed(new InstantCommand(() -> Intake.onOff()));
  }

  public Command getAutonomousCommand() {
    return new Autonomous(dt, 55);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
