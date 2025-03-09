package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class MainArmAction {

    private static Servo armRight;
    private static Servo armLeft;
    public MainArmAction(HardwareMap hardwareMap) {
        armRight = hardwareMap.get(Servo.class, "spar");
        armLeft = hardwareMap.get(Servo.class, "spal");

    }
    public static Action pickup() {
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                armLeft.setPosition(0.95); //0.9
                armRight.setPosition(0.95);
                return false;
            }
        };
    }
    public static Action hang() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armRight.setPosition(0.53);//0.45
                armLeft.setPosition(0.53); //0.45
                return false;
            }
        };
    }
    public static Action ramspechang() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armRight.setPosition(0.05);//0.05
                armLeft.setPosition(0.05); //0.05
                return false;
            }
        };
    }
    public static Action start() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armRight.setPosition(0.9);
                armLeft.setPosition(0.9);
                return false;
            }
        };
    }
    public static Action reset() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armRight.setPosition(1);
                armLeft.setPosition(1);
                return false;
            }
        };
    }

}