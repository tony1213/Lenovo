package com.overtech.lenovo.app.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.app.activity.MainActivity;
import com.overtech.lenovo.app.activity.adapter.KnowledgeAdapter;
import com.overtech.lenovo.app.activity.knowledge.CommunicateFragment;
import com.overtech.lenovo.app.activity.knowledge.ConfigFragment;
import com.overtech.lenovo.app.activity.knowledge.HardWareFragment;
import com.overtech.lenovo.app.activity.knowledge.ModelFragment;
import com.overtech.lenovo.app.activity.knowledge.NetFragment;
import com.overtech.lenovo.app.activity.knowledge.SoftWareFragment;
import com.overtech.lenovo.app.activity.knowledge.WorkFragment;
import com.overtech.lenovo.utils.FragmentUtils;
import com.overtech.lenovo.utils.Utilities;

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
		fragmentManager = this.getChildFragmentManager();
		currentFragment = FragmentUtils.switchFragment(fragmentManager,
				R.id.fl_knowledge_container, currentFragment, clazz[0], null,
				false);
		adapter = new KnowledgeAdapter(getActivity());
		konwledgeTitle.setAdapter(adapter);
		konwledgeTitle.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

				currentFragment = FragmentUtils.switchFragment(fragmentManager,
						R.id.fl_knowledge_container, currentFragment,
						clazz[arg2], null, false);
			}
		});
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.menu_knowledge, menu);
		// SearchView searchView=(SearchView)
		// MenuItemCompat.getActionView(menu.findItem(R.id.menu_search));

		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		ActionBar actionBar = ((MainActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle("知识");
		Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_main);
		toolbar.setNavigationIcon(R.drawable.icon_tab_knowledge_selected);
		super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_search:
			Utilities.showToast("您点击了搜索", getActivity());
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
