package com.overtech.lenovo.app.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.overtech.lenovo.R;

public class HardWareAdapter extends BaseAdapter {
	private Context ctx;
	private int[] ids = new int[] { R.drawable.icon_knowledge_1,
			R.drawable.icon_knowledge_2, R.drawable.icon_knowledge_3,
			R.drawable.icon_knowledge_4 };
	private String[] items = new String[] { "【RMS】RMS安装手册", "【考勤系统】考勤系统配置手册",
			"【金奖系统】金奖系统使用说明", "【CRM】客户关系管理（CRM） " };

	public HardWareAdapter(Context ctx) {
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ids.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
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
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.item_listview_hardware, null);
		}
		TextView tv = (TextView) convertView
				.findViewById(R.id.tv_hardware_item);
		ImageView iv=(ImageView) convertView.findViewById(R.id.iv_hardware_item);
		tv.setText(items[position]);
		iv.setBackgroundResource(ids[position]);
		return convertView;
	}

}
