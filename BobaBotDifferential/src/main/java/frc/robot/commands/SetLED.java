// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED_Controller;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

public class SetLED extends CommandBase {
  private final LEDs LED;
  private Joystick stick = new Joystick(0);

  /** Creates a new setLED. */
  public SetLED(LEDs light) {
    // Use addRequirements() here to declare subsystem dependencies.
    LED = light;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    LEDs.changeColor(Constants.green);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      if(stick.getRawButtonPressed(1)){
        LEDs.changeColor(Constants.red);
      }
      else if(stick.getRawButtonPressed(2)){
        LEDs.changeColor(Constants.orange);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}