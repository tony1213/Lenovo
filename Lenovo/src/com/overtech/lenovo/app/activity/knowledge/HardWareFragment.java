package com.overtech.lenovo.app.activity.knowledge;

import android.os.Bundle;
import android.widget.ListView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.HardWareAdapter;

public class HardWareFragment extends BaseFragment {
	private ListView listView;
	private HardWareAdapter adapter;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_hardware;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		listView=(ListView) mRootView.findViewById(R.id.lv_hardware);
		adapter=new HardWareAdapter(getActivity());
		listView.setAdapter(adapter);
	}

}
