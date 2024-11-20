package frc.robot;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicTorqueCurrentFOC;
import com.ctre.phoenix6.controls.StrictFollower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase{

    private TalonFX motorFR;
    private TalonFX motorFL;
    private TalonFX motorBR;
    private TalonFX motorBL;

    private final DifferentialDrive m_robotDrive =
      new DifferentialDrive(motorFL::set, motorFR::set);

  public Drive() {
    motorFR = new TalonFX(3);
    motorFL = new TalonFX(1);
    motorBL = new TalonFX(4);
    motorBR = new TalonFX(2);

    motorBR.setControl(new Follower(motorFR.getDeviceID(), false));
    motorBL.setControl(new Follower(motorFL.getDeviceID(), false));
    motorBR.setControl(new StrictFollower(motorFR.getDeviceID()));
    motorBL.setControl(new StrictFollower(motorFL.getDeviceID()));

    motorFR.setInverted(true);

    SendableRegistry.addChild(m_robotDrive, motorFR);
    SendableRegistry.addChild(m_robotDrive, motorFL);
  }

  public void vroom(double power, double rotate) {
    m_robotDrive.arcadeDrive(power, rotate);
  }
}