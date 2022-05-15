package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.Constants;
import frc.robot.util.subsystems.MechanicalSubsystem;

public class WheelSpinner extends MechanicalSubsystem {
  
  //Motor
  private final WPI_TalonSRX WHEEL_MOTOR;

  public WheelSpinner() {

    //Motor
    this.WHEEL_MOTOR = new WPI_TalonSRX(Constants.WHEEL_MOTOR_PORT);
    // TODO sensor and elevator?

    configureMotors();
  }

  public void spin(){
    
  }

  public void shuffleBoard(){}

  public void configureMotors() {
    this.WHEEL_MOTOR.configFactoryDefault();
    this.WHEEL_MOTOR.setNeutralMode(NeutralMode.Brake);
  }

  public boolean stop(){
    this.WHEEL_MOTOR.stopMotor();
    return false;
  }

  public void ping(){}

  public boolean isAlive(){
    return true;
  }
}
