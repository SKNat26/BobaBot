package frc.robot.extra;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class led {   
        private int[] rgb;
        public led(int r, int g, int b){
            rgb = new int[3];
            rgb[0] = r;
            rgb[1] = g;
            rgb[2] = b;
        }
        public int getR(){
            return rgb[0];
        }
        public int getG(){
            return rgb[1];
        }
        public int getB(){
            return rgb[2];
        }
        public static void changeColor(AddressableLED lights, AddressableLEDBuffer buffer, led color){
            for(int i = 0; i < buffer.getLength(); i++){
                buffer.setRGB(i, color.getR(), color.getG(), color.getB());
                lights.setData(buffer);
            }
        }
    
        public static void turnOff(AddressableLED lights, AddressableLEDBuffer buffer){
            for(int i = 0; i < buffer.getLength(); i++){
                buffer.setRGB(i, 0, 0, 0);
            }
        }
}
