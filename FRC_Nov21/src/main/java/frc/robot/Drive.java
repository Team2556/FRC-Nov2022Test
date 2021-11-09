package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Drive extends TimedRobot{
//piston moves
//compressor air thing
//solenoid controls those later
    
    Talon rFMotor = new Talon(0);
    Talon rRMotor = new Talon(3);
    Talon rDrop1 = new Talon(4);
    Talon rDrop2 = new Talon(99);
    SpeedControllerGroup rDrop = new SpeedControllerGroup(rDrop1, rDrop2);
    SpeedControllerGroup rSide2 = new SpeedControllerGroup(rFMotor, rDrop, rRMotor); // Yes drop




    Talon lFMotor = new Talon(1);
    Talon lRMotor = new Talon(2);
    Talon lDrop1 = new Talon(5);
    Talon lDrop2 = new Talon(98);
    SpeedControllerGroup lDrop = new SpeedControllerGroup(lDrop1, lDrop2);
    SpeedControllerGroup lSide2 = new SpeedControllerGroup(lFMotor, lDrop, lRMotor); //Yes drop

    MecanumDrive driveMecanum = new MecanumDrive(lFMotor, lRMotor, rFMotor, rRMotor);
    DifferentialDrive driveDrop = new DifferentialDrive(lSide2, rSide2);


    Compressor compressor = new Compressor(0);
    XboxController Xbox1 = new XboxController(0);


    Boolean compressorEnabled = true;



    public void doubleDrive(){
        // double drive = Xbox1.getY(Hand.kLeft);
        // double turn = Xbox1.getX(Hand.kRight);
        
        if (Xbox1.getAButton())
        {
           compressorEnabled = !compressorEnabled;
           if (compressorEnabled = true){
                compressor.start();
           }
           else{
               compressor.stop();
           }
        }

        
        if (compressor.enabled())
        {   //If the middle wheels are down, switches to tank drive.
            driveDrop.tankDrive(Xbox1.getY(Hand.kLeft), Xbox1.getY(Hand.kRight));
        }
            driveMecanum.driveCartesian(Xbox1.getY(Hand.kLeft), Xbox1.getX(Hand.kLeft), Xbox1.getX(Hand.kRight));
            //Drives classic mecanum otherwise.
    }

    

}