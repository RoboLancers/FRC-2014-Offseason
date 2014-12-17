
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.compressor.DSolenoidToggle;
import edu.wpi.first.wpilibj.templates.subsystems.FrontRoller;
import edu.wpi.first.wpilibj.templates.subsystems.PIDDriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.RearRoller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static Joystick driveStick = new Joystick(1);
    public static Joystick maniStick = new Joystick(2);
    public static JoystickButton driveBtn1 = new JoystickButton(driveStick,1),
            driveBtn2 = new JoystickButton(driveStick,2),
            driveBtn3 = new JoystickButton(driveStick,3),
            driveBtn4 = new JoystickButton(driveStick,4),
            driveBtn5 = new JoystickButton(driveStick,5),
            driveBtn6 = new JoystickButton(driveStick,6),
            driveBtn7 = new JoystickButton(driveStick,7),
            driveBtn8 = new JoystickButton(driveStick,8),
            driveBtn9 = new JoystickButton(driveStick,9),
            driveBtn10 = new JoystickButton(driveStick,10),
            driveBtn11 = new JoystickButton(driveStick,11),
            driveBtn12 = new JoystickButton(driveStick,12);
    public static JoystickButton maniBtn1 = new JoystickButton(maniStick,1),
            maniBtn2 = new JoystickButton(maniStick,2),
            maniBtn3 = new JoystickButton(maniStick,3),
            maniBtn4 = new JoystickButton(maniStick,4),
            maniBtn5 = new JoystickButton(maniStick,5),
            maniBtn6 = new JoystickButton(maniStick,6),
            maniBtn7 = new JoystickButton(maniStick,7),
            maniBtn8 = new JoystickButton(maniStick,8),
            maniBtn9 = new JoystickButton(maniStick,9),
            maniBtn10 = new JoystickButton(maniStick,10),
            maniBtn11 = new JoystickButton(maniStick,11),
            maniBtn12 = new JoystickButton(maniStick,12);
            
            
            
            
    
    
    
    public OI(){
                
        driveBtn1.whenReleased(new DSolenoidToggle(CommandBase.driveTrain, PIDDriveTrain.driveSolenoid));
        
        maniBtn7.whenReleased(new DSolenoidToggle(CommandBase.frontRoller, FrontRoller.ds));
        maniBtn8.whenReleased(new DSolenoidToggle(CommandBase.rearRoller, RearRoller.ds));
    }
}