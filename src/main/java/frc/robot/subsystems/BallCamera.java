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
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;

public class BallCamera extends SubsystemBase {

    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private int bcount=0;
    private int rcount=0;
    private bool bwait=false;
    private bool rwait=false;
    /** Creates a new ExampleSubsystem. */
    public BallCamera() {
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        Color red = m_colorSensor.getRed();
        Color blu = m_colorSensor.getBlue();
        if (red>200 && rwait==false){
          rcount+=1;
          rwait=true;
        }else if (blu>200 && bwait==false){
          bcount+=1;
          bwait=true;
        }else{
           if (red<150){
             rwait=false;
           }
           if (blu<150){
             bwait=false;
           }
        }
        SmartDashboard.putNumber("Red balls?", rcount);
        SmartDashboard.putNumber("Blue balls?", bcount);
        SmartDashboard.putNumber("Red?", red);
        SmartDashboard.putNumber("Blue?", blue);

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

}
