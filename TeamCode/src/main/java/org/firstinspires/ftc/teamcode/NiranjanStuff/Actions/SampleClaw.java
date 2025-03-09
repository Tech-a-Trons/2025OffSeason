package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SampleClaw {
    private static Servo SampleClaw;

    public SampleClaw(HardwareMap hardwareMap) {
        SampleClaw = hardwareMap.get(Servo.class, "sac");

        double clawMin = 0.0;
        double clawMax = .6;
        SampleClaw.scaleRange(clawMin, clawMax);
    }

    public Action snap() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SampleClaw.setPosition(0);
                return false;
            }
        };
    }

    public static Action open() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SampleClaw.setPosition(.6);
                return false;
            }
        };
    }
}