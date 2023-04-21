// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriverStation extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriverStation() {
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

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

  public static ShuffleboardTab MainTab = Shuffleboard.getTab("Main");

  public static SendableChooser<String> autopicker = new SendableChooser<String>();

  public static GenericEntry autoPickerEntry;

  public static void Init() {
    autopicker.addOption("balance", "balance");
    autopicker.addOption("short side move", "short side move");
    autopicker.addOption("long side move", "long side move");
    MainTab.add(autopicker);
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
