/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drivetrain.DriveLoop;

/**
 *
 * @author RoboLancers
 */
public class PIDDriveTrain extends PIDSubsystem{
    
    public static SpeedController motor1, motor2, motor3, motor4, motor5, motor6; //6 motors
    public static DoubleSolenoid driveSolenoid; //1 double solenoid 
    public static Gyro gyro;
    public static PIDSource source;
    public static PIDOutput output; 
    public static Encoder leftEncoder, rightEncoder;
    
    public static final double kP = 1.0;
    public static final double kI = 1.0;
    public static final double kD = 1.0;
    public static final double kTolerance = 3.0;
    
    public double /*final*/ kTranslate; // such that joystickValMax/(kTranslate*encoderMax)=1
    public double error;
    public double errorInit = 0;
    public double proportion;
    public double integral = 0;
    public double derivative;
    public long time;
    
    

    public PIDDriveTrain(){
        super("Drive Train",kP, kI, kD);
        setAbsoluteTolerance(kTolerance);
        
        motor1 = new Talon(RobotMap.KdriveMotor1);
        motor2 = new Talon(RobotMap.KdriveMotor2);
        motor3 = new Talon(RobotMap.KdriveMotor3);
        motor4 = new Talon(RobotMap.KdriveMotor4);
        motor5 = new Talon(RobotMap.KdriveMotor5);
        motor6 = new Talon(RobotMap.KdriveMotor6);
        
        //PIDSource 
        
        driveSolenoid = new DoubleSolenoid(RobotMap.KdriveSolenoidFwd,RobotMap.KdriveSolenoidRev);
        
        gyro = new Gyro(RobotMap.kGyro);
        
        driveSolenoid.set(DoubleSolenoid.Value.kForward); //LOW  -- More Speed
        
        //leftEncoder = new Encoder(1,2); //TODO: Fix this shit
        //rightEncoder = new Encoder(3,4);
        
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new DriveLoop());
    }
    
    protected double returnPIDInput() {
        return gyro.getAngle();
    }
    
    public void PIDArcade(Encoder leftEncoder, Encoder rightEncoder,
            boolean correctRight, double joystickAxisY, double joystickAxisX){
        
        time = System.currentTimeMillis();
        
         if(correctRight){
             error = (joystickAxisY-joystickAxisX)- rightEncoder.getRaw()*kTranslate;
         }else{
             error = (joystickAxisY-joystickAxisX)- leftEncoder.getRaw()*kTranslate;
         }
         
         proportion = kP*error;
         integral = integral + kI*(error*(System.currentTimeMillis()-time));
         derivative = (error - errorInit)/(System.currentTimeMillis()-time); 
         errorInit=error;
         
         double speed = (proportion + integral + derivative);
         
         if(correctRight){
             motor4.set(speed);
             motor5.set(speed);
             motor6.set(speed);
         }else{
             motor1.set(speed);
             motor2.set(speed);
             motor3.set(speed);
         }  
    }
    
    protected void usePIDOutput(double d) {
         //tankDrive(d,d);
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
    
    public static void tankDrive(double x, double y) {
        //right side
        motor1.set(-y);
        motor2.set(-y);
        motor3.set(-y);
        
        //left side
        motor4.set(x);
        motor5.set(x);
        motor6.set(x);
    }
    
    public double getGyroAngle(){
        return gyro.getAngle();
    }
    
    public void resetGyro(){
        gyro.reset();
    }
   
    
}
