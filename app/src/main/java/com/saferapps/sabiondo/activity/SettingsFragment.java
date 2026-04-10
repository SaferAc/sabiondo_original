package com.saferapps.sabiondo.activity;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.saferapps.sabiondo.R;
import com.saferapps.sabiondo.helper.SessionHandler;
import com.saferapps.sabiondo.helper.SettingsPreferences;



public class SettingsFragment extends Fragment {

	SessionHandler session;
	private Context mContext;
	private SwitchCompat mSoundCheckBox,mVibrationCheckBox,mNightCheckbox;
	private boolean isSoundOn;
	private boolean isVibrationOn;
	private boolean inNightModeOn;

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_setting, container, false);
		mContext= getContext();
		session = new SessionHandler(mContext);
		mSoundCheckBox = view.findViewById(R.id.sound_checkbox);
		mVibrationCheckBox =  view.findViewById(R.id.vibration_checkbox);
		mNightCheckbox= view.findViewById(R.id.nightswitch);
		populateSoundContents();
		populateVibrationContents();

		ImageView image= view.findViewById(R.id.imageNight);

		if(SettingsPreferences.getNightMode(mContext)){
			image.setImageResource(R.drawable.night);
			inNightModeOn=true;
		}else{
			image.setImageResource(R.drawable.day);
			inNightModeOn=false;
		}

		mSoundCheckBox.setOnClickListener(v -> switchSoundCheckbox());

		mVibrationCheckBox.setOnClickListener(v -> switchVibrationCheckbox());


		mNightCheckbox.setOnClickListener(v -> {
			if(!inNightModeOn){
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
				SettingsPreferences.setNightMode(mContext,true);
			}else {
				AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
				SettingsPreferences.setNightMode(mContext,false);
			}
		});

		return view;
	}
	private void switchSoundCheckbox() {
		isSoundOn = !isSoundOn;
		SettingsPreferences.setSoundEnableDisable(mContext, isSoundOn);
		populateSoundContents();
	}

	private void switchVibrationCheckbox() {
		isVibrationOn = !isVibrationOn;
		SettingsPreferences.setVibration(mContext, isVibrationOn);
		populateVibrationContents();
	}


	protected void populateSoundContents() {
		if (SettingsPreferences.getSoundEnableDisable(mContext)) {
			mSoundCheckBox.setChecked(true);
		} else {
			mSoundCheckBox.setChecked(false);
		}
		isSoundOn = SettingsPreferences.getSoundEnableDisable(mContext);
	}
	protected void populateVibrationContents() {
		if (SettingsPreferences.getVibration(mContext)) {
			mVibrationCheckBox.setChecked(true);
		} else {
			mVibrationCheckBox.setChecked(false);
		}
		isVibrationOn = SettingsPreferences.getVibration(mContext);
	}


}
