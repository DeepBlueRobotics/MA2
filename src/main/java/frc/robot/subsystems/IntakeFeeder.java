// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import org.carlmontrobotics.lib199.MotorControllerFactory;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeFeeder extends SubsystemBase {
  /** Creates a new Intake. */
  private final CANSparkMax leftIntakeMotor = MotorControllerFactory.createSparkMax(Constants.MotorPorts.leftIntakeSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax rightIntakeMotor = MotorControllerFactory.createSparkMax(Constants.MotorPorts.rightIntakeSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax feeder = MotorControllerFactory.createSparkMax(Constants.MotorPorts.feederSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax treadmill = MotorControllerFactory.createSparkMax(Constants.MotorPorts.treadmill, Constants.DriveConstants.motorTempLimit);
  
  public final double intakeSpeed = 0.8;
  public final double feederSpeed = 0.6;
  public final double treadmillSpeed = 0.3;

  public final double intakeRegSpeed = -0.8;
  public final double feederRegSpeed = -0.6;
  public final double treadmillRegSpeed = -0.4;

  public final double plantSpeed = 0.2;

  public static boolean intakeToggle = true;

  public IntakeFeeder() {
    rightIntakeMotor.setInverted(true);
    rightIntakeMotor.follow(leftIntakeMotor);

  }

  public void onOff() {
    if (intakeToggle == false) {
      intakeToggle = true;
    } else {
      intakeToggle = false;
    }
  }

  public void intake() {
    if (intakeToggle == true) {
      rightIntakeMotor.set(intakeSpeed);
      feeder.set(feederSpeed);
      treadmill.set(treadmillSpeed);
    } else {
      intakeOff();
    }
  }

  public void intakeOff() {
    rightIntakeMotor.set(0);
    feeder.set(0);
    treadmill.set(0);
  }

  public void plantIntake() {
    rightIntakeMotor.set(plantSpeed);
    feeder.set(0);
    treadmill.set(0);
  }

  public void regurgitate() {
    rightIntakeMotor.set(intakeRegSpeed);
    feeder.set(feederRegSpeed);
    treadmill.set(treadmillRegSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Intake RPM", leftIntakeMotor.getEncoder().getVelocity());
    SmartDashboard.putNumber("Right Intake RPM", rightIntakeMotor.getEncoder().getVelocity());
    SmartDashboard.putNumber("Feeder RPM", feeder.getEncoder().getVelocity());
    SmartDashboard.putNumber("Treadmill RPM", treadmill.getEncoder().getVelocity());
  }
}
