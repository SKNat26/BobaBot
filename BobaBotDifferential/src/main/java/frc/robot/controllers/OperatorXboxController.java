package frc.robot.controllers;

import edu.wpi.first.wpilibj.XboxController;

//probably no need for this class idk we might need it later

public class OperatorXboxController{
    private final XboxController CONTROLLER; 
    
    public OperatorXboxController(int port){
        this.CONTROLLER = new XboxController(port);
    }

    public XboxController getController(){
        return CONTROLLER;
    }
}
