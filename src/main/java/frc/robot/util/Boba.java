package main.java.frc.robot.util;

public enum Boba {
    NORMAL("Normal"),
    PEACH_GREEN("Peach Green"),
    TARO("Taro"),
    MANGO("Mango"),
    BROWN_SUGAR("Brown Sugar"),
    STRAWBERRY("Strawberry"),
    SMOOTHIE("Smoothie");

    private final String strRep;

    Boba(String strRep) {
        this.strRep = strRep;
    }

    public String toString() {
        return this.strRep;
    }
}
