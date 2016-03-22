package com.overtech.lenovo.app.activity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.personal.PersonalSettingActivity;
import com.overtech.lenovo.picasso.Transformation;
import com.overtech.lenovo.utils.ImageCacheUtils;
import com.overtech.lenovo.widget.bitmap.ImageLoader;

public class PersonalFragment extends BaseFragment implements OnClickListener {
	private ImageView mAvator;
	private LinearLayout setting;
	private String imageUrl = "http://img0w.pconline.com.cn/pconline/1309/03/3452566_13.jpg";

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_personal;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mAvator = (ImageView) mRootView.findViewById(R.id.iv_avator);
		setting=(LinearLayout)mRootView.findViewById(R.id.ll_personal_setting);
		
		ImageLoader.getInstance().displayImage(imageUrl, mAvator,
				R.drawable.icon_avator_default, R.drawable.ic_launcher,
				new Transformation() {

					@Override
					public Bitmap transform(Bitmap source) {
						// TODO Auto-generated method stub
						return ImageCacheUtils.toRoundBitmap(source);
					}

					@Override
					public String key() {
						// TODO Auto-generated method stub
						return null;
					}
				}, Config.RGB_565);
		
		setting.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ll_personal_setting:
			Intent intent = new Intent(getActivity(),PersonalSettingActivity.class);
			startActivity(intent);
			
			break;

		default:
			break;
		}
	}
}
