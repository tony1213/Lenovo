package com.overtech.lenovo.app.activity.task;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseActivity;
import com.overtech.lenovo.app.activity.adapter.TaskDetailAdapter;
import com.overtech.lenovo.app.activity.task.fragment.DetailInformationFragment;
import com.overtech.lenovo.app.activity.task.fragment.PropertyFragment;
import com.overtech.lenovo.app.activity.task.fragment.StoreInformationFragment;
import com.overtech.lenovo.app.activity.task.fragment.TaskInformationFragment;

public class TaskDetailActivity extends BaseActivity {
	private TabLayout mTabLayout;
	private ViewPager mViewPager;
	private TaskDetailAdapter adapter;
	private List<Fragment> listFragment;
	private List<String> listTitle;
	private TaskInformationFragment taskInfoFrag;// 本单信息
	private DetailInformationFragment detailInfoFrag;// 详细信息
	private StoreInformationFragment storeInfoFrag;// 门店信息
	private PropertyFragment propertyFrag;// 资产

	@Override
	protected int getLayoutIds() {
		// TODO Auto-generated method stub
		return R.layout.activity_taskdetail;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);

		taskInfoFrag = new TaskInformationFragment();
		detailInfoFrag = new DetailInformationFragment();
		storeInfoFrag = new StoreInformationFragment();
		propertyFrag = new PropertyFragment();

		listFragment = new ArrayList<Fragment>();
		listFragment.add(taskInfoFrag);
		listFragment.add(detailInfoFrag);
		listFragment.add(storeInfoFrag);
		listFragment.add(propertyFrag);

		listTitle = new ArrayList<String>();
		listTitle.add("本单信息");
		listTitle.add("详细信息");
		listTitle.add("门店信息");
		listTitle.add("资产");

		mTabLayout.setTabMode(TabLayout.MODE_FIXED);// 设置TabLayout的模式
		mTabLayout.addTab(mTabLayout.newTab().setText(listTitle.get(0)));
		mTabLayout.addTab(mTabLayout.newTab().setText(listTitle.get(1)));
		mTabLayout.addTab(mTabLayout.newTab().setText(listTitle.get(2)));
		mTabLayout.addTab(mTabLayout.newTab().setText(listTitle.get(3)));

		adapter = new TaskDetailAdapter(getSupportFragmentManager(),
				listFragment, listTitle);

		mViewPager.setAdapter(adapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}

}
