/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.compressor.CompressorLoop;

/**
 *
 * @author RoboLancers
 */
public class RobotCompressor extends Subsystem{
    
    Compressor compressor;

    public RobotCompressor(){
        compressor = new Compressor(RobotMap.KpressureSwitch, RobotMap.Kcompressor);
        compressor.setRelayValue(Relay.Value.kOn);
        compressor.start();
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(new CompressorLoop());
    }
    
    public void runCompressor(){
        if(compressor.getPressureSwitchValue()){ //is the PsI in the system 120?
            compressor.stop();
        }else{
            compressor.start();
        }
    }
    
    
    
}
