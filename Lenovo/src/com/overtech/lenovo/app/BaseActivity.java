package com.overtech.lenovo.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.content.pm.ActivityInfo;
import com.overtech.lenovo.widget.dialog.NiftyDialogBuilder;

public class BaseActivity extends FragmentActivity {
	//Test git ignore

	public NiftyDialogBuilder dialogBuilder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		dialogBuilder = NiftyDialogBuilder.getInstance(this);
	}
}
