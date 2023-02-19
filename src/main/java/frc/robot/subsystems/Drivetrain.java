
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

        public Drivetrain() {
        }

        private static final MotorController leftFrontPWMVictorSPX = new WPI_VictorSPX(
                        Constants.MotorConstants.leftFrontMotorPort);
        private static final MotorController rightFrontPWMVictorSPX = new WPI_VictorSPX(
                        Constants.MotorConstants.rightFrontMotorPort);
        private static final MotorController leftBackPWMVictorSPX = new WPI_VictorSPX(
                        Constants.MotorConstants.leftBackMotorPort);
        private static final MotorController rightBackPWMVictorSPX = new WPI_VictorSPX(
                        Constants.MotorConstants.rightBackMotorPort);

        private static final MotorControllerGroup left = new MotorControllerGroup(leftFrontPWMVictorSPX,
                        leftBackPWMVictorSPX);
        private static final MotorControllerGroup right = new MotorControllerGroup(rightFrontPWMVictorSPX,
                        rightBackPWMVictorSPX);

        public static final DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);

        public static final Encoder LeftEncoder = new Encoder(Constants.EncoderConstants.leftEncoderPortA,
                        Constants.EncoderConstants.leftEncoderPortB);
        public static final Encoder RightEncoder = new Encoder(Constants.EncoderConstants.rightEncoderPortA,
                        Constants.EncoderConstants.rightEncoderPortB);

        public CommandBase Init() {

                return runOnce(
                                () -> {
                                        // distance per pulse = pi * wheel hub diameter / pulses per revolution
                                        RightEncoder.setDistancePerPulse(Math.PI * 15.24 / 5);
                                        LeftEncoder.setDistancePerPulse(Math.PI * 15.24 / 5);
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