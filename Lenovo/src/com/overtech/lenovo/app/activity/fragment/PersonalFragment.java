package com.overtech.lenovo.app.activity.fragment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.picasso.Picasso;
import com.overtech.lenovo.picasso.Transformation;
import com.overtech.lenovo.utils.ImageCacheUtils;
import com.overtech.lenovo.widget.bitmap.ImageLoader;

public class PersonalFragment extends BaseFragment {
	private ImageView mAvator;
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
	}
}
