package com.overtech.lenovo.app.activity.task.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.StoreInfoAdapter;
import com.overtech.lenovo.widget.itemdecoration.DividerGridItemDecoration;

public class StoreInformationFragment extends BaseFragment {
	private RecyclerView mRecyclerView;
	private List<String> imageUrl;
	private StoreInfoAdapter adapter;

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_store_information;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		imageUrl = new ArrayList<String>();
		imageUrl.add("http://img2.imgtn.bdimg.com/it/u=696631664,1038026166&fm=21&gp=0.jpg");
		imageUrl.add("http://p5.qhimg.com/t01e21400abc9e80fce.jpg");
		imageUrl.add("http://img5.duitang.com/uploads/item/201410/26/20141026112311_2ZTEY.thumb.700_0.jpeg");
		imageUrl.add("http://editor.gudumami.cn/img_u/menu_add/cs90853/201304/20130421143945_ra5keb_1.jpg");
		adapter = new StoreInfoAdapter(getActivity(), imageUrl);
		mRecyclerView = (RecyclerView) mRootView
				.findViewById(R.id.recycler_store_info);
		mRecyclerView.addItemDecoration(new DividerGridItemDecoration(
				getActivity()));
		// mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),
		// 2));
		mRecyclerView.setAdapter(adapter);
	}

}
