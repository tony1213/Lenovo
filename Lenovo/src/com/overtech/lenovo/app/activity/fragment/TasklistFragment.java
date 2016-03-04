package com.overtech.lenovo.app.activity.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.utils.Utilities;

public class TasklistFragment extends BaseFragment implements OnClickListener {
	private TextView mTaskAll;
	private TextView mTaskReceive;
	private TextView mTaskOrder;
	private TextView mTaskVisit;
	private TextView mTaskAccount;
	private TextView mTaskEvaluation;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_tasklist;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Utilities.showToast("工单", getActivity());
		mTaskAll = (TextView) mRootView.findViewById(R.id.tv_task_all);
		mTaskReceive = (TextView) mRootView.findViewById(R.id.tv_task_receive);
		mTaskOrder = (TextView) mRootView.findViewById(R.id.tv_task_order);
		mTaskVisit = (TextView) mRootView.findViewById(R.id.tv_task_visit);
		mTaskAccount = (TextView) mRootView.findViewById(R.id.tv_task_account);
		mTaskEvaluation = (TextView) mRootView
				.findViewById(R.id.tv_task_evaluation);

		mTaskAll.setOnClickListener(this);
		mTaskReceive.setOnClickListener(this);
		mTaskOrder.setOnClickListener(this);
		mTaskVisit.setOnClickListener(this);
		mTaskAccount.setOnClickListener(this);
		mTaskEvaluation.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mTaskAll.setSelected(false);
		mTaskReceive.setSelected(false);
		mTaskOrder.setSelected(false);
		mTaskVisit.setSelected(false);
		mTaskAccount.setSelected(false);
		mTaskEvaluation.setSelected(false);
		switch (v.getId()) {
		case R.id.tv_task_all:
			mTaskAll.setSelected(true);
			break;
		case R.id.tv_task_receive:
			mTaskReceive.setSelected(true);
			break;
		case R.id.tv_task_order:
			mTaskOrder.setSelected(true);
			break;
		case R.id.tv_task_visit:
			mTaskVisit.setSelected(true);
			break;
		case R.id.tv_task_account:
			mTaskAccount.setSelected(true);
			break;
		case R.id.tv_task_evaluation:
			mTaskEvaluation.setSelected(true);
			break;

		default:
			break;
		}
	}
}
