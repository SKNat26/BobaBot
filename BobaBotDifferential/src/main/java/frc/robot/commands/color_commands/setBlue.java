package frc.robot.commands.color_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class setBlue extends CommandBase {

  /** Creates a new setLED. */
  public setBlue() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.LIGHTS);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.LIGHTS.setColor(Constants.BLUE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
