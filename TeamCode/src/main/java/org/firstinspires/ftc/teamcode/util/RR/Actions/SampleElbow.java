package org.firstinspires.ftc.teamcode.Util.RR.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SampleElbow {
    private Servo SampleElbow;

    public SampleElbow(HardwareMap hardwareMap) {
        SampleElbow = hardwareMap.get(Servo.class, "sae");

        double SampleElbowMin = 0;
        double SampleElbowMax = 1;
        SampleElbow.scaleRange(SampleElbowMin,SampleElbowMax);
    }

    public Action reset() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SampleElbow.setPosition(0.0);
                return false;
            }
        };
    }
    public Action pickup() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SampleElbow.setPosition(0.05);
                return false;
            }
        };
    }


}