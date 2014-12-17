/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands.compressor;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author RoboLancers
 */
public class CompressorLoop extends CommandBase{

   private boolean hasFinished = false;
    
    public CompressorLoop(){
        requires(robotCompressor);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        CommandBase.robotCompressor.runCompressor();
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
