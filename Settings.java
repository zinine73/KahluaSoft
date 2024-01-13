package com.zinine.game.pipetycoonfree;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class Settings extends BaseFrame {
	private ToggleButton tbFollowSystem;
	private RadioButton rbSoundOff;
	private RadioButton rbSound25;
	private RadioButton rbSound50;
	private RadioButton rbSound75;
	private RadioButton rbSound100;
	private RadioButton rbVibrationOff;
	private RadioButton rbVibrationOn;
	private RadioButton rbFlowSpeedX2;
	private RadioButton rbFlowSpeedX3;
	private RadioButton rbFlowSpeedX4;
	private RadioButton rbFlowSpeedX5;
	private RadioButton rbDrawPipeOff;
	private RadioButton rbDrawPipeOn;
	private RadioButton rbMustPassWall0;
	private RadioButton rbMustPassWall1;
	private RadioButton rbMustPassWall2;
	private RadioButton rbMustPassWallRandom;
	private RadioButton rbMustPassPipe0;
	private RadioButton rbMustPassPipe1;
	private RadioButton rbMustPassPipe2;
	private RadioButton rbMustPassPipeRandom;
	private RadioButton rbMustPassOneway0;
	private RadioButton rbMustPassOneway1;
	private RadioButton rbMustPassOnewayRandom;
	private RadioButton rbMustPassInOut0;
	private RadioButton rbMustPassInOut1;
	private RadioButton rbMustPassInOutRandom;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        tbFollowSystem = (ToggleButton)findViewById(R.id.tbFollowSystem);
        rbSoundOff = (RadioButton)findViewById(R.id.radioSoundOff);
        rbSound25 = (RadioButton)findViewById(R.id.radioSound25);
        rbSound50 = (RadioButton)findViewById(R.id.radioSound50);
        rbSound75 = (RadioButton)findViewById(R.id.radioSound75);
        rbSound100 = (RadioButton)findViewById(R.id.radioSound100);
        rbVibrationOff = (RadioButton)findViewById(R.id.radioVibrationOff);
        rbVibrationOn = (RadioButton)findViewById(R.id.radioVibrationOn);
        rbFlowSpeedX2 = (RadioButton)findViewById(R.id.radioFlowSpeedX2);
        rbFlowSpeedX3 = (RadioButton)findViewById(R.id.radioFlowSpeedX3);
        rbFlowSpeedX4 = (RadioButton)findViewById(R.id.radioFlowSpeedX4);
        rbFlowSpeedX5 = (RadioButton)findViewById(R.id.radioFlowSpeedX5);
        rbDrawPipeOff = (RadioButton)findViewById(R.id.radioDrawPipeOff);
        rbDrawPipeOn = (RadioButton)findViewById(R.id.radioDrawPipeOn);
        rbMustPassWall0 = (RadioButton)findViewById(R.id.radioMustPassWall0);
        rbMustPassWall1 = (RadioButton)findViewById(R.id.radioMustPassWall1);
        rbMustPassWall2 = (RadioButton)findViewById(R.id.radioMustPassWall2);
        rbMustPassWallRandom = (RadioButton)findViewById(R.id.radioMustPassWallRandom);
        rbMustPassPipe0 = (RadioButton)findViewById(R.id.radioMustPassPipe0);
        rbMustPassPipe1 = (RadioButton)findViewById(R.id.radioMustPassPipe1);
        rbMustPassPipe2 = (RadioButton)findViewById(R.id.radioMustPassPipe2);
        rbMustPassPipeRandom = (RadioButton)findViewById(R.id.radioMustPassPipeRandom);
        rbMustPassOneway0 = (RadioButton)findViewById(R.id.radioMustPassOneway0);
        rbMustPassOneway1 = (RadioButton)findViewById(R.id.radioMustPassOneway1);
        rbMustPassOnewayRandom = (RadioButton)findViewById(R.id.radioMustPassOnewayRandom);
        rbMustPassInOut0 = (RadioButton)findViewById(R.id.radioMustPassInOut0);
        rbMustPassInOut1 = (RadioButton)findViewById(R.id.radioMustPassInOut1);
        rbMustPassInOutRandom = (RadioButton)findViewById(R.id.radioMustPassInOutRandom);
        
        tbFollowSystem.setOnClickListener(this);
        rbSoundOff.setOnClickListener(this);
        rbSound25.setOnClickListener(this);
        rbSound50.setOnClickListener(this);
        rbSound75.setOnClickListener(this);
        rbSound100.setOnClickListener(this);
        rbVibrationOff.setOnClickListener(this);
        rbVibrationOn.setOnClickListener(this);
        rbFlowSpeedX2.setOnClickListener(this);
        rbFlowSpeedX3.setOnClickListener(this);
        rbFlowSpeedX4.setOnClickListener(this);
        rbFlowSpeedX5.setOnClickListener(this);
        rbDrawPipeOff.setOnClickListener(this);
        rbDrawPipeOn.setOnClickListener(this);
        if (app.versionFree) {
        	rbMustPassWall0.setEnabled(false);
        	rbMustPassWall1.setEnabled(false);
        	rbMustPassWall2.setEnabled(false);
        	rbMustPassWallRandom.setEnabled(false);
        	rbMustPassPipe0.setEnabled(false);
        	rbMustPassPipe1.setEnabled(false);
        	rbMustPassPipe2.setEnabled(false);
        	rbMustPassPipeRandom.setEnabled(false);
        	rbMustPassOneway0.setEnabled(false);
        	rbMustPassOneway1.setEnabled(false);
        	rbMustPassOnewayRandom.setEnabled(false);
        	rbMustPassInOut0.setEnabled(false);
        	rbMustPassInOut1.setEnabled(false);
        	rbMustPassInOutRandom.setEnabled(false);
        } else {
        	rbMustPassWall0.setOnClickListener(this);
        	rbMustPassWall1.setOnClickListener(this);
        	rbMustPassWall2.setOnClickListener(this);
        	rbMustPassWallRandom.setOnClickListener(this);
        	rbMustPassPipe0.setOnClickListener(this);
        	rbMustPassPipe1.setOnClickListener(this);
        	rbMustPassPipe2.setOnClickListener(this);
        	rbMustPassPipeRandom.setOnClickListener(this);
        	rbMustPassOneway0.setOnClickListener(this);
        	rbMustPassOneway1.setOnClickListener(this);
        	rbMustPassOnewayRandom.setOnClickListener(this);
        	rbMustPassInOut0.setOnClickListener(this);
        	rbMustPassInOut1.setOnClickListener(this);
        	rbMustPassInOutRandom.setOnClickListener(this);
        }

        tbFollowSystem.setChecked(app.followSystem);
        if (app.soundVolume == 0f) {
        	rbSoundOff.toggle();
        } else if (app.soundVolume == 0.25f) {
        	rbSound25.toggle();
        } else if (app.soundVolume == 0.50f) {
        	rbSound50.toggle();
        } else if (app.soundVolume == 0.75f) {
        	rbSound75.toggle();
        } else {
        	rbSound100.toggle();
        }
        if (app.optionVibration) {
        	rbVibrationOn.toggle();
        } else {
        	rbVibrationOff.toggle();
        }
        switch (app.flowSpeed) {
        case 2:
        	rbFlowSpeedX2.toggle();
        	break;
        case 3:
        	rbFlowSpeedX3.toggle();
        	break;
        case 4:
        	rbFlowSpeedX4.toggle();
        	break;
        case 5:
        	rbFlowSpeedX5.toggle();
        	break;
        }
        if (app.enableDrawPipe) {
        	rbDrawPipeOn.toggle();
        } else {
        	rbDrawPipeOff.toggle();
        }
        switch (app.mustPassWall) {
        case 0:
        	rbMustPassWall0.toggle();
        	break;
        case 1:
        	rbMustPassWall1.toggle();
        	break;
        case 2:
        	rbMustPassWall2.toggle();
        	break;
        case 3:
        	rbMustPassWallRandom.toggle();
        	break;
        }
        switch (app.mustPassPipe) {
        case 0:
        	rbMustPassPipe0.toggle();
        	break;
        case 1:
        	rbMustPassPipe1.toggle();
        	break;
        case 2:
        	rbMustPassPipe2.toggle();
        	break;
        case 3:
        	rbMustPassPipeRandom.toggle();
        	break;
        }
        switch (app.mustPassOneway) {
        case 0:
        	rbMustPassOneway0.toggle();
        	break;
        case 1:
        	rbMustPassOneway1.toggle();
        	break;
        case 2:
        	rbMustPassOnewayRandom.toggle();
        	break;
        }
        switch (app.mustPassInOut) {
        case 0:
        	rbMustPassInOut0.toggle();
        	break;
        case 1:
        	rbMustPassInOut1.toggle();
        	break;
        case 2:
        	rbMustPassInOutRandom.toggle();
        	break;
        }
    }
    
	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch(v.getId()) {
		case R.id.tbFollowSystem:
			app.followSystem = !app.followSystem;
			break;
		case R.id.radioSoundOff:
		case R.id.radioSound25:
		case R.id.radioSound50:
		case R.id.radioSound75:
		case R.id.radioSound100:
			app.soundVolume = (v.getId() - R.id.radioSoundOff) * app.DEFAULT_SOUND_STEP;
			break;
		case R.id.radioVibrationOff:
		case R.id.radioVibrationOn:
			app.optionVibration = !app.optionVibration;
			break;
		case R.id.radioFlowSpeedX2:
		case R.id.radioFlowSpeedX3:
		case R.id.radioFlowSpeedX4:
		case R.id.radioFlowSpeedX5:
			app.flowSpeed = v.getId() - R.id.radioFlowSpeedX2 + 2;
			break;
		case R.id.radioDrawPipeOff:
		case R.id.radioDrawPipeOn:
			app.enableDrawPipe = !app.enableDrawPipe;
			break;
		case R.id.radioMustPassWall0:
		case R.id.radioMustPassWall1:
		case R.id.radioMustPassWall2:
		case R.id.radioMustPassWallRandom:
			app.mustPassWall = v.getId() - R.id.radioMustPassWall0;
			break;
		case R.id.radioMustPassPipe0:
		case R.id.radioMustPassPipe1:
		case R.id.radioMustPassPipe2:
		case R.id.radioMustPassPipeRandom:
			app.mustPassPipe = v.getId() - R.id.radioMustPassPipe0;
			break;
		case R.id.radioMustPassOneway0:
		case R.id.radioMustPassOneway1:
		case R.id.radioMustPassOnewayRandom:
			app.mustPassOneway = v.getId() - R.id.radioMustPassOneway0;
			break;
		case R.id.radioMustPassInOut0:
		case R.id.radioMustPassInOut1:
		case R.id.radioMustPassInOutRandom:
			app.mustPassInOut = v.getId() - R.id.radioMustPassInOut0;
			break;
		}
	}
}