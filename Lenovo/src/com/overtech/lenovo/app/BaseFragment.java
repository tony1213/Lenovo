package com.overtech.lenovo.app;

import com.overtech.lenovo.app.activity.callback.FragmentCallback;
import com.overtech.lenovo.app.activity.callback.FragmentInterface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;

public abstract class BaseFragment extends Fragment implements
		FragmentInterface, OnTouchListener {
	protected View mRootView;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		if (mRootView == null) {
			mRootView = inflater.inflate(getLayoutId(), container, false);
		}
		return mRootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		afterCreate(savedInstanceState);
	}
	protected abstract int getLayoutId();
	protected abstract void afterCreate(Bundle savedInstanceState);
	/**
	 * 模拟后退键
	 */
	protected void back() {
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.popBackStackImmediate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onViewCreated(android.view.View,
	 * android.os.Bundle)
	 */
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		view.setOnTouchListener(this);
		super.onViewCreated(view, savedInstanceState);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnTouchListener#onTouch(android.view.View,
	 * android.view.MotionEvent)
	 */
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// 拦截触摸事件，防止传递到下一层的View
		return true;
	}

	public void dispatchCommand(int id, Bundle args) {
		if (getActivity() instanceof FragmentCallback) {
			FragmentCallback callback = (FragmentCallback) getActivity();
			callback.onFragmentCallback(this, id, args);
		} else {
			throw new IllegalStateException(
					"The host activity does not implement FragmentCallback.");
		}
	}

	public void refreshViews() {

	}

	public boolean commitData() {
		return false;
	}
}
