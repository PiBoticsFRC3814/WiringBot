/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireAll extends CommandGroup {
  /**
   * Add your docs here.
   */

  public FireAll() {
    addSequential(new StartWheels(0.5));
    addSequential(new TimedFireCannon(0.2));
    addSequential(new UnFireCannon());
    addSequential(new StopWheels());
  }
}
