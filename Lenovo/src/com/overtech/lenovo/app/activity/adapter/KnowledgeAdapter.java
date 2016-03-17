package com.overtech.lenovo.app.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.overtech.lenovo.R;

public class KnowledgeAdapter extends BaseAdapter {
	private String[] datas = new String[] { "硬件", "软件", "办公", "型号", "配置", "网络",
			"通信" };
	private Context ctx;
	public KnowledgeAdapter(Context ctx){
		this.ctx=ctx;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(ctx).inflate(
					R.layout.item_listview_knowledge, null);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		vh.knowledgeItem.setText(datas[position]);
		return convertView;
	}

	class ViewHolder {
		TextView knowledgeItem;

		public ViewHolder(View convertView) {
			knowledgeItem = (TextView) convertView
					.findViewById(R.id.tv_knowlwdge_item);
		}
	}
}
