package frc.robot;

import frc.robot.commands.pneumatics.ShiftDown;
import frc.robot.commands.pneumatics.ShiftUp;

public class OI implements Hardware {

    public OI() {
        xbox1.leftBumper.whenPressed(new ShiftUp());
        xbox1.leftBumper.whenReleased(new ShiftDown());
    }

    public void check() {
        xbox1.check();
    }
}
