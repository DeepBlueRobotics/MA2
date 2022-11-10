// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class Autonomous extends CommandBase {
  /** Creates a new Autonomous. */
  private final Drivetrain dt;
  private final double rotationsNeeded;
  public Autonomous(Drivetrain dt, double distanceInches) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.dt = dt;
    rotationsNeeded = distanceInches / (Constants.DriveConstants.drivetrainRatio * (Constants.DriveConstants.wheelDiameter * Math.PI));
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (dt.getRotations() < rotationsNeeded) {
      dt.arcadeDrive(Constants.DriveConstants.autoSpeed, 0);
    } else {
      dt.stop();
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
