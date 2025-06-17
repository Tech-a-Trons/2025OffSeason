package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class day2 extends LinearOpMode  {
    DcMotor motor;
    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class,"motor");
        waitForStart();
        while(opModeIsActive()) {
            motor.setPower(0.05);
        }
    }
}