package com.overtech.lenovo.app.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.TaskInformationActivity;
import com.overtech.lenovo.app.activity.adapter.TaskListAdapter;
import com.overtech.lenovo.app.activity.adapter.TaskListAdapter.OnItemClickListener;
import com.overtech.lenovo.entity.tasklist.webservice.ADInfo;
import com.overtech.lenovo.entity.tasklist.webservice.Task;
import com.overtech.lenovo.utils.Utilities;
import com.overtech.lenovo.widget.bitmap.ImageLoader;
import com.overtech.lenovo.widget.cycleviewpager.CycleViewPager;
import com.overtech.lenovo.widget.cycleviewpager.ViewFactory;
import com.overtech.lenovo.widget.itemdecoration.DividerItemDecoration;

public class TasklistFragment extends BaseFragment implements OnClickListener,
		OnItemClickListener {
	private TextView mTaskAll;
	private TextView mTaskReceive;
	private TextView mTaskOrder;
	private TextView mTaskVisit;
	private TextView mTaskAccount;
	private TextView mTaskEvaluation;
	private RecyclerView mRecyclerView;
	private TaskListAdapter adapter;
	private List<Task> datas;
	private CycleViewPager cycleViewPager;
	private List<ImageView> views = new ArrayList<ImageView>();
	private List<ADInfo> infos = new ArrayList<ADInfo>();
	private String[] imageUrls = {
			"http://pic90.nipic.com/file/20160225/5189591_225045255000_2.jpg",
			"http://pic1.huitu.com/res/20110407/1086_20110407213952112000_1.jpg",
			"http://pic75.nipic.com/file/20150818/17961491_085903764000_2.jpg",
			"http://pic65.nipic.com/file/20150420/18897329_213037602000_2.jpg", };

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
		mRecyclerView = (RecyclerView) mRootView
				.findViewById(R.id.recyclerView);
		initialCycleViewPager();
		initRecyclerView();
		mTaskAll.setOnClickListener(this);
		mTaskReceive.setOnClickListener(this);
		mTaskOrder.setOnClickListener(this);
		mTaskVisit.setOnClickListener(this);
		mTaskAccount.setOnClickListener(this);
		mTaskEvaluation.setOnClickListener(this);
	}

	private void initRecyclerView() {
		// TODO Auto-generated method stub
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		mRecyclerView.addItemDecoration(new DividerItemDecoration(
				getContext(), DividerItemDecoration.VERTICAL_LIST));// 实现分割线
		datas = new ArrayList<Task>();
		Task task1 = new Task("", "20160309-0001", "2016-03-11  11:30", "网络问题",
				"WIFI无法正常使用", "携带装备", "langitude", "longitude", "2小时上门", "1",
				"接单");
		Task task2 = new Task("", "20160309-0002", "2016-03-12  12:30",
				"POS软件问题", "pos无法正常使用", "携带装备", "langitude", "longitude",
				"6小时上门", "0", "评价");
		Task task3 = new Task("", "20160309-0003", "2016-03-13  13:30", "网络问题",
				"哈哈无法正常使用", "携带装备", "langitude", "longitude", "2小时上门", "0",
				"接单");
		Task task4 = new Task("", "20160309-0004", "2016-03-14  14:30", "网络问题",
				"pos无法正常使用", "携带装备", "langitude", "longitude", "3小时上门", "1",
				"评价");
		Task task5 = new Task("", "20160309-0005", "2016-03-15  15:30", "网络问题",
				"设备无法正常使用", "携带装备", "langitude", "longitude", "4小时上门", "0",
				"接单");

		datas.add(task1);
		datas.add(task2);
		datas.add(task3);
		datas.add(task4);
		datas.add(task5);
		adapter = new TaskListAdapter(getActivity(), datas);
		adapter.setOnItemClickListener(this);
		mRecyclerView.setAdapter(adapter);

	}

	private void initialCycleViewPager() {
		// TODO Auto-generated method stub
		ImageLoader.getInstance().initContext(getActivity());// 初始化ImageView;
		cycleViewPager = (CycleViewPager) getChildFragmentManager()// 绝对不能用getActivity().getSupportFragmentManager()
				.findFragmentById(R.id.fragment_cycle_viewpager_content);
		for (int i = 0; i < imageUrls.length; i++) {
			ADInfo info = new ADInfo();
			info.setUrl(imageUrls[i]);
			info.setContent("图片-->" + i);
			infos.add(info);
		}

		// 将最后一个ImageView添加进来
		views.add(ViewFactory.getImageView(getActivity(),
				infos.get(infos.size() - 1).getUrl()));
		for (int i = 0; i < infos.size(); i++) {
			views.add(ViewFactory.getImageView(getActivity(), infos.get(i)
					.getUrl()));
		}
		// 将第一个ImageView添加进来
		views.add(ViewFactory
				.getImageView(getActivity(), infos.get(0).getUrl()));

		// 设置循环，在调用setData方法前调用
		cycleViewPager.setCycle(true);

		// 在加载数据前设置是否循环
		cycleViewPager.setData(views, infos, null);
		// 设置轮播
		cycleViewPager.setWheel(true);

		// 设置轮播时间，默认5000ms
		cycleViewPager.setTime(2000);
		// 设置圆点指示图标组居中显示，默认靠右
		cycleViewPager.setIndicatorCenter();
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

	@Override
	public void onItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Utilities.showToast("您点击了条目" + position, getActivity());
	}

	@Override
	public void onLogItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Utilities.showToast("您点击了条目" + position + "的log", getActivity());
		Intent intent=new Intent(getActivity(),TaskInformationActivity.class);
		Bundle bundle =new Bundle();
		startActivity(intent, bundle);
	}

	@Override
	public void onButtonItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Utilities.showToast("您接了条目" + position + "的工单", getActivity());
	}
}
