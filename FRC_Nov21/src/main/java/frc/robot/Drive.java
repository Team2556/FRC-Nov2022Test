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
    Talon rDrop = new Talon(4);
    SpeedControllerGroup rSideS = new SpeedControllerGroup(rFMotor, rRMotor); //No drop
    SpeedControllerGroup rSide2 = new SpeedControllerGroup(rFMotor, rDrop, rRMotor); // Yes drop




    Talon lFMotor = new Talon(1);
    Talon lRMotor = new Talon(2);
    Talon lDrop = new Talon(5);
    SpeedControllerGroup lSideS = new SpeedControllerGroup(lFMotor, lRMotor); //No drop
    SpeedControllerGroup lSide2 = new SpeedControllerGroup(lFMotor, lDrop, lRMotor); //Yes drop

    MecanumDrive driveMecanum = new MecanumDrive(lFMotor, lRMotor, rFMotor, rRMotor);
    DifferentialDrive driveDrop = new DifferentialDrive(lSide2, rSide2);


    Compressor compressor = new Compressor(0);
    XboxController Xbox1 = new XboxController(0);






    public void Drivebase(){
        // double drive = Xbox1.getY(Hand.kLeft);
        // double turn = Xbox1.getX(Hand.kRight);
        boolean wheelDrop = true; //I don't want to research syntax for this. 
        if (wheelDrop){
            Drive.driveDrop(1,1);
        }
        driveMecanum();


    }

    

}