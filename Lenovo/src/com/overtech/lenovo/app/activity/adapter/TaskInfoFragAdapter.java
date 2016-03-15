package com.overtech.lenovo.app.activity.adapter;

import java.util.List;

import com.overtech.lenovo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TaskInfoFragAdapter extends BaseAdapter {
	private Context ctx;
	private List datas;

	public TaskInfoFragAdapter(Context ctx, List datas) {
		this.ctx = ctx;
		this.datas = datas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public Object getItem(int arg0) {
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
			convertView = View.inflate(ctx,
					R.layout.item_listview_task_process, null);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);

		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	class ViewHolder {
		public ViewHolder(View view) {

		}
	}

}
