package com.overtech.lenovo.app.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.MainActivity;
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
			"http://tupian.enterdesk.com/2012/1103/gha/1/enterdesk%20%2812%29.jpg",
			"http://img1.3lian.com/img013/v4/81/d/71.jpg",
			"http://img1.3lian.com/img013/v4/81/d/66.jpg",
			"http://pic20.nipic.com/20120409/9188247_091601398179_2.jpg", };

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_tasklist;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Utilities.showToast("工单", getActivity());

		// mTaskAll = (TextView) mRootView.findViewById(R.id.tv_task_all);
		// mTaskReceive = (TextView)
		// mRootView.findViewById(R.id.tv_task_receive);
		// mTaskOrder = (TextView) mRootView.findViewById(R.id.tv_task_order);
		// mTaskVisit = (TextView) mRootView.findViewById(R.id.tv_task_visit);
		// mTaskAccount = (TextView)
		// mRootView.findViewById(R.id.tv_task_account);
		// mTaskEvaluation = (TextView) mRootView
		// .findViewById(R.id.tv_task_evaluation);
		mRecyclerView = (RecyclerView) mRootView
				.findViewById(R.id.recyclerView);

		initRecyclerView();
		initialCycleViewPager();

		// mTaskAll.setOnClickListener(this);
		// mTaskReceive.setOnClickListener(this);
		// mTaskOrder.setOnClickListener(this);
		// mTaskVisit.setOnClickListener(this);
		// mTaskAccount.setOnClickListener(this);
		// mTaskEvaluation.setOnClickListener(this);

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.menu_tasklist, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		ActionBar actionBar = ((MainActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle("工单");
		Toolbar toolbar = (Toolbar) getActivity().findViewById(
				R.id.toolbar_main);
		toolbar.setNavigationIcon(R.drawable.icon_tab_tasklist_selected);
		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_all:
			Utilities.showToast("所有", getActivity());
			break;
		case R.id.menu2:
			Utilities.showToast("菜单2", getActivity());
		case R.id.menu3:
			Utilities.showToast("菜单3", getActivity());
		case R.id.menu7:
			showAnimate(item);
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void showAnimate(MenuItem menuItem) {
		ImageView image = new ImageView(getContext());
		image.setScaleType(ScaleType.CENTER_CROP);
		image.setImageResource(R.drawable.anim_task_notification);
		menuItem.setActionView(image);
		AnimationDrawable animation = (AnimationDrawable) image.getDrawable();
		animation.start();
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
		Task task6 = new Task("", "20160309-0006", "2016-03-16  16:30", "网络问题",
				"设备无法正常使用", "携带装备", "langitude", "longitude", "3小时上门", "0",
				"评价");
		Task task7 = new Task("", "20160309-0007", "2016-03-17  17:30", "网络问题",
				"设备无法正常使用", "携带装备", "langitude", "longitude", "1小时上门", "0",
				"接单");
		Task task8 = new Task("", "20160309-0008", "2016-03-18  18:30", "网络问题",
				"设备无法正常使用", "携带装备", "langitude", "longitude", "3小时上门", "0",
				"评价");

		datas.add(task1);
		datas.add(task2);
		datas.add(task3);
		datas.add(task4);
		datas.add(task5);
		datas.add(task6);
		datas.add(task7);
		datas.add(task8);

		adapter = new TaskListAdapter(getActivity());
		adapter.setDatas(datas);
		adapter.setHeader(LayoutInflater.from(getContext()).inflate(
				R.layout.item_recyclerview_header, null));
		adapter.setOnItemClickListener(this);
		mRecyclerView.setAdapter(adapter);

	}

	private void initialCycleViewPager() {
		// TODO Auto-generated method stub
		ImageLoader.getInstance().initContext(getActivity());// 初始化ImageView;
		// cycleViewPager = (CycleViewPager) getChildFragmentManager()//
		// 绝对不能用getActivity().getSupportFragmentManager()
		// .findFragmentById(R.id.fragment_cycle_viewpager_content);//因为fragment标签不再在fragment中，所以此处不再需要

		cycleViewPager = (CycleViewPager) getFragmentManager()
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
		// mTaskAll.setSelected(false);
		// mTaskReceive.setSelected(false);
		// mTaskOrder.setSelected(false);
		// mTaskVisit.setSelected(false);
		// mTaskAccount.setSelected(false);
		// mTaskEvaluation.setSelected(false);
		// switch (v.getId()) {
		// case R.id.tv_task_all:
		// mTaskAll.setSelected(true);
		// break;
		// case R.id.tv_task_receive:
		// mTaskReceive.setSelected(true);
		// break;
		// case R.id.tv_task_order:
		// mTaskOrder.setSelected(true);
		// break;
		// case R.id.tv_task_visit:
		// mTaskVisit.setSelected(true);
		// break;
		// case R.id.tv_task_account:
		// mTaskAccount.setSelected(true);
		// break;
		// case R.id.tv_task_evaluation:
		// mTaskEvaluation.setSelected(true);
		// break;
		//
		// default:
		// break;
		// }
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
