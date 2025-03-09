package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SampleArm {
    private Servo SampleArm;

    public SampleArm(HardwareMap hardwareMap) {
        SampleArm = hardwareMap.get(Servo.class, "saa");

        double SampleArmMin = 0;
        double SampleArmMax = 1;
        SampleArm.scaleRange(SampleArmMin, SampleArmMax);
    }

    public Action rest() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SampleArm.setPosition(0.43);
                return false;
            }
        };
    }
    public Action pickup() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SampleArm.setPosition(0.8);
                return false;
            }
        };
    }



}