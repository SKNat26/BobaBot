package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.util.Boba;

public class SpinWheelMango extends CommandBase {

  public SpinWheelMango() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.spin(Boba.MANGO);
  }

  @Override
  public boolean isFinished() {
    return Robot.WHEEL_SPINNER.bobaInStock(Boba.MANGO) || Robot.WHEEL_SPINNER.bobaSelected(Boba.MANGO);
  }

  @Override
  public void end(boolean interrupted) {}
}
