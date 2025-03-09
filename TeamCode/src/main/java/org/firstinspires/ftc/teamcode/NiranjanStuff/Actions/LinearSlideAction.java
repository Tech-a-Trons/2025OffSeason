package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class LinearSlideAction implements Action {
    private DcMotorEx lsr;
    private DcMotorEx lsl;
    private int targetPosition;
    public LinearSlideAction(DcMotorEx lsr, DcMotorEx lsl, int targetPosition) {
        this.lsr = lsr;
        this.lsl = lsl;
        this.targetPosition = targetPosition;
    }
    @Override
    public boolean run(TelemetryPacket packet) {
        lsr.setTargetPosition(targetPosition);
        lsl.setTargetPosition(targetPosition);
        lsr.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        lsl.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        lsr.setPower(1.0);
        lsl.setPower(1.0);
        if (lsr.isBusy() || lsl.isBusy()) {
            packet.put("lsrPosition", lsr.getCurrentPosition());
            packet.put("lslPosition", lsl.getCurrentPosition());
            return true;
        } else {
            if (!lsr.isBusy() && !lsl.isBusy()) {
                lsr.setPower(0.1); // Small power to hold position
                lsl.setPower(0.1); // Small power to hold position
            }
            return false;
        }
    }
}