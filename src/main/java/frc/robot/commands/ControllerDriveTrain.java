// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/** An example command that uses an example subsystem. */
public class ControllerDriveTrain extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public void TeleCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_driverController.getHID().getYButton()) {
      // about half speed
      Drivetrain.m_robotDrive.arcadeDrive(m_driverController.getLeftX() * 0.68, m_driverController.getLeftY() * 0.8);
    } else {
      // 85% rotation speed, normal base speed
      if (m_driverController.getLeftX() > 0) {
        Drivetrain.m_robotDrive.arcadeDrive(m_driverController.getLeftX() * 0.85 + 0.2, m_driverController.getLeftY());
      } else {
        Drivetrain.m_robotDrive.arcadeDrive(m_driverController.getLeftX() * 0.85 - 0.2, m_driverController.getLeftY());
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
