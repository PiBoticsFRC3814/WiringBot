/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoy;

import com.ctre.phoenix.motorcontrol.can.*;
import com.analog.adis16448.frc.*;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  
  WPI_TalonSRX lf;
  WPI_TalonSRX lr;
  WPI_TalonSRX rf;
  WPI_TalonSRX rr;

  MecanumDrive piboticsDrive;

  ADIS16448_IMU gyro;

  public DriveTrain(){
    lf = new WPI_TalonSRX(RobotMap.drive_lf);
    lr = new WPI_TalonSRX(RobotMap.drive_lr);
    rf = new WPI_TalonSRX(RobotMap.drive_rf);
    rr = new WPI_TalonSRX(RobotMap.drive_rr);

    piboticsDrive = new MecanumDrive(lf, lr, rf, rr);

    gyro = new ADIS16448_IMU();

    lf.setInverted(true);
    lr.setInverted(true);

  }
  
  public void mecanumDrive(double y, double x, double z, double gyro){
    piboticsDrive.driveCartesian(x, y, z, gyro);
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

  public boolean getLFDirection(){
    return lf.getInverted();
  }

  public boolean getLRDirection(){
    return lr.getInverted();
  }

  public boolean getRFDirection(){
    return rf.getInverted();
  }

  public boolean getRRDirection(){
    return rr.getInverted();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveJoy());
  }
}
