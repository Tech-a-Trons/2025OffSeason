package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Day1 extends OpMode {
    //intro to ftc Java will prob be on slides

    ElapsedTime timer;
    //calling our DcMotor object
    DcMotor motor; //always use semicolon!
    @Override
    public void init() {
    //assigning the name on our control hub
    motor = hardwareMap.get(DcMotor.class,"motor");
    //setting how we would like to control the motor
    motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    @Override
    public void loop() {


        //setting speed to full power for 1 second
        if(timer.milliseconds()<=1000) {
            motor.setPower(1);
        }else if(timer.milliseconds()>=1000) {
            motor.setPower(0);
        }else if(timer.milliseconds()>=2000){
            timer.reset();


        }

        //next, code run to position






    }
}
