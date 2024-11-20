package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drive;

public class DriveCmd extends Command {
    private final frc.robot.Drive drive;
    private double rotate;
    private double power;

    public DriveCmd(Drive drive, double rotate, double power){
        this.drive = drive;
        this.rotate = rotate;
        this.power = power;
        addRequirements(drive);
    }

    @Override
    public void execute(){
        System.out.println(rotate);
        System.out.println(power);

        drive.vroom(power, rotate);
    }

    // Called once the command ends oPr is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
