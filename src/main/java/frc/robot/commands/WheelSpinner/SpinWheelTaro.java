package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.util.Boba;

public class SpinWheelTaro extends CommandBase {

  public SpinWheelTaro() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.spin(Boba.TARO);
  }

  @Override
  public boolean isFinished() {
    return !Robot.WHEEL_SPINNER.bobaInStock(Boba.TARO) || Robot.WHEEL_SPINNER.elevatorUp();
  }

  @Override
  public void end(boolean interrupted) {}
}
