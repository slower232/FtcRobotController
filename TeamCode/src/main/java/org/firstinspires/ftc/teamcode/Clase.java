package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Clase extends OpMode {

    DcMotor armM;

    @Override
    public void init() {
        armM = hardwareMap.dcMotor.get("armM");

        armM.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armM.setTargetPosition(0);
        armM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void loop() {
        if (gamepad1.a){
            moverBrazo(-300);
        } else if (gamepad1.b) {
            moverBrazo(0);
        }

        telemetry.addData("armPos", armM.getCurrentPosition());
        telemetry.addData("arnTarget", armM.getTargetPosition());
        telemetry.addData("armIsBussy", armM.isBusy());
        telemetry.addData("armMode", armM.getMode());

    }

    void moverBrazo(int position){
        armM.setTargetPosition(position);
        armM.setPower(0.5);

    }
}
