// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriverStation;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  Drivetrain m_Drivetrain = new Drivetrain();
  private Timer timer = new Timer();
  private boolean balanceflag = false;
  private boolean balanceEnabled = DriverStation.autoChargeStation.getBoolean(true);

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
    if (balanceEnabled) {
      if (balanceflag == true) {
        Intake.IntakeMotors.set(0);
        // we are on the charge station, time to balance!
        if (Drivetrain.gyro.getRoll() >= 11) {
          Drivetrain.m_robotDrive.tankDrive(-0.62, 0.62);
        } else {
          if (Drivetrain.gyro.getRoll() <= -11) {
            Drivetrain.m_robotDrive.tankDrive(0.62, -0.62);
          } else {
            Drivetrain.m_robotDrive.tankDrive(0, 0);
          }
        }
      } else {
        // we are not yet on the charge station
        if (timer.get() < 2) {
          Drivetrain.m_robotDrive.tankDrive(0, 0);
          Intake.IntakeMotors.set(-0.75);
        } else {
          if (Drivetrain.AverageEncoderDistance() <= 700) {
            // move backwards onto the platform
            Drivetrain.m_robotDrive.tankDrive(-0.8, 0.8);
          } else {
            // if all of these are false, it's time to get to balancing!
            balanceflag = true;
          }
        }
      }
    } else { // if we are not balancing
      if (timer.get() < 2) {
        // move backwards for the first 2 seconds
        // Drivetrain.m_robotDrive.tankDrive(0.7, -0.7);
        Intake.IntakeMotors.set(-0.75);
        Drivetrain.m_robotDrive.tankDrive(0, 0);
      } else {
        Intake.IntakeMotors.set(0);
        if (Drivetrain.AverageEncoderDistance() <= 1500) { // TODO work out the correct distance
          // move backwards out of the community
          Drivetrain.m_robotDrive.tankDrive(-0.8, 0.8);
        } else {
          Drivetrain.m_robotDrive.tankDrive(0, 0);
        }
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
