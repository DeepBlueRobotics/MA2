// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import org.carlmontrobotics.lib199.MotorControllerFactory;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final CANSparkMax left = MotorControllerFactory.createSparkMax(Constants.DrivePorts.lSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax right = MotorControllerFactory.createSparkMax(Constants.DrivePorts.rSparkMax, Constants.DriveConstants.motorTempLimit);
  
  public Drivetrain() {
    right.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left RPM", left.getEncoder().getVelocity());
    SmartDashboard.putNumber("Right RPM", right.getEncoder().getVelocity());
  }

  public void runLeft(double speed) {
    left.set(speed);
  }

  public void runRight(double speed) {
    right.set(speed * -1);
  }

  public void stop() {
    right.set(0);
    left.set(0);
  }
}
