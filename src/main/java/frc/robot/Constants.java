
package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final short kDriverControllerPort = 0;
    public static final short kSubsystemControllerPort = 1;
  }

  public static class MotorConstants {
    public static final short leftFrontMotorPort = 0;
    public static final short leftBackMotorPort = 1;
    public static final short rightFrontMotorPort = 2;
    public static final short rightBackMotorPort = 3;

    public static final short IntakeLeftMotorPort = 4;
    public static final short IntakeRightMotorPort = 5;
  }

  public static class EncoderConstants {
    public static final short leftEncoderPortA = 2;
    public static final short leftEncoderPortB = 3;

    public static final short rightEncoderPortA = 0;
    public static final short rightEncoderPortB = 1;
  }

  public static class WheelConstants {
    public static final double wheelSize = 15.22;
  }
}
