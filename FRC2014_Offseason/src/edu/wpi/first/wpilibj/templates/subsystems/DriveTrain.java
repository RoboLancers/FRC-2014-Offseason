/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveLoop;

/**
 *
 * @author RoboLancers
 */
public class DriveTrain extends PIDSubsystem{
    
    public static SpeedController motor1, motor2, motor3, motor4, motor5, motor6; //6 motors
    public static DoubleSolenoid driveSolenoid; //1 double solenoid 
    public static Gyro gyro;
    public static Encoder encoderLeft, encoderRight;
    
    public static final double kP = 1.0;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double kTolerance = 3.0;

    public DriveTrain(){
        super("Drive Train",kP, kI, kD);
        setAbsoluteTolerance(kTolerance);
        
        motor1 = new Talon(RobotMap.KdriveMotor1);
        motor2 = new Talon(RobotMap.KdriveMotor2);
        motor3 = new Talon(RobotMap.KdriveMotor3);
        motor4 = new Talon(RobotMap.KdriveMotor4);
        motor5 = new Talon(RobotMap.KdriveMotor5);
        motor6 = new Talon(RobotMap.KdriveMotor6);
        
        driveSolenoid = new DoubleSolenoid(RobotMap.KdriveSolenoidFwd,RobotMap.KdriveSolenoidRev);
        
        gyro = new Gyro(RobotMap.kGyro);
        //encoderLeft = new Encoder();
        
        driveSolenoid.set(DoubleSolenoid.Value.kForward); //LOW  -- More Speed
        
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new DriveLoop());
    }
    
    protected double returnPIDInput() {
        return gyro.getAngle();
    }
    
    protected void usePIDOutput(double d) {
         tankDrive(d,d);
    }
    
    public void arcadeDrive(double x, double y){
        //left side
        motor1.set(x-y);
        motor2.set(x-y);
        motor3.set(x-y);
        
        //right side
        motor4.set(x-y);
        motor5.set(x-y);
        motor6.set(x-y);
    }
    
    public void tankDrive(double x, double y) {
        //left side
        motor1.set(x);
        motor2.set(x);
        motor3.set(x);
        
        //right side
        motor4.set(-y);
        motor5.set(-y);
        motor6.set(-y);
    }
    
    public double getGyroAngle(){
        return gyro.getAngle();
    }
    
    public void resetGyro(){
        gyro.reset();
    }
   
    
}
