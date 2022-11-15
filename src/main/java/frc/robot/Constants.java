// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
            public static final int plantIntake = 0;
        }
        
        public static final class RightJoy {
            public static final int port = 0;
            public static final int regurgitate = 0;
            public static final int toggleIntake = 0;
        }
    }

    public static final class DriveConstants {
        public static enum DriveMode {TANK, ARCADE};
        public static DriveMode mode = DriveMode.ARCADE;

        public static final double drivetrainRatio = 12/72;
        public static final double wheelDiameter = 4;

        public static final int motorTempLimit = 30;
        
        public static final double intakeRegurgitateSpeed = -0.6;
        public static final double feederSpeed = 0.6;
        public static final double feederRegurgitateSpeed = -0.6;
        public static final double treadmillRegurgitateSpeed = -0.6;
        public static final double autoSpeed = 0.4;
        public static final double intakeSpeed = 0.6;
        public static final double treadmillSpeed = 0.6;

        public static final double slowDriveMultiplier = 0.3;

        public static final double plantIntakeSpeed = 0.1;
        public static double intakeToggle = 0; // I'm putting this here even though it isn't final. Tell me if it should be somewhere else.
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