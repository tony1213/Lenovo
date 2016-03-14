package com.overtech.lenovo.app.activity.task;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseActivity;

public class TaskInformationActivity extends BaseActivity {
	private TextView mTitle;
	@Override
	protected int getLayoutIds() {
		// TODO Auto-generated method stub
		return R.layout.activity_task_information;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mTitle=(TextView) findViewById(R.id.tv_task_information_title);
		
		mTitle.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
