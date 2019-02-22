# frc-2019
Robot code for the 2019 FRC game season.


## How To Use
In order to use and deploy this code, you will need a FRC robot wired up with the following motor controllers and solenoids:
- One double solenoid
- Six SparkMAX motor controllers

Then, you will need to set up the robot by using the following steps:


### Imaging the RoboRIO
Connect to the RIO with a USB A to USB B. Use the roboRIO imaging tool (part of the FRC toolsuite) to set your team number, image the RIO, and flash its firmware. Detailed instructions at: https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/1009233-imaging-your-roborio


### Configuring the CAN Parts
The CAN electronic parts on a robot includes the PDP (Power Distribution Panel), VRM (Voltage Regulator Module), PCM (Pneumatics Control Module), and various motor controllers like the Talon SRX and Victor SPX. You will need to assign ID numbers to each part as well as install firmware. You will need the Pheonix Tuner: https://github.com/CrossTheRoadElec/Phoenix-Releases/releases

Connect to the RIO with a USB A to USB B. Open the Pheonix Tuner and install firmware and number the electronic parts to match your code. More detailed instructions are here: https://phoenix-documentation.readthedocs.io/en/latest/ch06_PrepRobot.html. 

The firmware can be found on the CTRE website (http://www.ctr-electronics.com/) and look up each product and go under the "Tech Resources" tab to download the firmware (.crf files). 


### Configuring the SparkMAX Controllers
The SparkMAX controller is not imaged through the Pheonix Tuner. Instead, connect a USB C from a SparkMAX to your computer. You need the SparkMAX client to do this (http://www.revrobotics.com/sparkmax-software/). More instructions on installing firmware and troubleshooting are also on the site.


### Configuring the radio
Open an application called "Radio Config Util", which can be found here: https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/144986-programming-your-radio. Plug in an ethernet cable from your computer to the port on the radio specified in the instructions on the Radio Config Util. Keep following those instructions to set your team number, radio name, firmware, etc. If there is an issue when performing these tasks, plug the ethernet cable into the other ethernet port on the radio and try again.


## Troubleshooting
Each subsystem of the "robot" branch (as of commit e6c0ba0) worked on their individual branches before being merged. If issues arise, here are the likely causes:


### Potenial Configuration Mistakes
- Check port numbers on PDP, PCMs, SparkMAXes and Talons.
- Check port numbers in the code and make sure there are no duplicates/line up with what is in real life
- Check firmware on all parts
- Check if motors are working against each other


### Potential Electrical Errors

#### Issues with the whole robot or motors
- Check connectors between wires
- Check yellow and green CAN wires

#### Issues with pneumatics
- Check voltage of PCM and voltage of the solenoids
- Check if regulator air is going the right way
