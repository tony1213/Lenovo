package com.overtech.lenovo.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseActivity;
import com.overtech.lenovo.app.activity.callback.FragmentCallback;
import com.overtech.lenovo.app.activity.fragment.InformationFragment;
import com.overtech.lenovo.app.activity.fragment.KnowledgeFragment;
import com.overtech.lenovo.app.activity.fragment.PersonalFragment;
import com.overtech.lenovo.app.activity.fragment.TasklistFragment;
import com.overtech.lenovo.utils.FragmentUtils;
import com.overtech.lenovo.widget.TabView.TabView;
import com.overtech.lenovo.widget.TabView.TabView.OnTabChangeListener;
import com.overtech.lenovo.widget.dialog.Effectstype;

public class MainActivity extends BaseActivity implements
		OnTabChangeListener, FragmentCallback {

	private FragmentManager mFragmentManager;
	private Fragment mCurrentFragment;
	private TabView mTabView;

	/** 上一次的状态 */
	private int mPreviousTabIndex = 0;
	/** 当前状态 */
	private int mCurrentTabIndex =0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFragmentManager = getSupportFragmentManager();
		mCurrentTabIndex = 0;
		mPreviousTabIndex = -1;
		setupViews();
	}

	private void setupViews() {
		mTabView = (TabView) findViewById(R.id.view_tab);
		mTabView.setOnTabChangeListener(this);
		mTabView.setCurrentTab(mCurrentTabIndex);
		mCurrentFragment = new TasklistFragment();
		FragmentUtils.replaceFragment(mFragmentManager, R.id.layout_content,TasklistFragment.class, null, false);
	}

	@Override
	public void onFragmentCallback(Fragment fragment, int id, Bundle args) {
		mTabView.setCurrentTab(0);
	}

	@Override
	public void onTabChange(String tag) {

		if (tag != null) {
			if (tag.equals("tasklist")) {
				mPreviousTabIndex = mCurrentTabIndex;
				mCurrentTabIndex = 0;
				replaceFragment(TasklistFragment.class);
				// 检查，如果没有登录则跳转到登录界面
				/*
				 * final UserConfigManager manager =
				 * UserConfigManager.getInstance(); if (manager.getId() <= 0) {
				 * startActivityForResult(new Intent(this, LoginActivity.class),
				 * BaseActivity.REQUEST_OK_LOGIN); }
				 */
			} else if ("knowledge".equals(tag)) {
				mPreviousTabIndex = mCurrentTabIndex;
				mCurrentTabIndex = 1;
				replaceFragment(KnowledgeFragment.class);
			} else if (tag.equals("information")) {
				mPreviousTabIndex = mCurrentTabIndex;
				mCurrentTabIndex = 2;
				replaceFragment(InformationFragment.class);
				// 检查，如果没有登录则跳转到登录界面
				/*
				 * final UserConfigManager manager =
				 * UserConfigManager.getInstance(); if (manager.getId() <= 0) {
				 * startActivityForResult(new Intent(this, LoginActivity.class),
				 * BaseActivity.REQUEST_OK_LOGIN); }
				 */
			} else if (tag.equals("personal")) {
				mPreviousTabIndex = mCurrentTabIndex;
				mCurrentTabIndex = 3;
				replaceFragment(PersonalFragment.class);
				// 检查，如果没有登录则跳转到登录界面
				/*
				 * final UserConfigManager manager =
				 * UserConfigManager.getInstance(); if (manager.getId() <= 0) {
				 * startActivityForResult(new Intent(this, LoginActivity.class),
				 * BaseActivity.REQUEST_OK_LOGIN); }
				 */
			}
		}

	}

	private void replaceFragment(Class<? extends Fragment> newFragment) {

		mCurrentFragment = FragmentUtils.switchFragment(mFragmentManager, R.id.layout_content,mCurrentFragment, newFragment, null, false);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
			Effectstype effect = Effectstype.Shake;
			dialogBuilder.withTitle("温馨提示")
					.withTitleColor(R.color.main_primary)
					.withDividerColor("#11000000").withMessage("您是否要退出？")
					.withMessageColor(R.color.main_primary)
					.withDialogColor("#FFFFFFFF")
					.isCancelableOnTouchOutside(true).withDuration(700)
					.withEffect(effect).withButtonDrawable(R.color.main_white)
					.withButton1Text("否").withButton1Color("#DD47BEE9")
					.withButton2Text("是").withButton2Color("#DD47BEE9")
					.setButton1Click(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							dialogBuilder.dismiss();
						}
					}).setButton2Click(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							finish();
						}
					}).show();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	

}
