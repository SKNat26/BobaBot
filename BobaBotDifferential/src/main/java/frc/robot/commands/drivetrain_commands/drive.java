// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drivetrain_commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain dtrain;
  private final Joystick joystick;

  public drive(Drivetrain subsystem, Joystick joystick) {
    //creates a new drivetrain and adds its dependencies
    this.dtrain = subsystem;
    this.joystick = joystick;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    dtrain.ping();
    System.out.println(dtrain.isAlive());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    dtrain.driveRobot(joystick, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dtrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
