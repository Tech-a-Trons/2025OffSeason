package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain extends LinearOpMode {

    DcMotor motor;
    DcMotor motor2;
    DcMotor motor3;
    DcMotor motor4;

    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class, "fl");
        motor2 = hardwareMap.get(DcMotor.class, "fr");
        motor3 = hardwareMap.get(DcMotor.class, "bl");
        motor4 = hardwareMap.get(DcMotor.class, "br");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        motor.setTargetPosition(1000);
        motor2.setTargetPosition(1000);
        motor3.setTargetPosition(1000);
        motor4.setTargetPosition(1000);

        motor.setPower(0.05);
        motor2.setPower(0.05);
        motor3.setPower(0.05);
        motor4.setPower(0.05);

        motor.setTargetPosition(0);
        motor2.setTargetPosition(0);
        motor3.setTargetPosition(0);
        motor4.setTargetPosition(0);

        motor.setPower(0.05);
        motor2.setPower(0.05);
        motor3.setPower(0.05);
        motor4.setPower(0.05);

        motor.setTargetPosition(1000);
        motor4.setTargetPosition(1000);
        motor2.setTargetPosition(1000);
        motor3.setTargetPosition(1000);

        motor.setPower(0.05);
        motor2.setPower(-0.05);
        motor3.setPower(-0.05);
        motor4.setPower(0.05);

        motor.setTargetPosition(0);
        motor4.setTargetPosition(0);
        motor2.setTargetPosition(0);
        motor3.setTargetPosition(0);

        motor.setPower(-0.05);
        motor2.setPower(0.05);
        motor3.setPower(0.05);
        motor4.setPower(-0.05);

        motor.setTargetPosition(500);
        motor4.setTargetPosition(500);
        motor2.setTargetPosition(500);
        motor3.setTargetPosition(500);

        motor.setPower(-0.05);
        motor2.setPower(0.05);
        motor3.setPower(-0.05);
        motor4.setPower(0.05);

        motor.setTargetPosition(0);
        motor4.setTargetPosition(0);
        motor2.setTargetPosition(0);
        motor3.setTargetPosition(0);

        motor.setPower(0.05);
        motor2.setPower(-0.05);
        motor3.setPower(0.05);
        motor4.setPower(-0.05);
    }
}