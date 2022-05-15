package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.util.Led;

public class LEDController extends SubsystemBase{
  public final PWMSparkMax LedController;

  public LEDController(){
    this.LedController = new PWMSparkMax(Constants.LEDPORT);
    //this.LEDCONTROLLER.setVoltage(5.0);
  }

  public void setColor(Led color){
    //this.LEDCONTROLLER.setVoltage(5.0);
    this.LedController.set(color.getValue());
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
