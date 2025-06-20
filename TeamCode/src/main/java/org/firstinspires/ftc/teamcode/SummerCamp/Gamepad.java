package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "Gamepad")
public class Gamepad extends OpMode {

    DcMotor motor;
    @Override
    public void init() {
        motor = hardwareMap.get(DcMotor.class,"motor");
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            motor.setPower(-0.0001);
        }
    }
}