package frc.robot.subsystems;

import java.util.HashMap;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.util.Color;

public class LEDController extends SubsystemBase {

  private final PWMSparkMax LedController;
  private HashMap<Integer, Color> inventoryColors;

  public LEDController() {
    this.LedController = new PWMSparkMax(Constants.LEDPORT);

    // Colors from number of boba in inventory
    this.inventoryColors = new HashMap<>();
    inventoryColors.put(0, Color.HOT_PINK);
    inventoryColors.put(1, Color.DARK_RED);
    inventoryColors.put(2, Color.RED);
    inventoryColors.put(3, Color.RED_ORANGE);
    inventoryColors.put(4, Color.ORANGE);
    inventoryColors.put(5, Color.YELLOW);
    inventoryColors.put(6, Color.LAWN_GREEN);
    inventoryColors.put(7, Color.GREEN);
    inventoryColors.put(8, Color.RAINBOW_RAINBOW_PALETTE);
    inventoryColors.put(9, Color.RAINBOW_RAINBOW_PALETTE);
    inventoryColors.put(10, Color.RAINBOW_PARTY_PALETTE);
  }

  public void setColor(Color color) {
    if (this.LedController.get() != color.getValue()) {
      this.LedController.set(color.getValue());
    }
  }

  public void enableInventoryColor() {
    int numBoba = Robot.WHEEL_SPINNER.getNumBoba();

    setColor(inventoryColors.get(numBoba));
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
