package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.Constants;
import frc.robot.util.subsystems.MechanicalSubsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class StrawShooter extends MechanicalSubsystem {
  
  //Motor and Beam
  private final WPI_TalonSRX STRAW_MOTOR;
  private final DigitalInput STRAW_BEAM;

  public StrawShooter() {
    
    this.STRAW_MOTOR = new WPI_TalonSRX(Constants.STRAW_MOTOR_PORT);
    this.STRAW_BEAM = new DigitalInput(Constants.STRAW_BEAM_PORT); 

    //TODO invert motors

    configureMotors();

  }

  public void shoot() {
    if (!strawPresent()) {
      this.STRAW_MOTOR.set(Constants.STRAW_MOTOR_SPEED);
    }
    // TODO use leds for effects, like turn red if straw is present
  }

  public void configureMotors() {
    this.STRAW_MOTOR.configFactoryDefault();
    this.STRAW_MOTOR.setNeutralMode(NeutralMode.Brake);
  }

  public boolean strawPresent() {
    return !STRAW_BEAM.get();
  }

  public void shuffleBoard(){}

  public boolean stop(){
    this.STRAW_MOTOR.stopMotor();
    return false;
  }

  public void ping(){}

  public boolean isAlive(){
    return true;
  }
}
