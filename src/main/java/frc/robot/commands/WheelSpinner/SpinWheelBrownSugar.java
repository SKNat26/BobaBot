package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.util.Boba;

public class SpinWheelBrownSugar extends CommandBase {

  public SpinWheelBrownSugar() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.spin(Boba.BROWN_SUGAR);
  }

  @Override
  public boolean isFinished() {
    return Robot.WHEEL_SPINNER.bobaInStock(Boba.BROWN_SUGAR) || Robot.WHEEL_SPINNER.bobaSelected(Boba.BROWN_SUGAR);
  }

  @Override
  public void end(boolean interrupted) {}
}
