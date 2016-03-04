package com.overtech.lenovo.widget.cycleviewpager;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.overtech.lenovo.R;
import com.overtech.lenovo.widget.bitmap.ImageLoader;

/**
 * ImageView 创建工厂
 * 
 * @author Overtech Will
 * 
 */
public class ViewFactory {
	public static ImageView getImageView(Context context, String url) {
		ImageView imageView = new ImageView(context);
		imageView.setScaleType(ScaleType.FIT_XY);

		ImageLoader.getInstance().displayImage(url, imageView,
				R.drawable.icon_stub, R.drawable.icon_error, Config.RGB_565);
		return imageView;
	}
}
