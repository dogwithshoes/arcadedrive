package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCmd;

public class RobotContainer {

    private final CommandXboxController driver = new CommandXboxController(0);
    private final Drive m_drive = new Drive();
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
   }
 
  private void configureBindings() {
    m_drive.setDefaultCommand(
      new DriveCmd(
        m_drive, 
        -driver.getLeftX(),
        -driver.getRightY()
        ));
  }
}
