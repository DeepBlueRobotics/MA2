// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  /** Creates a new TeleopDrive. */
  private final Drivetrain dt;
  private double spdL;
  private double spdR;

  public TeleopDrive(Drivetrain drivetrain, double spdL, double spdR) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt = drivetrain);
    this.spdL = spdL;
    this.spdR = spdR;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rawL, rawR;
    if (Math.abs(spdL) <= Constants.OI.JOY_THRESH) rawL = 0.0;
    else rawL = spdL;
    if (Math.abs(spdR) <= Constants.OI.JOY_THRESH) rawR = 0.0;
    else rawR = spdR;

    
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
