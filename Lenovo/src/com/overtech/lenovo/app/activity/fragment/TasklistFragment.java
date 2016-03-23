package com.overtech.lenovo.app.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.TaskListAdapter;
import com.overtech.lenovo.app.activity.adapter.TaskListAdapter.OnItemClickListener;
import com.overtech.lenovo.app.activity.task.TaskDetailActivity;
import com.overtech.lenovo.app.activity.task.TaskInformationActivity;
import com.overtech.lenovo.entity.tasklist.webservice.ADInfo;
import com.overtech.lenovo.entity.tasklist.webservice.Task;
import com.overtech.lenovo.utils.Utilities;
import com.overtech.lenovo.widget.bitmap.ImageLoader;
import com.overtech.lenovo.widget.cycleviewpager.CycleViewPager;
import com.overtech.lenovo.widget.cycleviewpager.CycleViewPager.ImageCycleViewListener;
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
			"http://www.pp3.cn/uploads/allimg/111125/1612125591-0.jpg",
			"http://www.pp3.cn/uploads/allimg/111215/1033042330-0.jpg",
			"http://m2.quanjing.com/2m/aflrf001/jjig000030.jpg",
			"http://pic1.bbzhi.com/jieribizhi/baiseshengdanzhutisheying/holiday_2008_white_christmas_26646_8.jpg", };

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
		mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
				DividerItemDecoration.VERTICAL_LIST));// 实现分割线
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

		for (int i = 0; i < infos.size(); i++) {
			views.add(ViewFactory.getImageView(getActivity(), infos.get(i)
					.getUrl()));
		}

		cycleViewPager.setData(views, infos, new ImageCycleViewListener() {

			@Override
			public void onImageClick(ADInfo info, int position, View imageView) {
				// TODO Auto-generated method stub
				ImageLoader.getInstance().displayImage(info.getUrl(),
						(ImageView) imageView, R.drawable.icon_stub,
						R.drawable.icon_error, Config.RGB_565);
				Utilities.showToast("您点击了图片" + position, getActivity());
			}
		});
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
		Intent intent = new Intent(getActivity(), TaskDetailActivity.class);
		Bundle bundle = new Bundle();
		startActivity(intent, bundle);
	}

	@Override
	public void onLogItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Utilities.showToast("您点击了条目" + position + "的log", getActivity());
		Intent intent = new Intent(getActivity(), TaskInformationActivity.class);
		Bundle bundle = new Bundle();
		startActivity(intent, bundle);
	}

	@Override
	public void onButtonItemClick(View view, int position) {
		// TODO Auto-generated method stub
		Utilities.showToast("您接了条目" + position + "的工单", getActivity());
	}
}
