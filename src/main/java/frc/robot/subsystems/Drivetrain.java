
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  public Drivetrain() {
  }

  private static final MotorController leftFrontPWMVictorSPX = new PWMVictorSPX(
      Constants.MotorConstants.leftFrontMotorPort);
  private static final MotorController rightFrontPWMVictorSPX = new PWMVictorSPX(
      Constants.MotorConstants.rightFrontMotorPort);
  private static final MotorController leftBackPWMVictorSPX = new PWMVictorSPX(
      Constants.MotorConstants.leftBackMotorPort);
  private static final MotorController rightBackPWMVictorSPX = new PWMVictorSPX(
      Constants.MotorConstants.rightBackMotorPort);

  private static final MotorControllerGroup left = new MotorControllerGroup(leftFrontPWMVictorSPX,
      leftBackPWMVictorSPX);
  private static final MotorControllerGroup right = new MotorControllerGroup(rightFrontPWMVictorSPX,
      rightBackPWMVictorSPX);

  public static final DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);

  public CommandBase MethodCommand() {

    return runOnce(
        () -> {

        });
  }

  public boolean Condition() {

    return false;
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {

  }
}