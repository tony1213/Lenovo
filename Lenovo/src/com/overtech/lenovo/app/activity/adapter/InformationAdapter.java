package com.overtech.lenovo.app.activity.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.entity.information.webservice.Information;
import com.overtech.lenovo.picasso.Transformation;
import com.overtech.lenovo.utils.ImageCacheUtils;
import com.overtech.lenovo.widget.bitmap.ImageLoader;

public class InformationAdapter extends
		Adapter<InformationAdapter.MyViewHolder> {
	private List<Information> datas;
	private Context ctx;
	private OnItemButtonClickListener listener;

	public InformationAdapter(Context ctx, List<Information> datas) {
		this.ctx = ctx;
		this.datas = datas;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder vh, final int position) {
		// TODO Auto-generated method stub
		Information info = datas.get(position);
		ImageLoader.getInstance().displayImage(info.getAvator(), vh.avator,
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
				}, Config.RGB_565);// 处理头像
		vh.name.setText(info.getName());
		vh.description.setText(info.getDescription());

		if (vh.itemAdapter == null) {
			vh.itemAdapter = new InformationItemAdapter(ctx, info.getUrls());// 初始化item的adapter
		} else {
			vh.itemAdapter.setUrls(info.getUrls());
			vh.itemAdapter.notifyDataSetChanged();// 当出现convertView重用的时候，就将adapter重新刷新
		}
		vh.picture.setAdapter(vh.itemAdapter);// 每个item内的图片描述
		vh.time.setText(info.getTime() + "");
		vh.commend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (listener != null) {
					listener.buttonClick(v, position);
				}
			}
		});// 为评论注册点击事件

	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// TODO Auto-generated method stub
		MyViewHolder vh = new MyViewHolder(LayoutInflater.from(ctx).inflate(
				R.layout.item_recyclerview_information, parent, false));
		return vh;
	}

	class MyViewHolder extends ViewHolder {
		ImageView avator;
		TextView name;
		TextView description;
		GridView picture;
		TextView time;
		ImageView commend;
		InformationItemAdapter itemAdapter;// 为每一个ViewHolder绑定一个adapter

		public MyViewHolder(View convertView) {
			super(convertView);
			// TODO Auto-generated constructor stub
			avator = (ImageView) convertView
					.findViewById(R.id.iv_information_avator);
			name = (TextView) convertView
					.findViewById(R.id.tv_information_name);
			description = (TextView) convertView
					.findViewById(R.id.tv_information_description);
			picture = (GridView) convertView
					.findViewById(R.id.gv_information_picture);
			time = (TextView) convertView
					.findViewById(R.id.tv_information_time);
			commend = (ImageView) convertView
					.findViewById(R.id.iv_information_commend);
		}

	}

	public void setOnItemButtonClickListener(OnItemButtonClickListener listener) {
		this.listener = listener;
	}

	public interface OnItemButtonClickListener {
		void buttonClick(View v, int position);
	}
}
