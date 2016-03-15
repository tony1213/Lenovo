package com.overtech.lenovo.app.activity.task.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.TaskInfoFragAdapter;

public class TaskInformationFragment extends BaseFragment {
	private ListView mTaskProcess;
	private TaskInfoFragAdapter adapter;
	private List datas;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_taskinformation;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mTaskProcess=(ListView) mRootView.findViewById(R.id.lv_task_process);
		datas=new ArrayList();
		datas.add("1");
		datas.add("2");
		datas.add("3");
		datas.add("4");
		datas.add("5");
		datas.add("6");
		adapter=new TaskInfoFragAdapter(getActivity(), datas);
		mTaskProcess.setAdapter(adapter);
	}

}
