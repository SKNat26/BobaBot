package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import frc.robot.Constants;
import frc.robot.util.subsystems.MechanicalSubsystem;

public class WheelSpinner extends MechanicalSubsystem {
  
  //Motor and Beam
  private final WPI_TalonSRX WHEEL_MOTOR;
  private final DigitalInput WHEEL_BEAM;

  //Inventory and Choosers
  private final SensableChooser<Boba>[] choosers;
  private final Boba[] inventory;

  public WheelSpinner() {

    //Motor
    this.WHEEL_MOTOR = new WPI_TalonSRX(Constants.WHEEL_MOTOR_PORT);
    this.WHEEL_BEAM = new DigitalInput(Constants.WHEEL_BEAM_PORT);
    // TODO elevator?

    //Inventory and Choosers
    this.choosers = new SensableChooser<Boba>[BOBA_NUMBER];
    this.inventory = new Boba[BOBA_NUMBER];

    initializeChoosers();
    updateInventory();
    configureMotors();
  }

  public void spin(Boba drink){
    if (inventory.indexOf(drink) >= 0) {
      //
    }
  }

  public void updateInventory() {
    for (int i = 0; i < inventory.length; i++) {
      inventory[i] = choosers[i].getSelected();
    }
  }

  private void initializeChoosers() {
    for (SensableChooser<Boba> chooser : choosers) {
      for (Boba b : Boba.values()) {
        chooser.addOption(b.toString(), b);
      }
      chooser.setDefaultOption("None", null);
    }
  }

  public void configureMotors() {
    this.WHEEL_MOTOR.configFactoryDefault();
    this.WHEEL_MOTOR.setNeutralMode(NeutralMode.Brake);
  }

  public void shuffleBoard(){
    for (int i = 0; i < choosers.length; i++) {
      SmartDashboard.putData("Slot " + i, choosers[i]);
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
