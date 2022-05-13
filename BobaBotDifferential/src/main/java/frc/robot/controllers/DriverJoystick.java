package frc.robot.controllers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class DriverJoystick {
    private final Joystick joystick;
    
    public DriverJoystick(int port){
        this.joystick = new Joystick(port);
    }

    
}
