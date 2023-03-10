// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private Timer timer = new Timer();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  Drivetrain m_Drivetrain = new Drivetrain();
  ManagedStraightDrive m_StraightDrive = new ManagedStraightDrive(m_Drivetrain, -0.7);

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
    // m_StraightDrive.schedule();
    Drivetrain.LeftEncoder.reset();
    Drivetrain.RightEncoder.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.get() < 1) {
      Drivetrain.m_robotDrive.tankDrive(0.5, -0.5);
      Intake.IntakeMotors.set(0.5);
    } else {
      if (Drivetrain.AverageEncoderDistance() <= 1150) { // move backwards onto the platform // TODO make positive
        // m_StraightDrive.cancel();
        Drivetrain.m_robotDrive.tankDrive(-0.7, 0.7);
      } else { // TODO remove this
        Drivetrain.m_robotDrive.tankDrive(0, 0);
      }
    }
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
