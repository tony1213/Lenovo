package com.overtech.lenovo.app.activity.task.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.TaskInfoFragAdapter;
import com.overtech.lenovo.entity.tasklist.webservice.TaskProcess;

public class TaskInformationFragment extends BaseFragment {
	private ListView mTaskProcess;
	private TaskInfoFragAdapter adapter;
	private List<TaskProcess> datas;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_taskinformation;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mTaskProcess = (ListView) mRootView.findViewById(R.id.lv_task_process);
		datas = new ArrayList<TaskProcess>();
		datas.add(new TaskProcess("开单", "2016/01/22", "单号：20160122-0008", ""));
		datas.add(new TaskProcess("接单", "", "", "接单"));
		datas.add(new TaskProcess("预约", "2016/01/22 10:50", "", "改约"));
		datas.add(new TaskProcess("到场", "2016/01/22 11:30", "", "到场"));
		datas.add(new TaskProcess("完成", "2016/01/22 12:00", "", "解决方案"));
		datas.add(new TaskProcess("评价", "2016/01/22 14:00", "问题已经解决，态度认真负责", ""));
		adapter = new TaskInfoFragAdapter(getActivity(), datas);
		mTaskProcess.setAdapter(adapter);
	}

}
