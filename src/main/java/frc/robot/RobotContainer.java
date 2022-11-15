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

  private final Drivetrain dt = new Drivetrain();
  private final IntakeFeederTreadmill intake = new IntakeFeederTreadmill();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindingsLeftJoy();
    configureButtonBindingsRightJoy();

    dt.setDefaultCommand(new TeleopDrive(dt, leftJoy, rightJoy));
    intake.setDefaultCommand(new Intake(intake));

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
  }
  public static final class Controller {
    public static final int port = 2;

    public static Joystick controller = new Joystick(port);

    public static int X;
    public static int A;
    public static int B;
    public static int Y;
    public static int LB;
    public static int RB;
    public static int LT;
    public static int RT;
    public static int BACK;
    public static int START;

    static {
            // Buttons and triggers for xbox controller
            X = 3;
            A = 1;
            B = 2;
            Y = 4;
            LB = 5;
            RB = 6;
            LT = 7;
            RT = 8;
            BACK = 9;
            START = 10;
        }
          public static final int toggleMode = Y; // TODO: set correct port
          public static final int runIntakeBackwardPort = A; // TODO: set correct port
          public static final int regurgitatePort = B;
          public static final int dumbModeToggle = START;
          public static final int toggleIntakePort = X;
          public static final int extendClimberPort = RB;
          public static final int retractClimberPort = LB;
      }
      private void configureButtonBindingsController() {
        new JoystickButton(controller, Constants.OI.Controller.toggleMode)whenPressed(new InstantCommand(() -> TeleopDrive.switchMode()));
        new JoystickButton(controller, Constants.OI.Controller.plantIntake).whenPressed(new PickupPlant(intake, dt, leftJoy, rightJoy));
        new JoystickButton(controller, Constants.OI.Controller.regurgitate).whileHeld(new Regurgitate(intake));
        new JoystickButton(controller, Constants.OI.Controller.).whenPressed(new InstantCommand(intakeFeeder::toggleDumbMode, intakeFeeder));
        new JoystickButton(controller, Constants.OI.Controller.).whenPressed(new InstantCommand(intakeFeeder::toggleIntake, intakeFeeder));
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
