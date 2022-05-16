package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;
import frc.robot.util.Boba;

public class SpinWheel extends CommandBase {

  public SpinWheel() {
      addRequirements(Robot.STRAW_SHOOTER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.spin(Boba.BROWN_SUGAR); //TODO temporary for now, but will create different command and button for each drink
  }

  @Override
  public boolean isFinished() {
    return Robot.STRAW_SHOOTER.strawPresent();
  }

  @Override
  public void end(boolean interrupted) {}
}
