/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.PIDDriveTrain;

/**
 *
 * @author RoboLancers
 */
public class OneBallAuto extends CommandBase {
    private long timeStart;
    
    public OneBallAuto() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        PIDDriveTrain.driveSolenoid.set(DoubleSolenoid.Value.kForward);
        
        timeStart = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if((System.currentTimeMillis()-timeStart) < 1000){
            PIDDriveTrain.tankDrive(-1.00,-1.00); //drive Forward
        }
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
