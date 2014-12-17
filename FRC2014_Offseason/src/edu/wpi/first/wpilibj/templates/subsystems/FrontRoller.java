/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.IntakeLoop;

/**
 *
 * @author RoboLancers
 */
public class FrontRoller extends Subsystem{

    public static DoubleSolenoid ds;
    public static SpeedController roller;
    
    public FrontRoller(){
        super("Front Roller");
        ds = new DoubleSolenoid(RobotMap.kFrontRollerFwd,RobotMap.kFrontRollerRev);
        roller = new Talon(RobotMap.kFrontMotor);
        ds.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeLoop(CommandBase.frontRoller));
    }
    
}
