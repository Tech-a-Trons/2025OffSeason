package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "ServosD2")
public class Servos extends OpMode {
    Servo servo;

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class,"Servo");
    }

    @Override
    public void loop() {
        if (gamepad1.b) {
            servo.setPosition(1);
        }
    }
}
