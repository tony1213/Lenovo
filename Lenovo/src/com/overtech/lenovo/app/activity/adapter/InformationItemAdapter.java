package com.overtech.lenovo.app.activity.adapter;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.widget.bitmap.ImageLoader;

public class InformationItemAdapter extends BaseAdapter {
	private Context ctx;
	private String[] urls;

	public InformationItemAdapter(Context ctx, String[] urls) {
		this.ctx = ctx;
		this.urls = urls;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return urls.length > 3 ? 3 : urls.length;// 限制每个item的最大加载图片数量为3，暂定
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return urls[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = View.inflate(ctx,
					R.layout.item_gridview_informationitem, null);
		}
		ImageView imageView = (ImageView) convertView
				.findViewById(R.id.iv_picture_item);
		ImageLoader.getInstance().displayImage(urls[position], imageView,
				R.drawable.icon_stub, R.drawable.icon_error, Config.RGB_565);
		return convertView;
	}

	public void setUrls(String[] urls) {
		this.urls = urls;
	}

}
