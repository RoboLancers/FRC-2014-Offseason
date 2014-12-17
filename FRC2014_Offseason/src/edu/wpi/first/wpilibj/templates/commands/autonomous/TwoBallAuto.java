/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.FrontRoller;
import edu.wpi.first.wpilibj.templates.subsystems.PIDDriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.RearRoller;

/**
 *
 * @author RoboLancers
 */
public class TwoBallAuto extends CommandBase{
    private boolean hasFinished;
    long timeStart;

    public TwoBallAuto(){
        requires(driveTrain);
        requires(rearRoller);
        requires(frontRoller);
    }
    
    protected void initialize() {
       PIDDriveTrain.driveSolenoid.set(DoubleSolenoid.Value.kForward); //Make sure the drive is in high gear
       FrontRoller.ds.set(DoubleSolenoid.Value.kReverse); //front roller forward
       RearRoller.ds.set(DoubleSolenoid.Value.kForward); //back roller down
       timeStart = System.currentTimeMillis();
       
    }

    protected void execute() {
        //move to the goal using gyro
        if((System.currentTimeMillis()-timeStart) < 1000){
            PIDDriveTrain.tankDrive(-1.00,-1.00);
            //driveTrain.setSetpoint(0); //set the setpoint to 0 degrees(straight)
            //driveTrain.enable(); //enable the PID Control
        }
        if((System.currentTimeMillis()-timeStart) > 4000 && (System.currentTimeMillis()-timeStart) < 5000){
            //driveTrain.disable(); //end the PID Control
            PIDDriveTrain.tankDrive(0, 0); //stop the robot 
            //Score the first ball
            FrontRoller.roller.set(1.00);
        }
        if((System.currentTimeMillis()-timeStart) > 5000 && (System.currentTimeMillis()-timeStart) < 6000){
            RearRoller.roller.set(-1.00); //intake back
        }
        if((System.currentTimeMillis()-timeStart) > 6000 && (System.currentTimeMillis()-timeStart) < 9000){
            RearRoller.ds.set(DoubleSolenoid.Value.kReverse);//pick up back
        }
        if((System.currentTimeMillis()-timeStart) > 9000){
            FrontRoller.roller.set(0);
            RearRoller.roller.set(0);
        }
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
