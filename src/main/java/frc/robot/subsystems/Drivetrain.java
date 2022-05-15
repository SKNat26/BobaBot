package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.Constants;
import frc.robot.util.subsystems.MechanicalSubsystem;


public class Drivetrain extends MechanicalSubsystem {
  
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
  private final double TWIST_COEFFICIENT;

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
    DIFF_DRIVE = new DifferentialDrive(R_MOTORS, L_MOTORS);

    //DRIVE VARIABLES
    this.TWIST_COEFFICIENT = 1.25;
    this.isForward = true;

    //TODO set group to inverted

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

  public void drive(Joystick joystick){

    double y = joystick.getY();
    double rotate = joystick.getTwist();

    if (!this.isForward){
      y = -y;
    }

    DIFF_DRIVE.arcadeDrive(y, rotate / TWIST_COEFFICIENT, false);
  }

  public void reverseDirection() {
    this.isForward = !isForward;
  }

  public void shuffleBoard(){}

  public boolean stop(){
    DIFF_DRIVE.stopMotor();
    return false;
  }

  public void ping(){}

  public boolean isAlive(){
    return true;
  }
}
