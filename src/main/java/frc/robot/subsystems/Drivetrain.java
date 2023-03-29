
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.GenericEntry;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {

  public Drivetrain() {
  }

  private static final MotorController leftFrontVictorSPX = new WPI_VictorSPX(
      MotorConstants.leftFrontMotorPort);
  private static final MotorController rightFrontVictorSPX = new WPI_VictorSPX(
      MotorConstants.rightFrontMotorPort);
  private static final MotorController leftBackVictorSPX = new WPI_VictorSPX(
      MotorConstants.leftBackMotorPort);
  private static final MotorController rightBackVictorSPX = new WPI_VictorSPX(
      MotorConstants.rightBackMotorPort);
  private static final MotorControllerGroup left = new MotorControllerGroup(leftFrontVictorSPX,
      leftBackVictorSPX);
  private static final MotorControllerGroup right = new MotorControllerGroup(rightFrontVictorSPX,
      rightBackVictorSPX);
  public static final DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);
  public static final Encoder LeftEncoder = new Encoder(EncoderConstants.leftEncoderPortA,
      EncoderConstants.leftEncoderPortB);
  public static final Encoder RightEncoder = new Encoder(EncoderConstants.rightEncoderPortA,
      EncoderConstants.rightEncoderPortB);
  private static GenericEntry speed;
  private static GenericEntry dashgyro;
  public static final AHRS gyro = new AHRS();

  public static double AverageEncoderDistance() {
    return LeftEncoder.get() + RightEncoder.get() / 2;
  }

  public static void Init() {
    // distance per pulse = pi * wheel hub diameter / pulses per revolution
    RightEncoder.setDistancePerPulse(Math.PI * WheelConstants.wheelSize / 5);
    LeftEncoder.setDistancePerPulse(Math.PI * WheelConstants.wheelSize / 5);
    LeftEncoder.setReverseDirection(true);
    gyro.calibrate();
    dashgyro = DriverStation.MainTab.add("Gyro", 0).getEntry();
    DriverStation.MainTab.add("Left Encoder", LeftEncoder);
    DriverStation.MainTab.add("Right Encoder", RightEncoder);
    speed = DriverStation.MainTab.add("kmph", 0).getEntry();
    DriverStation.MainTab.add(m_robotDrive);
  };

  public boolean Condition() {
    return false;
  }

  @Override
  public void periodic() {
    Double AvgSpeedPerSecond = (LeftEncoder.getRate() + RightEncoder.getRate()) / 2;
    double RoundAvgSpeedPerHour = Math.round(AvgSpeedPerSecond / 27.778);
    speed.setDouble(RoundAvgSpeedPerHour / 10);
    dashgyro.setFloat(gyro.getPitch());
  }

  @Override
  public void simulationPeriodic() {
  }
}
