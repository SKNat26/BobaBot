package frc.robot.commands.Led;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class EnableInventoryColor extends CommandBase {

  public EnableInventoryColor() {
    addRequirements(Robot.LED_CONTROLLER);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.LED_CONTROLLER.enableInventoryColor();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {}
}
