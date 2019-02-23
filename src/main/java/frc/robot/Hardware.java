package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public final class Hardware {

    // DRIVETRAIN
    public static final AnalogInput rightLineSensor = new AnalogInput(0);
    public static final AnalogInput leftLineSensor = new AnalogInput(1);

    // ELEVATOR
    public static final Encoder elEncoder = new Encoder(0, 1);
    public static final DigitalInput elBotSwitch = new DigitalInput(4);

    // ARM
    public static final DigitalInput armTopSwitch = new DigitalInput(2);
    public static final DigitalInput armBotSwitch = new DigitalInput(3);

    // INTAKE
    public static final DigitalInput ballSwitch = new DigitalInput(5);
    public static final DigitalInput hatchSwitch = new DigitalInput(6);

    public static boolean isElDown() {
        return elBotSwitch.get();
    }

}