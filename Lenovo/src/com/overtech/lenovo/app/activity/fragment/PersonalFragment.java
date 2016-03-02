package com.overtech.lenovo.app.activity.fragment;

import android.os.Bundle;
import android.view.View;
import com.overtech.lenovo.R;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import com.overtech.lenovo.app.BaseFragment;

public class PersonalFragment extends BaseFragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_personal, container, false);
	}

	@Override
	public void onClick(View v) {

	}
}
