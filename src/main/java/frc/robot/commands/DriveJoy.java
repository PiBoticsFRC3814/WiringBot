/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveJoy extends Command {
  public DriveJoy() {
    requires(Robot.m_DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double x, y, z, gyro;

    
    y = Robot.m_oi.driverJoy.getY();
    z = Robot.m_oi.driverJoy.getZ();

    if (Robot.m_oi.driverJoy.getX() > RobotMap.deadzoneX || Robot.m_oi.driverJoy.getX() < RobotMap.deadzoneX)
    {
      x = -Robot.m_oi.driverJoy.getX(); 

      if (x < 0.0)
      {
        x = x + RobotMap.deadzoneX;
      }
      if (x > 0.0)
      {
        x = x - RobotMap.deadzoneX;
      }

    }
    else x = 0.0;
    
    if (Robot.m_oi.driverJoy.getY() > RobotMap.deadzoneY || Robot.m_oi.driverJoy.getY() < RobotMap.deadzoneY)
    {
      y = Robot.m_oi.driverJoy.getY(); 

      if (y < 0.0)
      {
        y = y + RobotMap.deadzoneY;
      }
      if (y > 0.0)
      {
        y = y - RobotMap.deadzoneY;
      }

    }
    else y = 0.0;

    if (Robot.m_oi.driverJoy.getZ() > RobotMap.deadzoneZ || Robot.m_oi.driverJoy.getZ() < RobotMap.deadzoneZ)
    {
      z = -Robot.m_oi.driverJoy.getZ(); 

      if (z < 0.0)
      {
        z = z + RobotMap.deadzoneZ;
      }
      if (z > 0.0)
      {
        z = z - RobotMap.deadzoneZ;
      }

    }
    else z = 0.0;
    
    if (Robot.m_oi.driverJoy.getRawButton(8))
    {
      x = x/2.0;
      y = y/2.0;
      z = z/2.0;
    }

    if (Robot.m_oi.driverJoy.getRawButton(5))
    {
      Robot.m_DriveTrain.gyroReset();
    }

    gyro = Robot.m_DriveTrain.getAngle();

    Robot.m_DriveTrain.mecanumDrive(y, x, z, -gyro);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
