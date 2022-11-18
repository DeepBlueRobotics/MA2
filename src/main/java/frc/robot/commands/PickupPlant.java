// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeFeeder;

public class PickupPlant extends CommandBase {
  /** Creates a new DriveSlow. */
  private final Drivetrain dt;
  private final Joystick leftJoy;
  private final Joystick rightJoy;
  private final IntakeFeeder intake;

  public PickupPlant(IntakeFeeder intake, Drivetrain dt, Joystick leftJoy, Joystick rightJoy) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt, intake);
    this.dt = dt;
    this.leftJoy = leftJoy;
    this.rightJoy = rightJoy;
    this.intake = intake;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Constants.DriveConstants.mode == Constants.DriveConstants.DriveMode.TANK) {
      dt.tankDrive(leftJoy.getX() * Constants.DriveConstants.slowDriveMultiplier, rightJoy.getX() * Constants.DriveConstants.slowDriveMultiplier);
    } else {
      dt.arcadeDrive(leftJoy.getX() * Constants.DriveConstants.slowDriveMultiplier, rightJoy.getX() * Constants.DriveConstants.slowDriveMultiplier);
    }

    intake.plantIntake(Constants.DriveConstants.plantIntakeSpeed);
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
