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
        public static final class LeftJoy {
            public static final int port = 0;

            public static final int toggleMode = 2;
            public static final int plantIntake = 1; // trigger
        }
        
        public static final class RightJoy {
            public static final int port = 1;

            public static final int regurgitate = 1;
            public static final int intakeToggle = 2; // trigger
        }
    }

    public static final class DriveConstants {
        public static final double drivetrainRatio = 12/72;
        public static final double wheelDiameter = 4;
    }

    public static final class MotorPorts {
        public static final int leftDriveSparkMax = 11;
        public static final int rightDriveSparkMax = 17;
        public static final int intakeSparkMax = 0;
        public static final int feederSparkMax = 0;
        public static final int treadmill = 0;
    }

    public static final class Controller {
        public static final int port = 0;

        public static final int toggleMode = 0;
        public static final int plantIntake = 0;
        public static final int regurgitate = 0;
        public static final int intakeToggle = 0;
    
        /** public static int X;
        public static int A;
        public static int B;
        public static int Y;
        public static int LB;
        public static int RB;
        public static int LT;
        public static int RT;
        public static int BACK;
        public static int START;
    
        static {
                // Buttons and triggers for xbox controller
                X = 3;
                A = 1;
                B = 2;
                Y = 4;
                LB = 5;
                RB = 6;
                LT = 7;
                RT = 8;
                BACK = 9;
                START = 10;
            }
              public static final int toggleMode = Y;
              public static final int runIntakeBackwardPort = A;
              public static final int regurgitatePort = B;
              public static final int dumbModeToggle = START;
              public static final int toggleIntakePort = X;
              public static final int extendClimberPort = RB;
              public static final int retractClimberPort = LB; */
          }
}