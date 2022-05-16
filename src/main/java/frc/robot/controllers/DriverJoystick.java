package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.Drivetrain.*;
import frc.robot.commands.StrawShooter.*;
import frc.robot.commands.WheelSpinner.*;

public class DriverJoystick {

    private final Joystick JOYSTICK;
    
    // public final JoystickButton RAINBOW;
    // public final JoystickButton GREEN;
    // public final JoystickButton RED;
    // public final JoystickButton BLUE;

    public final JoystickButton SHOOT_STRAW_BUTTON; 
    public final JoystickButton REVERSE_DIRECTION_BUTTON;
    public final JoystickButton UPDATE_INVENTORY_BUTTON;

    public final JoystickButton SPIN_WHEEL_NORMAL_BUTTON;
    public final JoystickButton SPIN_WHEEL_PEACH_GREEN_BUTTON;
    public final JoystickButton SPIN_WHEEL_TARO_BUTTON;
    public final JoystickButton SPIN_WHEEL_MANGO_BUTTON;
    public final JoystickButton SPIN_WHEEL_BROWN_SUGAR_BUTTON;
    public final JoystickButton SPIN_WHEEL_STRAWBERRY_BUTTON;
    public final JoystickButton SPIN_WHEEL_SMOOTHIE_BUTTON;
    
    public DriverJoystick(){
        this.JOYSTICK = new Joystick(Constants.JOYSTICKPORT);

        this.SHOOT_STRAW_BUTTON = new JoystickButton(JOYSTICK, Constants.SHOOT_STRAW_BUTTON);
        this.REVERSE_DIRECTION_BUTTON = new JoystickButton(JOYSTICK, Constants.REVERSE_DIRECTION_BUTTON);
        this.UPDATE_INVENTORY_BUTTON = new JoystickButton(JOYSTICK, Constants.UPDATE_INVENTORY_BUTTON);

        this.SPIN_WHEEL_NORMAL_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_NORMAL_BUTTON);
        this.SPIN_WHEEL_PEACH_GREEN_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_PEACH_GREEN_BUTTON);
        this.SPIN_WHEEL_TARO_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_TARO_BUTTON);
        this.SPIN_WHEEL_MANGO_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_MANGO_BUTTON);
        this.SPIN_WHEEL_BROWN_SUGAR_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_BROWN_SUGAR_BUTTON);
        this.SPIN_WHEEL_STRAWBERRY_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_STRAWBERRY_BUTTON);
        this.SPIN_WHEEL_SMOOTHIE_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_SMOOTHIE_BUTTON);

        // RAINBOW = new JoystickButton(JOYSTICK, Constants.RAINBOWBUTTON);
        // GREEN = new JoystickButton(JOYSTICK, Constants.GREENBUTTON);
        // RED = new JoystickButton(JOYSTICK, Constants.REDBUTTON);
        // BLUE = new JoystickButton(JOYSTICK, Constants.BLUEBUTTON);
    }

    // TODO while spin wheel button isn't held, have led indicating how much boba is in stock
    public void mapButtons() {

        // Straw shooter
        SHOOT_STRAW_BUTTON.whenPressed(new ShootStraw());

        // Drivetrain
        REVERSE_DIRECTION_BUTTON.whenPressed(new ReverseDriveDirection());

        // Wheelspinner
        UPDATE_INVENTORY_BUTTON.whenPressed(new UpdateInventory());

        SPIN_WHEEL_NORMAL_BUTTON.whileHeld(new SpinWheelNormal());
        SPIN_WHEEL_PEACH_GREEN_BUTTON.whileHeld(new SpinWheelPeachGreen());
        SPIN_WHEEL_TARO_BUTTON.whileHeld(new SpinWheelTaro());
        SPIN_WHEEL_MANGO_BUTTON.whileHeld(new SpinWheelMango());
        SPIN_WHEEL_BROWN_SUGAR_BUTTON.whileHeld(new SpinWheelBrownSugar());
        SPIN_WHEEL_STRAWBERRY_BUTTON.whileHeld(new SpinWheelStrawberry());
        SPIN_WHEEL_SMOOTHIE_BUTTON.whileHeld(new SpinWheelSmoothie());
    }

    public Joystick getJoystick(){
        return JOYSTICK;
    }
}
