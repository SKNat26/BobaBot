package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class LowerElevator extends CommandBase {

  public LowerElevator() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.lowerElevator();
  }

  @Override
  public boolean isFinished() {
    return Robot.WHEEL_SPINNER.elevatorDown();
  }

  @Override
  public void end(boolean interrupted) {
      if (interrupted) {
          Robot.WHEEL_SPINNER.stop();
      }
  }
}
