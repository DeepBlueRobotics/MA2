// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import org.carlmontrobotics.lib199.MotorControllerFactory;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private final CANSparkMax left = MotorControllerFactory.createSparkMax(2, 30);
  private final CANSparkMax right = MotorControllerFactory.createSparkMax(2, 30);
  
  public Drivetrain() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
