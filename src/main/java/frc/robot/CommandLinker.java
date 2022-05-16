package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Drivetrain.DiffDrive;
import frc.robot.controllers.DriverJoystick;

public class CommandLinker 
{
  /*****
   * Joystick Objects
   *****/

  public final DriverJoystick driverJoystick = new DriverJoystick();

  public CommandLinker() {}

  public void configureRegisteredSubsystems() {
    CommandScheduler.getInstance().registerSubsystem(Robot.LED_CONTROLLER);
    CommandScheduler.getInstance().registerSubsystem(Robot.DRIVETRAIN);
    CommandScheduler.getInstance().registerSubsystem(Robot.STRAW_SHOOTER);
    CommandScheduler.getInstance().registerSubsystem(Robot.WHEEL_SPINNER);
  }

  public void configurePeriodicBindings() {
    CommandScheduler.getInstance().setDefaultCommand(Robot.DRIVETRAIN, new DiffDrive());
  }

  public void configureCommands() {
    this.driverJoystick.mapButtons();
  }
}