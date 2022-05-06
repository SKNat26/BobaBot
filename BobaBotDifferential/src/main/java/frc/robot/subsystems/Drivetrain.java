package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.ArrayList;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class Drivetrain extends SubsystemBase {
  
  //RightMotors
  private final TalonSRX RMOTOR1;
  private final TalonSRX RMOTOR2; 
  private final TalonSRX RMOTOR3;

  //LeftMotors
  private final TalonSRX LMOTOR1;
  private final TalonSRX LMOTOR2;
  private final TalonSRX LMOTOR3;

  //Speed Controller Groups
  private final MotorControllerGroup R_MOTORS;
  private final MotorControllerGroup L_MOTORS;

  //Diff Drive
  public final DifferentialDrive DIFF_DRIVE;
  public boolean isForward;  

  it // TWIST COEFFICIENT
  public double twistCoefficient;

  public Drivetrain() {
    //Right motors
    this.RMOTOR1 = new TalonSRX(0);
    this.RMOTOR2 = new TalonSRX(1);
    this.RMOTOR3 = new TalonSRX(2);
    //Left motors
    this.LMOTOR1 = new TalonSRX(3);
    this.LMOTOR2 = new TalonSRX(4);
    this.LMOTOR3 = new TalonSRX(5);

    
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
