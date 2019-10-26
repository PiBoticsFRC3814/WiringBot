/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick driverJoy = new Joystick(RobotMap.oi_driver);

  public Button Fire = new JoystickButton(driverJoy, 3);
  public Button Arm = new JoystickButton(driverJoy, 2);
  public Button All = new JoystickButton(driverJoy, 1);

  public OI(){
    //Fire.whenPressed(new FireCannon());
    //Fire.whenReleased(new UnFireCannon());
    All.whenPressed(new FireAll());
    //Arm.whenPressed(new ToggleArm());
  }
}