package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.Drivetrain.*;
import frc.robot.commands.Led.EnableInventoryColor;
import frc.robot.commands.StrawShooter.*;
import frc.robot.commands.WheelSpinner.*;

public class DriverJoystick {

    private final Joystick JOYSTICK;

    public final JoystickButton SHOOT_STRAW_BUTTON; 
    public final JoystickButton REVERSE_DIRECTION_BUTTON;
    public final JoystickButton UPDATE_INVENTORY_BUTTON;
    public final JoystickButton LOWER_ELEVATOR_BUTTON;

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
        this.LOWER_ELEVATOR_BUTTON = new JoystickButton(JOYSTICK, Constants.LOWER_ELEVATOR_BUTTON);

        this.SPIN_WHEEL_NORMAL_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_NORMAL_BUTTON);
        this.SPIN_WHEEL_PEACH_GREEN_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_PEACH_GREEN_BUTTON);
        this.SPIN_WHEEL_TARO_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_TARO_BUTTON);
        this.SPIN_WHEEL_MANGO_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_MANGO_BUTTON);
        this.SPIN_WHEEL_BROWN_SUGAR_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_BROWN_SUGAR_BUTTON);
        this.SPIN_WHEEL_STRAWBERRY_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_STRAWBERRY_BUTTON);
        this.SPIN_WHEEL_SMOOTHIE_BUTTON = new JoystickButton(JOYSTICK, Constants.SPIN_WHEEL_SMOOTHIE_BUTTON);
    }

    // TODO while spin wheel button isn't held, have led indicating how much boba is in stock
    public void mapButtons() {

        // Straw shooter
        SHOOT_STRAW_BUTTON.whenPressed(new ShootStraw());

        // Drivetrain
        REVERSE_DIRECTION_BUTTON.whenPressed(new ReverseDriveDirection());

        // Wheelspinner
        UPDATE_INVENTORY_BUTTON.whenPressed(new ParallelCommandGroup(new UpdateInventory(), new EnableInventoryColor()));
        LOWER_ELEVATOR_BUTTON.whenPressed(new ParallelCommandGroup(new LowerElevator(), new EnableInventoryColor()));

        SPIN_WHEEL_NORMAL_BUTTON.whenPressed(new SpinWheelNormal());
        SPIN_WHEEL_PEACH_GREEN_BUTTON.whenPressed(new SpinWheelPeachGreen());
        SPIN_WHEEL_TARO_BUTTON.whenPressed(new SpinWheelTaro());
        SPIN_WHEEL_MANGO_BUTTON.whenPressed(new SpinWheelMango());
        SPIN_WHEEL_BROWN_SUGAR_BUTTON.whenPressed(new SpinWheelBrownSugar());
        SPIN_WHEEL_STRAWBERRY_BUTTON.whenPressed(new SpinWheelStrawberry());
        SPIN_WHEEL_SMOOTHIE_BUTTON.whenPressed(new SpinWheelSmoothie());
    }

    public Joystick getJoystick(){
        return JOYSTICK;
    }
}
