/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.FrontRoller;
import edu.wpi.first.wpilibj.templates.subsystems.RearRoller;

/**
 *
 * @author RoboLancers
 */
public class IntakeLoop extends CommandBase{
    
    private boolean hasFinished = false;
    private Subsystem intake;

    public IntakeLoop(Subsystem intake){
        this.intake = intake;
        
        requires(intake);
    }
    protected void initialize() {
        
    }

    protected void execute() {
        if(intake.getName().equals("Front Roller")){
            if(OI.maniBtn3.get()){ //the front left button
                FrontRoller.roller.set(-1.00);
            }
            else if(OI.maniBtn5.get()){ //the back left button
                FrontRoller.roller.set(1.00);
            }else{
                FrontRoller.roller.set(0);
            }  
        }
        
        if(intake.getName().equals("Rear Roller")){
            if(OI.maniBtn4.get()){ //the front right button
                RearRoller.roller.set(-1.00);
            }
            else if(OI.maniBtn6.get()){ //the back right button
                RearRoller.roller.set(1.00);
            }else{
                RearRoller.roller.set(0);
            }    
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
