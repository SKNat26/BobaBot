package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.util.Boba;

public class SpinWheelSmoothie extends CommandBase {

  public SpinWheelSmoothie() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.spin(Boba.SMOOTHIE);
  }

  @Override
  public boolean isFinished() {
    return Robot.WHEEL_SPINNER.bobaInStock(Boba.SMOOTHIE) || Robot.WHEEL_SPINNER.bobaSelected(Boba.SMOOTHIE);
  }

  @Override
  public void end(boolean interrupted) {}
}
