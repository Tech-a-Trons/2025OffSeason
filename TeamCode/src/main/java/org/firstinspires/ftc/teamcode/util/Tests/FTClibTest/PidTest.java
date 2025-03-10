package org.firstinspires.ftc.teamcode.Util.Tests.FTClibTest;



import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
@TeleOp(name = "PIDTEST")

public class PidTest extends LinearOpMode {

    private PIDController controller;

    public static double p =0.02,i=0, d =0;
    public static double f=0.15;


    public static int target;
    double ticksInMM = 537.7/120.0;
    double targetInMM;
    DcMotor lsl; // linear slides left
    DcMotor lsr; // linear slides right


    @Override
    public void runOpMode() throws InterruptedException {
        controller = new PIDController(p, i, d);
       telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        lsl = hardwareMap.get(DcMotor.class,"lsl");
        lsr = hardwareMap.get(DcMotor.class,"lsr");

        lsr.setDirection(DcMotorSimple.Direction.REVERSE);




        waitForStart();
        while (opModeIsActive()) {
          controller.setPID(p,i,d);
            targetInMM = (int)(ticksInMM*target);
            //  double BothLSCurrentPos = lsl.getCurrentPosition()*0.5 + lsr.getCurrentPosition()*0.5;
//            double lsAveragePos = BothLSCurrentPos;

            double lsAveragePos = lsl.getCurrentPosition();// the method for this is that the position for lsl and lsr is
            //generally the the same. I have included a commented out code wich gets both, I just didnt want it to be too complex;
            double pid = controller.calculate(lsAveragePos, target);
            double ff =f;
            double power = pid + ff;

            lsl.setPower(power);
            lsr.setPower(power);

            telemetry.addData("target in mm", targetInMM);
            telemetry.addData(" normal target", target);
            telemetry.addData("Arm Pos", lsAveragePos);

            telemetry.update();
        }
    }
}
