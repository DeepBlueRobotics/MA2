// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.carlmontrobotics.lib199.MotorErrors.TemperatureLimit;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class OI {
        public static enum ControlType {JOYSTICKS, GAMEPAD};
        public static enum StickType {LEFT, RIGHT};
        public static enum StickDirection {X, Y};

        public static ControlType CONTROL_TYPE = ControlType.JOYSTICKS;

        public static final class LeftJoy {
            public static final int port = 0;
            public static final int toggleMode = 0;
        }
        
        public static final class RightJoy {
            public static final int port = 0;
        }
    }

    public static final class DriveConstants {
        public static final int motorTempLimit = 30;
        public static final double intakeRegurgitateSpeed = -0.6;
        public static final double feederSpeed = 0.6;
        public static final double feederRegurgitateSpeed = -0.6;
        public static final double treadmillRegurgitateSpeed = -0.6;
        public static double intakeSpeed = 0.6;
        public static double treadmillSpeed = 0.6;
    }

    public static final class MotorPorts {
        public static final int leftDriveSparkMax = 0;
        public static final int rightDriveSparkMax = 0;
        public static final int leftIntakeSparkMax = 0;
        public static final int rightIntakeSparkMax = 0;
        public static final int feederSparkMax = 0;
        public static final int treadmill = 0;
    }
}