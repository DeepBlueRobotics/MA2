// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import org.carlmontrobotics.lib199.MotorControllerFactory;
import org.carlmontrobotics.lib199.MotorErrors.TemperatureLimit;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeFeeder extends SubsystemBase {
  /** Creates a new Intake. */
  private final CANSparkMax intakeMotor = MotorControllerFactory.createSparkMax(Constants.MotorPorts.intakeSparkMax, TemperatureLimit.NEO);
  private final CANSparkMax feeder = MotorControllerFactory.createSparkMax(Constants.MotorPorts.feederSparkMax, TemperatureLimit.NEO_550);
  private final CANSparkMax treadmill = MotorControllerFactory.createSparkMax(Constants.MotorPorts.treadmill, TemperatureLimit.NEO_550);
  
  public final double intakeSpeed = 0.2;
  public final double feederSpeed = 0.3;
  public final double treadmillSpeed = 0.3;

  public final double intakeRegSpeed = -0.1;
  public final double feederRegSpeed = -0.1;
  public final double treadmillRegSpeed = -0.3;

  public final double plantSpeed = 0.05;

  public static boolean intakeToggle = true;

  public IntakeFeeder() {
    // intakeMotor.setInverted(true);
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
      intakeMotor.set(intakeSpeed);
      feeder.set(feederSpeed);
      treadmill.set(treadmillSpeed);
    } else {
      intakeOff();
    }
  }

  public void intakeOff() {
    intakeMotor.set(0);
    feeder.set(0);
    treadmill.set(0);
  }

  public void plantIntake() {
    intakeMotor.set(plantSpeed);
    feeder.set(0);
    treadmill.set(0);
  }

  public void regurgitatePlant() {
    intakeMotor.set(-plantSpeed);
    feeder.set(0);
    treadmill.set(0);
  }

  public void regurgitate() {
    intakeMotor.set(intakeRegSpeed);
    feeder.set(feederRegSpeed);
    treadmill.set(treadmillRegSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake RPM", intakeMotor.getEncoder().getVelocity());
    SmartDashboard.putNumber("Feeder RPM", feeder.getEncoder().getVelocity());
    SmartDashboard.putNumber("Treadmill RPM", treadmill.getEncoder().getVelocity());
  }
}
