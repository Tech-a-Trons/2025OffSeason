package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PivotArmAction{

    private static Servo armElbow;
    private double targetPosition;

    public PivotArmAction(HardwareMap hardwareMap) {
        armElbow = hardwareMap.get(Servo.class, "spe");

    }
    public static Action pickup() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(0.28);
                return false;
            }
        };
    }
    public static Action reset() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(0.4);

                return false;
            }
        };
    }
    public static Action start() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(1);//0.25

                return false;
            }
        };
    }
    public static Action hang() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(0.3);//0.6
                return false;
            }
        };
    }
    public static Action ramspechang() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(0.15);//0.09
                return false;
            }
        };
    }
    public static Action finishhang() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(0.59);//0.59
                return false;
            }
        };
    }
    public static Action hardhang() {
        return new Action() {
            public boolean run(@NonNull TelemetryPacket packet) {
                armElbow.setPosition(0.65);//0.65
                return false;
            }
        };
    }



}