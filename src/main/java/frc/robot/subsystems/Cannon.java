/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Cannon extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  DoubleSolenoid piston;
  WPI_TalonSRX wheels; 

  public boolean isArmed = false;

  public Cannon() {
    piston = new DoubleSolenoid(RobotMap.cannon_piston1, RobotMap.cannon_piston2);
    wheels = new WPI_TalonSRX(RobotMap.cannon_wheels);
    

  }

  public void fire() {
    piston.set(Value.kForward);
  }

  public void unfire(){
    piston.set(Value.kReverse);
  }

  public void wheelsOn(){
    wheels.set(1.0);
    isArmed = true;
  }

  public void wheelsOff(){
    wheels.set(0.0);
    isArmed = false;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
