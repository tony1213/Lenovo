package com.overtech.lenovo.app.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.adapter.KnowledgeAdapter;
import com.overtech.lenovo.app.activity.knowledge.CommunicateFragment;
import com.overtech.lenovo.app.activity.knowledge.ConfigFragment;
import com.overtech.lenovo.app.activity.knowledge.HardWareFragment;
import com.overtech.lenovo.app.activity.knowledge.ModelFragment;
import com.overtech.lenovo.app.activity.knowledge.NetFragment;
import com.overtech.lenovo.app.activity.knowledge.SoftWareFragment;
import com.overtech.lenovo.app.activity.knowledge.WorkFragment;
import com.overtech.lenovo.utils.FragmentUtils;

public class KnowledgeFragment extends BaseFragment {
	private ListView konwledgeTitle;
	private KnowledgeAdapter adapter;
	private FragmentManager fragmentManager;
	private Fragment currentFragment;
	private Class[] clazz = new Class[] { HardWareFragment.class,
			SoftWareFragment.class, WorkFragment.class, ModelFragment.class,
			ConfigFragment.class, NetFragment.class, CommunicateFragment.class };

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_knowledge;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		konwledgeTitle = (ListView) mRootView
				.findViewById(R.id.lv_konwledge_title);
		adapter = new KnowledgeAdapter(getActivity());
		konwledgeTitle.setAdapter(adapter);
		konwledgeTitle.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				currentFragment=FragmentUtils.switchFragment(fragmentManager,
						R.id.fl_knowledge_container, currentFragment,
						clazz[arg2], null, false);
			}
		});
		fragmentManager = getActivity().getSupportFragmentManager();
	}
}
