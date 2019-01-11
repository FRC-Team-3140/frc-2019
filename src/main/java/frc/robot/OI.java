package frc.robot;

public class OI {

    public OI() {
        xbox1.leftBumper.whenPressed(new ShiftUp());
        xbox1.leftBumper.whenReleased(new ShiftDown());
    }

    public void check() {
        xbox1.check();
    }
}
