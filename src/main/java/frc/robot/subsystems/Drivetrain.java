// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import org.carlmontrobotics.lib199.MotorControllerFactory;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final CANSparkMax left = MotorControllerFactory.createSparkMax(Constants.MotorPorts.leftDriveSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax right = MotorControllerFactory.createSparkMax(Constants.MotorPorts.rightDriveSparkMax, Constants.DriveConstants.motorTempLimit);
  
  private final DifferentialDrive drive;
  
  private final Joystick leftJoy;
  private final Joystick rightJoy;
  
  private final double plantModifier = 0.3;
  private final double autoSpeed = 0.5;
  
  private boolean isTank = true;

  public Drivetrain(Joystick leftJoy, Joystick rightJoy) {
    right.setInverted(true);
    drive = new DifferentialDrive(left, right);
    this.leftJoy = leftJoy;
    this.rightJoy = rightJoy;
  }

  public void drive() {
    if (isTank == true) {
      drive.tankDrive(leftJoy.getY(), rightJoy.getY());
    } else {
      drive.arcadeDrive(leftJoy.getY(), rightJoy.getX());
    }
  }

  public void autoDrive() {
    drive.tankDrive(autoSpeed, autoSpeed);
  }

public void plantDrive() {
  if (isTank == true) {
    drive.tankDrive(leftJoy.getY() * plantModifier, rightJoy.getY() * plantModifier);
  } else {
    drive.arcadeDrive(leftJoy.getY() * plantModifier, rightJoy.getX() * plantModifier);
  }
}

  public void switchMode() {
    if (isTank == true) {
      isTank = false;
    } else {
      isTank = true;
    }
  }

  public void stop() {
    drive.stopMotor();
  }

  public double getRotations() {
    return left.getEncoder().getPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left RPM", left.getEncoder().getVelocity());
    SmartDashboard.putNumber("Right RPM", right.getEncoder().getVelocity());
  }
}
