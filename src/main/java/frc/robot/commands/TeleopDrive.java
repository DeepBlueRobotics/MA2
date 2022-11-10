// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  /** Creates a new TeleopDrive. */
  private static enum DriveMode {TANK, ARCADE}
  private static DriveMode mode = DriveMode.TANK;

  private final Drivetrain dt;

  private final Joystick leftJoy;
  private final Joystick rightJoy;

  public TeleopDrive(Drivetrain drivetrain, Joystick left, Joystick right) {
    addRequirements(dt = drivetrain);
    leftJoy = left;
    rightJoy = right;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (mode == DriveMode.TANK) {
      dt.tankDrive(leftJoy.getY(), rightJoy.getY());
    } else {
      dt.arcadeDrive(leftJoy.getY(), rightJoy.getX());
    }
  }

  public static void switchMode() {
    if (mode == DriveMode.TANK) {
      mode = DriveMode.ARCADE;
    } else {
      mode = DriveMode.TANK;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
