package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "Servos")
public class Servos extends OpMode {

    Servo servo;

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class,"Servo");
    }

    @Override
    public void loop() {

        //explain how to move/reset servos (let them tinker w/positions)
        if (gamepad1.b) {
            servo.setPosition(1);
        }
        if (gamepad1.a) {
            servo.setPosition(0);
        }


    }
}
