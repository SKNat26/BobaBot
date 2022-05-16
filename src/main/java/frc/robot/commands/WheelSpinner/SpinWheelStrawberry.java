package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.util.Boba;

public class SpinWheelStrawberry extends CommandBase {

  public SpinWheelStrawberry() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.spin(Boba.STRAWBERRY);
  }

  @Override
  public boolean isFinished() {
    return Robot.WHEEL_SPINNER.bobaInStock(Boba.STRAWBERRY) || Robot.WHEEL_SPINNER.bobaSelected(Boba.STRAWBERRY);
  }

  @Override
  public void end(boolean interrupted) {}
}
