/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.GetLimelight;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  
  public double[] data = {0,0,0,0,0,0};

  public double x = 0, z = 0, yaw = 0;  

public void getData(){
   data = NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran").getDoubleArray(data);
   x = data[0];
   z = data[2];
   yaw = data[4];
   
}

public boolean isValidTarget(){
  if (x == 0.0 && yaw == 0.0 && z == 0.0)
  {
   return false;
  }
  else
  {
    return true;
  }
}

public void displayOutput() {
  getData();
  SmartDashboard.putNumberArray("Camtran1", data);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new GetLimelight());
  }
}