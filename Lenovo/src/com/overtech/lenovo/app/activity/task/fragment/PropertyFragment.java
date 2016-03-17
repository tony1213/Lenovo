package com.overtech.lenovo.app.activity.task.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.PropertyAdapter;
import com.overtech.lenovo.entity.tasklist.webservice.PropertyInfo;

public class PropertyFragment extends BaseFragment {
	private ListView mProperty;
	private String[][] infos = new String[][] {
			{ "类型", "品牌", "型号", "数量", "序列号", "报修截止日期", "备注" },
			{ "PC", "联想", "1730595", "2", "123456", "2016-10-10", "断网" },
			{ "POS", "惠普", "lied210", "1", "908098", "2016-09-09", "破损" },
			{ "IPAD", "华硕", "v12347", "3", "535345", "2016-09-10", "破损" },
			{ "路由器", "三星", "r234", "2", "23542", "2016-08-08", "挂掉" } };
	private List<PropertyInfo> datas;
	private PropertyAdapter adapter;
	private View header;
	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_property;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mProperty=(ListView) mRootView.findViewById(R.id.lv_property);
		
		datas=new ArrayList<PropertyInfo>();
		PropertyInfo pi1=new PropertyInfo("PC", "联想", "1730595", "2", "123456", "2016-10-10", "断网");
		PropertyInfo pi2=new PropertyInfo("POS", "惠普", "lied210", "1", "908098", "2016-09-09", "破损");
		PropertyInfo pi3=new PropertyInfo("IPAD", "华硕", "v12347", "3", "535345", "2016-09-10", "破损");
		PropertyInfo pi4=new PropertyInfo("路由器", "三星", "r234", "2", "23542", "2016-08-08", "挂掉");
		datas.add(pi1);
		datas.add(pi2);
		datas.add(pi3);
		datas.add(pi4);
		adapter=new PropertyAdapter(getActivity(), datas);
		
		header=LayoutInflater.from(getActivity()).inflate(R.layout.item_headerview_property, null);
		mProperty.addHeaderView(header);
		mProperty.setAdapter(adapter);
	}

}
