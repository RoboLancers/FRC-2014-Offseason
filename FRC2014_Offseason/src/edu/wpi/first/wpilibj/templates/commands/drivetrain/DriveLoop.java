/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.drivetrain;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;

/**
 *
 * @author RoboLancers
 */
public class DriveLoop extends CommandBase{

    private boolean hasFinished = false; //default false
    
    //get the inputs from the controller
    public DriveLoop(){
        requires(driveTrain);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
          double x,y;
        
        if(Math.abs(OI.driveStick.getRawAxis(2)) >= 0.1){ //x axis
            x = OI.driveStick.getRawAxis(2);
        }else{
            x = 0;
        }
        
        if(Math.abs(OI.driveStick.getRawAxis(5)) >= 0.1){ //y axis
            y = OI.driveStick.getRawAxis(5);
        }else{
            y = 0;
        } 
        
        CommandBase.driveTrain.tankDrive(x,y);
          
//          if(Math.abs(OI.driveStick.getRawAxis(1))>.1||Math.abs(OI.driveStick.getRawAxis(2))>.1){
//              x=Math.abs(OI.driveStick.getRawAxis(1));
//              y=Math.abs(OI.driveStick.getRawAxis(2));
//              //driveTrain.PIDArcade(true,,y,x);
//          }
          
        
    }

    protected boolean isFinished() {
        return hasFinished; 
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
