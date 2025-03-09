package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class SzoneSlide implements Action {
    private DcMotor SzoneSlide;
    private int targetPosition;
    private PIDController pidController;
    private double p = 0.02, i = 0.0, d = 0.0;  // You can tune these PID values

    public SzoneSlide(DcMotor SzoneSlide, int targetPosition) {

        this.SzoneSlide = SzoneSlide;
        this.targetPosition = targetPosition;
        this.pidController = new PIDController(p, i, d);
    }

    @Override
    public boolean run(TelemetryPacket packet) {

        // Set target position for both motors
        SzoneSlide.setTargetPosition(targetPosition);

        // Set motors to RUN_TO_POSITION mode
        SzoneSlide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        // Get the current position (use average if necessary)
        double currentPosition = (SzoneSlide.getCurrentPosition());

        // Calculate the PID output based on the current position and target
        double pidOutput = pidController.calculate(currentPosition, targetPosition);

        // Set the power to the motors based on the PID output
        double power = pidOutput;

        // Limit the power to the range [-1, 1]
        power = Math.max(-1.0, Math.min(1.0, power));

        // Apply the power to both motors
        SzoneSlide.setPower(power);


        // Check if both motors have reached the target position
        if (SzoneSlide.isBusy()) {
            return true; // The action is still running
        } else {

            return false; // Action is complete
        }
    }
}