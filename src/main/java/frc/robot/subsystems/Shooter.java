package frc.robot.subsystems;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private CANSparkMax motor = MotorControllerFactory.createSparkMax();

  public Shooter() 
  {
    SmartDashboard.putnumber("Shooter motor speed", 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    motor.set(SmartDashboard.getnumber("Shooter motor speed", 0));
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  // spped of which the ball is fired
  public void setShootingSpeed()
{

  
}

public void angleChange()
{
  
}


}
