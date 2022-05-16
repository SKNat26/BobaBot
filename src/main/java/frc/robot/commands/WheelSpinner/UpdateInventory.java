package frc.robot.commands.WheelSpinner;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class UpdateInventory extends CommandBase {

  public UpdateInventory() {
      addRequirements(Robot.WHEEL_SPINNER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.WHEEL_SPINNER.updateInventory();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {}
}
