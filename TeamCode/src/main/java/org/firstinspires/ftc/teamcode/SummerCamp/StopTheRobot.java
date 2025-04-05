package org.firstinspires.ftc.teamcode.SummerCamp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp (name = "Stop")
public class StopTheRobot extends OpMode {
    //intro to ftc Java will prob be on slides

    ElapsedTime timer;
    //calling our DcMotor object
    DcMotor motor; //always use semicolon!
    Servo servo; //remember to import certain classes! (Usually Andriod Studios will do it tho)
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

        //Before this explain button in slides

        //setting speed to full power for 1 second
        if (gamepad1.a) {
            if (timer.milliseconds() <= 1000) {
                motor.setPower(1);
            } else if (timer.milliseconds() >= 1000) {
                motor.setPower(0);
            } else if (timer.milliseconds() >= 2000) {
                timer.reset();
                //run to a set position
                motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                motor.setTargetPosition(1000);
                motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
        }
        //tell how u got to say the pos before saying "RUN_TO_POSITION"

        //Explain getCurrentPosition
        if (gamepad1.x) {
            motor.getCurrentPosition();
        }

        if (gamepad1.b) {
            if (motor.getCurrentPosition() < 500) {
                motor.setPower(0);
            } else if (motor.getCurrentPosition() == 0) {
                motor.setPower(0.1);
            } else {
                motor.setPower(0.05);
            }
        }

        //Explain how this is simpler
        if (gamepad1.y) {
            motor.setTargetPosition(500);
            motor.setPower(0.1);
        }

    }
}
