package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public final class DriverCamera {
	private CameraServer camServer;
	private UsbCamera cam;

	public DriverCamera() {
		camServer = CameraServer.getInstance();
		cam = camServer.startAutomaticCapture();
		cam.setFPS(30);
		cam.setResolution(320, 240);
	}
}
