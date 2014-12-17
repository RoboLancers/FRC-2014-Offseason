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
public class ThreeBallAuto extends CommandBase{
    private boolean hasFinished;
    long timeStart=System.currentTimeMillis();

    public ThreeBallAuto(){
        requires(driveTrain);
        requires(rearRoller);
        requires(frontRoller);
    }
    
    protected void initialize() {
       PIDDriveTrain.driveSolenoid.set(DoubleSolenoid.Value.kForward); //Make sure the drive is in high gear
       FrontRoller.ds.set(DoubleSolenoid.Value.kForward); //make sure both is down
       RearRoller.ds.set(DoubleSolenoid.Value.kForward);
       
       
    }

    protected void execute() {
        //move to the goal using gyro
        if((System.currentTimeMillis()-timeStart) < 1000){
            //Move Forward
            //DriveTrain.arcadeDrive(0, 100);
        }
        if((System.currentTimeMillis()-timeStart) > 3000 && (System.currentTimeMillis()-timeStart) < 5000){
            FrontRoller.ds.set(DoubleSolenoid.Value.kReverse); //bring up and push 
            FrontRoller.roller.set(1.00); //make sure the ball is out completely
        }
        if((System.currentTimeMillis()-timeStart) > 5000 && (System.currentTimeMillis()-timeStart) < 6000){
            //DriveTrain.arcadeDrive(0, 0); //stop the robot
            //score the rear ball through the front
            RearRoller.ds.set(DoubleSolenoid.Value.kReverse);
            RearRoller.roller.set(-1.00);
        }
        if((System.currentTimeMillis()-timeStart) > 8000){
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
