/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class DriveForward extends CommandBase{
    private boolean hasFinished;
    private long timeStart;
    
    public DriveForward(){
        requires(driveTrain);
    }

    protected void initialize() {
        timeStart = System.currentTimeMillis(); // init timer
        driveTrain.tankDrive(0, 0);
    }

    protected void execute() {
        if((System.currentTimeMillis()-timeStart) > 4000 && (System.currentTimeMillis()-timeStart) < 6000){ //wait 4 seconds befroe starting the drive
            driveTrain.tankDrive(-1.00,-1.00); //start the drive
        }
        if((System.currentTimeMillis()-timeStart) > 6000){ //stop after 2 seconds
            driveTrain.tankDrive(0, 0); //stop the robot
            hasFinished = true;
        }
    }

    protected boolean isFinished() {
        return hasFinished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        end();
    }
    
}
 