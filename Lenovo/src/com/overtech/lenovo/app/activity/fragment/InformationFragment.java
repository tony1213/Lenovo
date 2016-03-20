package com.overtech.lenovo.app.activity.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.utils.Utilities;

public class InformationFragment extends BaseFragment {

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_information;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Utilities.showToast("信息", getActivity());
	}
}
