package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.util.subsystems.MechanicalSubsystem;
import frc.robot.util.Boba;
import frc.robot.util.Color;

public class WheelSpinner extends MechanicalSubsystem {
  
  //Motor and Input
  private final WPI_TalonSRX WHEEL_MOTOR;
  private final WPI_TalonSRX ELEVATOR_MOTOR;
  private final DigitalInput WHEEL_BEAM;
  private final DigitalInput ELEVATOR_UPPER_LIMIT;
  private final DigitalInput ELEVATOR_LOWER_LIMIT;

  //Inventory and Choosers
  private final ArrayList<SendableChooser<Boba>> choosers;
  private final Boba[] inventory;

  private int currentSlot;
  private boolean previousBobaPresent;

  public WheelSpinner() {

    //Motor and Beam
    this.WHEEL_MOTOR = new WPI_TalonSRX(Constants.WHEEL_MOTOR_PORT);
    this.WHEEL_BEAM = new DigitalInput(Constants.WHEEL_BEAM_PORT);
    this.ELEVATOR_MOTOR = new WPI_TalonSRX(Constants.ELEVATOR_MOTOR_PORT);
    this.ELEVATOR_UPPER_LIMIT = new DigitalInput(Constants.ELEVATOR_UPPER_LIMIT_PORT);
    this.ELEVATOR_LOWER_LIMIT = new DigitalInput(Constants.ELEVATOR_LOWER_LIMIT_PORT);

    //Inventory and Choosers
    this.choosers = new ArrayList<>();
    this.inventory = new Boba[Constants.BOBA_NUMBER];

    this.currentSlot = 0;
    this.previousBobaPresent = true;

    initializeChoosers();
    updateInventory();
    configureMotors();
  }

  public void spin(Boba drink){
    if (!bobaInStock(drink)) {
      Robot.LED_CONTROLLER.setColor(Color.HEARTBEAT_RED);
      return;
    }

    if (bobaSelected(drink) && !elevatorUp()) {
      Robot.LED_CONTROLLER.setColor(Color.HEARTBEAT_BLUE);
      this.WHEEL_MOTOR.stopMotor();
      liftElevator();

      inventory[currentSlot] = null;

      return;
    }

    // If no boba before, but now there is boba, increase slot
    if (previousBobaPresent == false && bobaPresent()) {
      currentSlot++;
      currentSlot %= 10;
    }

    if (elevatorDown()) {
      this.WHEEL_MOTOR.set(Constants.WHEEL_MOTOR_SPEED);
    }

    previousBobaPresent = bobaPresent();
  }

  public boolean bobaInStock(Boba drink) {
    for (Boba b : Boba.values()) {
      if (b == drink) {
        return true;
      }
    }
    return false;
  }

  public boolean bobaSelected(Boba drink) {
    return drink == inventory[currentSlot];
  }

  public void updateInventory() {
    for (int i = 0; i < inventory.length; i++) {
      inventory[i] = choosers.get(i).getSelected();
    }
  }

  private boolean bobaPresent() {
    return !this.WHEEL_BEAM.get();
  }

  private void initializeChoosers() {
    for (SendableChooser<Boba> chooser : choosers) {
      for (Boba b : Boba.values()) {
        chooser.addOption(b.toString(), b);
      }
      chooser.setDefaultOption("None", null);
    }
  }

  public int getNumBoba() {
    int num = 0;

    for (int i = 0; i < inventory.length; i++) {
      if (inventory[i] != null) {
        num++;
      }
    }

    return num;
  }

  public void lowerElevator() {
    if (!elevatorDown()) {
      this.ELEVATOR_MOTOR.set(-Constants.ELEVATOR_MOTOR_SPEED);
    }
    else {
      this.ELEVATOR_MOTOR.stopMotor();
    }
  }

  private void liftElevator() {
    if (!elevatorUp()) {
      this.ELEVATOR_MOTOR.set(Constants.ELEVATOR_MOTOR_SPEED);
    }
    else {
      this.ELEVATOR_MOTOR.stopMotor();
    }
  }

  public boolean elevatorUp() {
    return this.ELEVATOR_UPPER_LIMIT.get();
  }

  public boolean elevatorDown() {
    return this.ELEVATOR_LOWER_LIMIT.get();
  }

  public void configureMotors() {
    this.WHEEL_MOTOR.configFactoryDefault();
    this.ELEVATOR_MOTOR.configFactoryDefault();

    this.WHEEL_MOTOR.setNeutralMode(NeutralMode.Coast);
    this.ELEVATOR_MOTOR.setNeutralMode(NeutralMode.Brake);
  }

  public void shuffleBoard(){
    for (int i = 0; i < choosers.size(); i++) {
      SmartDashboard.putData("Slot " + i, choosers.get(i));
    }
  }

  public boolean stop(){
    this.WHEEL_MOTOR.stopMotor();
    this.ELEVATOR_MOTOR.stopMotor();
    return false;
  }

  public void ping(){}

  public boolean isAlive(){
    return true;
  }
}
