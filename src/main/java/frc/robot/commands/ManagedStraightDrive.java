// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/** An example command that uses an example subsystem. */
public class ManagedStraightDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final Drivetrain m_Drivetrain;
  public double speed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ManagedStraightDrive(Drivetrain drivetrain, double inspeed) {
    speed = inspeed;
    m_Drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  private double GetDifference(double a, double b) {
    double result = a - b;
    if (result >= 0) { // if the result is positive or zero
      return result;
    } else { // if the result is negative
      return -result; // invert before returning, ensuring result is always positive
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double LeftDist = Drivetrain.LeftEncoder.get();
    double RightDist = Drivetrain.RightEncoder.get();
    double difference = GetDifference(LeftDist, RightDist);
    double rightspeed = speed;
    double leftspeed = speed;
    double CorrectionValue = speed * 0.10;
    difference -= 1; // it's okay if it's off by one
    if (LeftDist - RightDist > 0) { // we are drifting right
      rightspeed = speed + CorrectionValue * difference;
    } else {
      if (RightDist - LeftDist > 0) { // we are drifting left
        leftspeed = speed + CorrectionValue * difference;
      }
    }
    Drivetrain.m_robotDrive.tankDrive(leftspeed, rightspeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
