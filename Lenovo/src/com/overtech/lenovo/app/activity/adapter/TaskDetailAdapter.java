package com.overtech.lenovo.app.activity.adapter;

import java.util.List;

import com.overtech.lenovo.config.Debug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

public class TaskDetailAdapter extends FragmentPagerAdapter {
	private List<Fragment> listFragment;
	private List<String> listTitle;

	public TaskDetailAdapter(FragmentManager fm, List<Fragment> listFragment,
			List<String> listTitle) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.listFragment = listFragment;
		this.listTitle = listTitle;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return listFragment.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listFragment.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return listTitle.get(position % listTitle.size());
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		Debug.log("instantiateItem", position+"");
		return super.instantiateItem(container, position);
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		Debug.log("destroyItem", position+"");
		super.destroyItem(container, position, object);
	}
	
}
