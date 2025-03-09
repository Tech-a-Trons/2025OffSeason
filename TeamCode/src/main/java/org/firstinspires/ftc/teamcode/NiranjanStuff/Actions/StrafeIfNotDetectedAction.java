//package org.firstinspires.ftc.teamcode.NiranjanStuff.Actions;
//
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
//import com.acmerobotics.roadrunner.Action;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//import org.firstinspires.ftc.teamcode.CameraClasses.BlueBlobDetectionPipeline;
//import org.opencv.core.MatOfPoint;
//import org.openftc.easyopencv.OpenCvCamera;
//import org.openftc.easyopencv.OpenCvCameraRotation;
//
//public class StrafeIfNotDetectedAction implements Action {
//    private DcMotor fl, fr, bl, br;
//    private OpenCvCamera controlHubCam;
//    private BlueBlobDetectionPipeline pipeline;
//    private boolean isStopped = false;
//
//    public StrafeIfNotDetectedAction(DcMotor fl, DcMotor fr, DcMotor bl, DcMotor br, OpenCvCamera controlHubCam) {
//        this.fl = fl;
//        this.fr = fr;
//        this.bl = bl;
//        this.br = br;
//        this.controlHubCam = controlHubCam;
//
//        // Initialize OpenCV Pipeline
//        pipeline = new BlueBlobDetectionPipeline();
//        controlHubCam.setPipeline(pipeline);
//        controlHubCam.openCameraDevice();
//        controlHubCam.startStreaming(1280, 720, OpenCvCameraRotation.UPRIGHT);
//    }
//
//    public void stop() {
//        isStopped = true;
//        fl.setPower(0);
//        fr.setPower(0);
//        bl.setPower(0);
//        br.setPower(0);
//    }
//
//    public void restart() {
//        isStopped = false;
//    }
//
//    @Override
//    public boolean run(TelemetryPacket packet) {
//        if (!isStopped) {
//            MatOfPoint largestContour = pipeline.getLargestContour();
//            if (largestContour == null) {
//                fl.setPower(0.25);
//                fr.setPower(-0.25);
//                bl.setPower(-0.25);
//                br.setPower(0.25);
//            } else {
//                stop();
//            }
//            packet.put("Contour Detected", largestContour != null);
//        }
//        return false;
//    }
//}