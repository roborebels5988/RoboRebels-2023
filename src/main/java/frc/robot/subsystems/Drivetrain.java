
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
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

    private static final WPI_VictorSPX leftFrontPWMVictorSPX = new WPI_VictorSPX(
            Constants.MotorConstants.leftFrontMotorPort);
    private static final WPI_VictorSPX rightFrontPWMVictorSPX = new WPI_VictorSPX(
            Constants.MotorConstants.rightFrontMotorPort);
    private static final WPI_VictorSPX leftBackPWMVictorSPX = new WPI_VictorSPX(
            Constants.MotorConstants.leftBackMotorPort);
    private static final WPI_VictorSPX rightBackPWMVictorSPX = new WPI_VictorSPX(
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