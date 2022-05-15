package frc.robot.util;

public class Led {   

    private double color;
    private boolean pulse;

    public Led(double color, boolean pulse){
        this.color = color;
        this.pulse = pulse;
    }

    public Led(double color){
        this.color = color;
    }

    public Led pulse(){
        return new Led(this.color, true);
    }

    public double getValue(){
        return this.color;
    }


}