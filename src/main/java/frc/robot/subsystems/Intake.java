// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;
import frc.robot.commands.IntakeManager;

public class Intake extends SubsystemBase {

  /** Creates a new ExampleSubsystem. */
  public Intake() {
  }

  private static final MotorController LeftVictorSPX = new WPI_VictorSPX(
      MotorConstants.IntakeLeftMotorPort);
  private static final MotorController RightVictorSPX = new WPI_VictorSPX(
      MotorConstants.IntakeRightMotorPort);
  public static final MotorControllerGroup IntakeMotors = new MotorControllerGroup(LeftVictorSPX, RightVictorSPX);
  private static final IntakeManager m_IntakeManager = new IntakeManager();

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public static void Init() {
    RightVictorSPX.setInverted(true);
    // m_IntakeManager.schedule();
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a
   * digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
