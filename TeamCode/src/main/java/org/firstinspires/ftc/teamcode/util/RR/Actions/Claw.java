package org.firstinspires.ftc.teamcode.Util.RR.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo claw;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "spc");

        double clawMin = 0;
        double clawMax = 1;
        claw.scaleRange(clawMin, clawMax);
    }

    public Action snap() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                claw.setPosition(0);
                return false;
            }
        };
    }

    public Action open() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                claw.setPosition(0.25);
                return false;
            }
        };
    }
}