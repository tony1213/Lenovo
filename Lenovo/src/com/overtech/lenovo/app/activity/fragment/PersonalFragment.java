package com.overtech.lenovo.app.activity.fragment;

import android.os.Bundle;
import android.view.View;
import com.overtech.lenovo.R;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.config.Debug;
import com.overtech.lenovo.utils.Utilities;

public class PersonalFragment extends BaseFragment implements OnClickListener {

	@Override
	public void onClick(View v) {

	}

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_personal;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Utilities.showToast("个人中心", getActivity());
	}
}
