package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.Constants;
import frc.robot.util.subsystems.MechanicalSubsystem;
import frc.robot.util.Boba;

public class WheelSpinner extends MechanicalSubsystem {
  
  //Motor and Beam
  private final WPI_TalonSRX WHEEL_MOTOR;
  private final DigitalInput WHEEL_BEAM;

  //Inventory and Choosers
  private final ArrayList<SendableChooser<Boba>> choosers;
  private final Boba[] inventory;
  // private final SendableChooser<Boba>[] choosers;
  private int currentSlot;
  private boolean previousBobaPresent;

  public WheelSpinner() {

    //Motor and Beam
    this.WHEEL_MOTOR = new WPI_TalonSRX(Constants.WHEEL_MOTOR_PORT);
    this.WHEEL_BEAM = new DigitalInput(Constants.WHEEL_BEAM_PORT);
    // TODO elevator?

    //Inventory and Choosers
    this.choosers = new ArrayList<>();
    this.inventory = new Boba[Constants.BOBA_NUMBER];
    //this.choosers = new SendableChooser<Boba>[Constants.BOBA_NUMBER];
    this.currentSlot = 0;
    this.previousBobaPresent = true;

    initializeChoosers();
    updateInventory();
    configureMotors();
  }

  public void spin(Boba drink){
    if (!bobaInStock(drink)) {
      // TODO turn LED red
      return;
    }

    if (bobaSelected(drink)) {
      /* TODO
      * turn LED green
      * activate elevator
      */
      inventory[currentSlot] = null;
      // TODO use getNumBoba() to change color on LEDS
      return;
    }

    // If no boba before, but now there is boba, increase slot
    if (previousBobaPresent == false && bobaPresent()) {
      currentSlot++;
      currentSlot %= 10;
    }

    this.WHEEL_MOTOR.set(Constants.WHEEL_MOTOR_SPEED);
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

  public void configureMotors() {
    this.WHEEL_MOTOR.configFactoryDefault();
    this.WHEEL_MOTOR.setNeutralMode(NeutralMode.Brake);
  }

  public void shuffleBoard(){
    for (int i = 0; i < choosers.size(); i++) {
      SmartDashboard.putData("Slot " + i, choosers.get(i));
    }
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
