package frc.controllers;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.libs.XboxController;
import frc.loopController.Loop;

public class Record implements Loop, Constants {
	private static boolean recordOK = false;
	private static XboxController controller = OI.getXboxController();
	private static XboxController controller2 = OI.getXboxController2();
	private static boolean reachedFirstNonZero = false;

	public static void okToRecord(boolean okToRecord) {
		recordOK = okToRecord;
		if(recordOK) System.out.println("Ok To Record");
		else System.out.println("Not Ok To Record");
	}
	
	public static void reachedFirstNonZero(boolean reached) {
		reachedFirstNonZero = reached;
	}
	
	@Override
	public void onStart() {
	}

	@Override
	public void onLoop() {
		if(recordOK)
			execute();
	}
	
	@Override
	public void onStop() {
	}
	
	private void execute() {
		System.out.println("Recording");
		
		if(!reachedFirstNonZero && (Robot.drivetrain.getLeftVoltage() != 0 || Robot.drivetrain.getRightVoltage() != 0 ||
				controller.a.get() || controller.b.get() || controller.x.get() || controller.y.get() || controller.leftBumper.get() ||
				controller.rightBumper.get() || controller.select.get() || controller.start.get() || controller.leftJoystickPress.get() ||
				controller.rightJoystickPress.get() || controller.leftTrigger.get() || controller.rightTrigger.get() || controller2.a.get() ||
				controller2.b.get() || controller2.x.get() || controller2.y.get() || controller2.leftBumper.get() || controller2.rightBumper.get() || 
				controller2.select.get() || controller2.start.get() || controller2.leftJoystickPress.get() || controller2.rightJoystickPress.get() ||
				controller2.leftTrigger.get() || controller2.rightTrigger.get())) {
			
			reachedFirstNonZero = true;
		}
		
		if(reachedFirstNonZero) {
			/*Robot.lg.writeLine(Robot.dt.getLeftMasterVoltage() + "," + Robot.dt.getRightMasterVoltage() + "," + Robot.in.getLeftIntakeWheelValue() + "," + Robot.in.getRightIntakeWheelValue()
							+ "," + controller.a.get() + "," + controller.b.get() + "," + controller.x.get() + "," + controller.y.get() + "," + controller.leftBumper.get() 
							+ "," + controller.rightBumper.get() + "," + controller.select.get() + "," + controller.start.get() + "," + controller.leftJoystickPress.get() 
							+ "," + controller.rightJoystickPress.get() + "," + controller.leftTrigger.get() + "," + controller.rightTrigger.get() + "," + controller2.a.get()
							+ "," + controller2.b.get() + "," + controller2.x.get() + "," + controller2.y.get() + "," + controller2.leftBumper.get() + "," + controller2.rightBumper.get()
							+ "," + controller2.select.get() + ","  + controller2.start.get() + "," + controller2.leftJoystickPress.get() + "," + controller2.rightJoystickPress.get() 
							+ "," + controller2.leftTrigger.get() + "," + controller2.rightTrigger.get() + "," + Robot.el.getTicksTravelled() + "," + Robot.el.getElevatorVelocity());
			*/
		}
	}
}



