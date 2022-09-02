// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import org.carlmontrobotics.lib199.MotorControllerFactory;
import org.carlmontrobotics.lib199.MotorErrors.TemperatureLimit;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private final CANSparkMax motor1 = MotorControllerFactory.createSparkMax(19, TemperatureLimit.NEO);
    private final CANSparkMax motor2 = MotorControllerFactory.createSparkMax(20, TemperatureLimit.NEO);
    private double cons=.55;
    /** Creates a new ExampleSubsystem. */
    public Shooter() {
        motor1.setIdleMode(IdleMode.kCoast);
        motor2.setIdleMode(IdleMode.kCoast);
        motor2.follow(motor1, true);
        SmartDashboard.putData("balljackrate",500);
    }

    private void gtfopid(double dist, double cons){
      this.cons=cons
      double sped = motor1.getEncoder().getVelocity()*cons;
      SmartDashboard.putData("balljackrate",sped);
    }
    private void gtfopid(double dist){
      double sped = motor1.getEncoder().getVelocity()*this.cons;
      SmartDashboard.putData("balljackrate",sped);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        motor1.getPIDController().setReference(SmartDashboard.getData("balljackrate"), CANSparkMax.ControlType.kVelocity);
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public void setSpeed(double speed) {
        motor1.getPIDController().setReference(speed, CANSparkMax.ControlType.kVelocity);
    }

}
