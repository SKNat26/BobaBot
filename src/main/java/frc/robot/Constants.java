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
import frc.robot.util.*;

public final class Constants {

    /*-------*/
    /* PORTS */
    /*-------*/

    //DRIVETRAIN PORTS
    public static final int RM1PORT = 0;
    public static final int RM2PORT = 1;
    public static final int RM3PORT = 2;
    public static final int LM1PORT = 3;
    public static final int LM2PORT = 4;
    public static final int LM3PORT = 5;

    //STRAWSHOOTER PORT
    public static final int STRAW_MOTOR_PORT = 6;
    public static final int STRAW_BEAM_PORT = 3;

    //WHEELSPINNER PORTS
    public static final int WHEEL_MOTOR_PORT = 7;
    public static final int WHEEL_BEAM_PORT = 4;
    
    //DRIVE PORT
    public static final int JOYSTICKPORT = 0;
    public static final int LEDPORT = 2;

    /*-------*/
    /* OTHER */
    /*-------*/

    public static final int BOBA_NUMBER = 10;

    //SPEEDS
    public static final double STRAW_MOTOR_SPEED = 0.5;
    public static final double WHEEL_MOTOR_SPEED = 0.5;

    //COLOR
    public static final Led RAINBOW = new Led(-0.99);
    public static final Led GREEN = new Led(0.77);
    public static final Led RED = new Led(0.61);
    public static final Led BLUE = new Led(0.87);
    
    //JOYSTICK BUTTONS
    //TODO Change buttons
    public static final int SHOOT_STRAW_BUTTON = 1;
    public static final int REVERSE_DIRECTION_BUTTON = 2;
    public static final int UPDATE_INVENTORY_BUTTON = 3; //TODO update inventory on shuffleboard, not joystick

    public static final int SPIN_WHEEL_NORMAL_BUTTON = 4;
    public static final int SPIN_WHEEL_PEACH_GREEN_BUTTON = 5;
    public static final int SPIN_WHEEL_TARO_BUTTON = 6;
    public static final int SPIN_WHEEL_MANGO_BUTTON = 7;
    public static final int SPIN_WHEEL_BROWN_SUGAR_BUTTON = 8;
    public static final int SPIN_WHEEL_STRAWBERRY_BUTTON = 9;
    public static final int SPIN_WHEEL_SMOOTHIE_BUTTON = 10;

    // public static final int RAINBOWBUTTON = 9;
    // public static final int GREENBUTTON = 10;
    // public static final int REDBUTTON = 11;
    // public static final int BLUEBUTTON = 12;
}
