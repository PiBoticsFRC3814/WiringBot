/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.*;

public class DriveLimelight extends Command {

  double xs, ys, zs;
  public DriveLimelight() {
    requires(Robot.m_Limelight);
    requires(Robot.m_DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_Limelight.getData();
    SmartDashboard.putBoolean("Target Aquired", Robot.m_Limelight.isValidTarget());
    if (Robot.m_Limelight.x > 1)
    {
      xs = -0.3;
    }
    else if (Robot.m_Limelight.x < -1)
    {
      xs = 0.3;
    }
    else
    {
      xs = 0;
    }
    
    if (Robot.m_Limelight.yaw > 2)
    {
      ys = 0.1;
    }
    else if (Robot.m_Limelight.yaw < -2)
    {
      ys = -0.1;
    }
    else
    {
      ys = 0;
    }
    if (Robot.m_Limelight.z < -20)
    {
      zs = -0.2;
    }
    else
    {
      zs = 0;
    }

    Robot.m_DriveTrain.curvatureDrive(ys, xs);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (Robot.m_Limelight.isValidTarget())
    {
      return false;
    }
    else
    {
      return true;
    }
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