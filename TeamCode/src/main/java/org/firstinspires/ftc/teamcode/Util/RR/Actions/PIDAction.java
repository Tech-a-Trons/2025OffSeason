package org.firstinspires.ftc.teamcode.Util.RR.Actions;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class PIDAction implements Action {

    private DcMotor lsr;
    private DcMotor lsl;
    private int targetPosition;
    private PIDController pidController;
    private double p = 0.02, i = 0.0, d = 0.0;  // You can tune these PID values

    public PIDAction(DcMotor lsr, DcMotor lsl, int targetPosition) {

        this.lsr = lsr;
        this.lsl = lsl;
        this.targetPosition = targetPosition;
        this.pidController = new PIDController(p, i, d);
    }

    @Override
    public boolean run(TelemetryPacket packet) {

        // Set target position for both motors
        lsr.setTargetPosition(targetPosition);
        lsl.setTargetPosition(targetPosition);

        // Set motors to RUN_TO_POSITION mode
        lsr.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        lsl.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        // Get the current position (use average if necessary)
        double currentPosition = (lsl.getCurrentPosition() + lsr.getCurrentPosition()) / 2.0;

        // Calculate the PID output based on the current position and target
        double pidOutput = pidController.calculate(currentPosition, targetPosition);

        // Set the power to the motors based on the PID output
        double power = pidOutput;

        // Limit the power to the range [-1, 1]
        power = Math.max(-1.0, Math.min(1.0, power));

        // Apply the power to both motors
        lsr.setPower(power);
        lsl.setPower(power);

        // Telemetry for debugging purposes
        packet.put("PID Output", pidOutput);
        packet.put("Current Position", currentPosition);
        packet.put("Target Position", targetPosition);
        packet.put("Left Slide Power", lsl.getPower());
        packet.put("Right Slide Power", lsr.getPower());

        // Check if both motors have reached the target position
        if (lsl.isBusy() || lsr.isBusy()) {
            return true; // The action is still running
        } else {

            return false; // Action is complete
        }
    }
}