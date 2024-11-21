package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Drive;

public class DriveCmd extends Command {
    private final frc.robot.Drive drive;
    private DoubleSupplier rotate;
    private DoubleSupplier power;

    public DriveCmd(Drive drive, DoubleSupplier rotate, DoubleSupplier power){
        this.drive = drive;
        this.rotate = rotate;
        this.power = power;
        addRequirements(drive);
    }

    @Override
    public void execute(){
        drive.vroom(power.getAsDouble(), rotate.getAsDouble());
    }

    // Called once the command ends oPr is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.vroom(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
