package com.overtech.lenovo.app.activity.task;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseActivity;
import com.overtech.lenovo.app.activity.adapter.TaskDetailAdapter;
import com.overtech.lenovo.app.activity.task.fragment.DetailInformationFragment;
import com.overtech.lenovo.app.activity.task.fragment.PropertyFragment;
import com.overtech.lenovo.app.activity.task.fragment.StoreInformationFragment;
import com.overtech.lenovo.app.activity.task.fragment.TaskInformationFragment;
import com.overtech.lenovo.config.Debug;
import com.overtech.lenovo.widget.customviewpager.CustomeViewPager;

public class TaskDetailActivity extends BaseActivity {
	private TabLayout mTabLayout;
	// private ViewPager mViewPager;
	private CustomeViewPager mViewPager;
	private TextView mTitle;
	private TaskDetailAdapter adapter;
	private List<Fragment> listFragment;
	private List<String> listTitle;
	private TaskInformationFragment taskInfoFrag;// 本单信息
	private DetailInformationFragment detailInfoFrag;// 详细信息
	private StoreInformationFragment storeInfoFrag;// 门店信息
	private PropertyFragment propertyFrag;// 资产
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0x1:
				Debug.log("taskdetailActivity==handler", "收到handler发送过来的消息了");
				break;

			default:
				break;
			}
		};
	};
	@Override
	protected int getLayoutIds() {
		// TODO Auto-generated method stub
		return R.layout.activity_taskdetail;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
		mViewPager = (CustomeViewPager) findViewById(R.id.viewPager);
		mTitle = (TextView) findViewById(R.id.tv_task_detail_title);

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
		mViewPager.setOffscreenPageLimit(3);
		mViewPager.setAdapter(adapter);
		mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout){
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				super.onPageScrollStateChanged(state);
				Log.e("onPageScrollStateChanged", state+"");
				
			}
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				super.onPageSelected(arg0);
				Log.e("onPageSelected==", arg0+"");
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				super.onPageScrolled(arg0, arg1, arg2);
				
			}
		});
		mTabLayout.setupWithViewPager(mViewPager);
		
//		mTabLayout.setOnTabSelectedListener(new OnTabSelectedListener() {
//			
//			@Override
//			public void onTabUnselected(Tab arg0) {
//				// TODO Auto-generated method stub
//				Log.e("onTabUnselected", arg0.getPosition()+"");
//			}
//			
//			@Override
//			public void onTabSelected(Tab arg0) {
//				// TODO Auto-generated method stub
//				Log.e("onTabSelected", arg0.getPosition()+"");
//			}
//			
//			@Override
//			public void onTabReselected(Tab arg0) {
//				// TODO Auto-generated method stub
//				Log.e("onTabReselected", arg0.getPosition()+"");
//			}
//		});
		mTitle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
