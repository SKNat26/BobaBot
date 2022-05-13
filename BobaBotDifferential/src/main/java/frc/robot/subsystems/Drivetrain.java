package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
    this.RMOTOR1 = new WPI_TalonSRX(Constants.RM1Port);
    this.RMOTOR2 = new WPI_TalonSRX(Constants.RM2Port);
    this.RMOTOR3 = new WPI_TalonSRX(Constants.RM3Port);
    
    //Left motors
    this.LMOTOR1 = new WPI_TalonSRX(Constants.LM1Port);
    this.LMOTOR2 = new WPI_TalonSRX(Constants.LM2Port);
    this.LMOTOR3 = new WPI_TalonSRX(Constants.LM3Port);
    
    //Motors Groups
    R_MOTORS = new MotorControllerGroup(this.RMOTOR1, this.RMOTOR2, this.RMOTOR3);
    L_MOTORS = new MotorControllerGroup(this.LMOTOR1, this.LMOTOR2, this.LMOTOR3);

    //Diff drive
    DIFF_DRIVE = new DifferentialDrive(L_MOTORS, R_MOTORS);

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
}
