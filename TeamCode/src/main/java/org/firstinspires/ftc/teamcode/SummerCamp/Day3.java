package org.firstinspires.ftc.teamcode.SummerCamp;



import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


// using the config @interface, dont think too much of this right now
@Config
public class Day3 extends OpMode {
   //using ftc dashboard
    public static int targetPos=0;
    DcMotor motor;
    Servo servo;

    @Override
    public void init() {
       //functions
        hardwareInit();
    }

    @Override
    public void loop() {
        //helpful for linear slides
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setTargetPosition(targetPos);

    }

    public void hardwareInit(){
        motor = hardwareMap.get(DcMotor.class,"motor1");
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //exceptions
        servo = hardwareMap.get(Servo.class,"Servo");
    }
}
