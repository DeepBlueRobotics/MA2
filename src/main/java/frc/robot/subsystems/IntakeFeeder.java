// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static org.mockito.ArgumentMatchers.contains;

import com.revrobotics.CANSparkMax;

import org.carlmontrobotics.lib199.MotorControllerFactory;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeFeeder extends SubsystemBase {
  /** Creates a new Intake. */
  private final CANSparkMax leftIntakeMotor = MotorControllerFactory.createSparkMax(Constants.MotorPorts.leftIntakeSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax rightIntakeMotor = MotorControllerFactory.createSparkMax(Constants.MotorPorts.rightIntakeSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax feeder = MotorControllerFactory.createSparkMax(Constants.MotorPorts.feederSparkMax, Constants.DriveConstants.motorTempLimit);
  private final CANSparkMax treadmill = MotorControllerFactory.createSparkMax(Constants.MotorPorts.treadmill, Constants.DriveConstants.motorTempLimit);
  


  public IntakeFeeder() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
