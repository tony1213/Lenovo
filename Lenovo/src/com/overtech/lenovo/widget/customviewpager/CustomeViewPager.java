package com.overtech.lenovo.widget.customviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class CustomeViewPager extends ViewPager {

	public CustomeViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public CustomeViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
		// TODO Auto-generated method stub
		if (v instanceof HorizontalScrollView) {
			return true;
		}
		return super.canScroll(v, checkV, dx, x, y);
	}
}
