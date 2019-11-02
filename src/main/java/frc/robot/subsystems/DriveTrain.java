/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoy;

import com.ctre.phoenix.motorcontrol.can.*;
import com.analog.adis16448.frc.*;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  
  WPI_TalonSRX Right;
  WPI_TalonSRX Left;

  DifferentialDrive piboticsDrive;

  ADIS16448_IMU gyro;

  public DriveTrain(){
    Right = new WPI_TalonSRX(RobotMap.Right);
    Left = new WPI_TalonSRX(RobotMap.Left);


    piboticsDrive = new DifferentialDrive(Right, Left);

    gyro = new ADIS16448_IMU();

  }
  
  public void curvatureDrive(double y, double x){
      piboticsDrive.curvatureDrive(y, x, false);
  }

  public double getAngle(){
    return gyro.getAngleZ();
  }

  public void gyroCalibrate(){
    gyro.calibrate();
  }

  public void gyroReset(){
    gyro.reset();
  }

  public Boolean getGyroStatus(){
    return false;
  }

  public boolean getRightDirection(){
    return Right.getInverted();
  }

  public boolean getLeftDirection(){
    return Left.getInverted();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveJoy());
  }
}
