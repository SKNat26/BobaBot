package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
  
  //RightMotors
  private final WPI_TalonSRX RMOTOR1;
  private final WPI_TalonSRX RMOTOR2; 
  private final WPI_TalonSRX RMOTOR3;

  //LeftMotors
  private final WPI_TalonSRX LMOTOR1;
  private final WPI_TalonSRX LMOTOR2;
  private final WPI_TalonSRX LMOTOR3;

  //Speed Controller Groups
  private final MotorControllerGroup R_MOTORS;
  private final MotorControllerGroup L_MOTORS;

  //Diff Drive
  public final DifferentialDrive DIFF_DRIVE;
  public boolean isForward; 

  // TWIST COEFFICIENT
  public double twistCoefficient;

  public Drivetrain() {
    //Right motors
    this.RMOTOR1 = new WPI_TalonSRX(Constants.RM1PORT);
    this.RMOTOR2 = new WPI_TalonSRX(Constants.RM2PORT);
    this.RMOTOR3 = new WPI_TalonSRX(Constants.RM3PORT);
    
    //Left motors
    this.LMOTOR1 = new WPI_TalonSRX(Constants.LM1PORT);
    this.LMOTOR2 = new WPI_TalonSRX(Constants.LM2PORT);
    this.LMOTOR3 = new WPI_TalonSRX(Constants.LM3PORT);
    
    //Motors Groups
    R_MOTORS = new MotorControllerGroup(this.RMOTOR1, this.RMOTOR2, this.RMOTOR3);
    L_MOTORS = new MotorControllerGroup(this.LMOTOR1, this.LMOTOR2, this.LMOTOR3);

    //Diff drive
    DIFF_DRIVE = new DifferentialDrive(L_MOTORS, R_MOTORS);

    configureMotors();

  }

  public void configureMotors() {
    this.RMOTOR1.configFactoryDefault();
    this.RMOTOR2.configFactoryDefault();
    this.RMOTOR3.configFactoryDefault();
    this.LMOTOR1.configFactoryDefault();
    this.LMOTOR2.configFactoryDefault();
    this.LMOTOR3.configFactoryDefault();

    this.RMOTOR1.setNeutralMode(NeutralMode.Coast);
    this.RMOTOR2.setNeutralMode(NeutralMode.Coast);
    this.RMOTOR3.setNeutralMode(NeutralMode.Coast);
    this.LMOTOR1.setNeutralMode(NeutralMode.Coast);
    this.LMOTOR2.setNeutralMode(NeutralMode.Coast);
    this.LMOTOR3.setNeutralMode(NeutralMode.Coast);
  }

  public void driveRobot(Joystick joystick, boolean sensitivity){
    DIFF_DRIVE.arcadeDrive(joystick.getY(), joystick.getZ(), sensitivity);
  }

  public void stop(){
    DIFF_DRIVE.stopMotor();
  }

  public void ping(){}

  public boolean isAlive(){
    return true;
  }
}
