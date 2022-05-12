package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.extra.led;

public class LEDs extends SubsystemBase{
  public final PWMSparkMax LEDCONTROLLER;

  public LEDs(){
    this.LEDCONTROLLER = new PWMSparkMax(Constants.LEDPORT);
  }

  public void setColor(led color){
    LEDCONTROLLER.set(color.getValue());
  }

  public void turnOff(){
    LEDCONTROLLER.set(0.99);
  }

    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
