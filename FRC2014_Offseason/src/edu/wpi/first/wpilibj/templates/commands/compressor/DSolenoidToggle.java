/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.compressor;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class DSolenoidToggle extends CommandBase{

    
    private boolean hasFinished = false;
    private Subsystem heldIn;
    private DoubleSolenoid ds;
    
    public DSolenoidToggle(Subsystem heldIn, DoubleSolenoid ds){
       this.heldIn = heldIn;
       this.ds = ds;
        
        requires(heldIn);
    }
    
    protected void initialize(){ 
         hasFinished = false;
         
        if(ds.get() == DoubleSolenoid.Value.kForward){
            ds.set(DoubleSolenoid.Value.kReverse);
        }else{
            ds.set(DoubleSolenoid.Value.kForward);
        }
        hasFinished = true;
      
        
    }

    protected void execute() {
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
