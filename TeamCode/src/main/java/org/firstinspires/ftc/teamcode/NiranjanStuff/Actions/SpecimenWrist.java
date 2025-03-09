package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SpecimenWrist {

    private static Servo SpecimenWrist;

    public SpecimenWrist(HardwareMap hardwareMap) {
        SpecimenWrist = hardwareMap.get(Servo.class,"spw");

    }
    public static Action flip() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SpecimenWrist.setPosition(0.1);
                return false;
            }
        };
    }
    public static Action reset() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                SpecimenWrist.setPosition(0.78);
                return false;
            }
        };
    }

}