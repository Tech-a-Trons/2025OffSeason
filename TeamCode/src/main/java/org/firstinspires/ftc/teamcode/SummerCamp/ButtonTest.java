package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name = "BUTTONS")
public class ButtonTest extends OpMode {
    //intro to ftc Java will prob be on slides
    //calling our DcMotor object
    DcMotor motor; //always use semicolon!

    @Override
    public void init() {
        //assigning the name on our control hub
        motor = hardwareMap.get(DcMotor.class, "motor");
        //setting how we would like to control the motor
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void loop() {

        if (gamepad1.dpad_down) {
            motor.setPower(-0.05);
        }
        if (gamepad1.dpad_up) {
            motor.setPower(0.05);
        }
    }
}