package frc.robot.commands.StrawShooter;


import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class ShootStraw extends CommandBase {

  public ShootStraw() {
      addRequirements(Robot.STRAW_SHOOTER);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    Robot.STRAW_SHOOTER.shoot();
  }

  @Override
  public boolean isFinished() {
    return Robot.STRAW_SHOOTER.strawPresent();
  }

  @Override
  public void end(boolean interrupted) {}
}
