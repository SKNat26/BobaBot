package frc.robot.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

public class DriverJoystick {
    private final Joystick JOYSTICK;
    public final JoystickButton RAINBOW;
    public final JoystickButton GREEN;
    public final JoystickButton RED;
    public final JoystickButton BLUE;
    
    public DriverJoystick(int port){
        this.JOYSTICK = new Joystick(port);
        RAINBOW = new JoystickButton(JOYSTICK, Constants.RAINBOWBUTTON);
        GREEN = new JoystickButton(JOYSTICK, Constants.GREENBUTTON);
        RED = new JoystickButton(JOYSTICK, Constants.REDBUTTON);
        BLUE = new JoystickButton(JOYSTICK, Constants.BLUEBUTTON);
    }

    public Joystick getJoystick(){
        return JOYSTICK;
    }
  
}
