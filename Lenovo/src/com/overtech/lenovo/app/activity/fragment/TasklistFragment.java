package com.overtech.lenovo.app.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.overtech.lenovo.R;
import com.overtech.lenovo.app.BaseFragment;
import com.overtech.lenovo.entity.tasklist.webservice.ADInfo;
import com.overtech.lenovo.utils.Utilities;
import com.overtech.lenovo.widget.bitmap.ImageLoader;
import com.overtech.lenovo.widget.cycleviewpager.CycleViewPager;
import com.overtech.lenovo.widget.cycleviewpager.ViewFactory;

public class TasklistFragment extends BaseFragment implements OnClickListener {
	private TextView mTaskAll;
	private TextView mTaskReceive;
	private TextView mTaskOrder;
	private TextView mTaskVisit;
	private TextView mTaskAccount;
	private TextView mTaskEvaluation;
	private CycleViewPager cycleViewPager;

	private List<ImageView> views = new ArrayList<ImageView>();
	private List<ADInfo> infos = new ArrayList<ADInfo>();
	private String[] imageUrls = {
			"http://pic90.nipic.com/file/20160225/5189591_225045255000_2.jpg",
			"http://pic1.huitu.com/res/20110407/1086_20110407213952112000_1.jpg",
			"http://pic75.nipic.com/file/20150818/17961491_085903764000_2.jpg",
			"http://pic65.nipic.com/file/20150420/18897329_213037602000_2.jpg", };

	@Override
	protected int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_tasklist;
	}

	@Override
	protected void afterCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Utilities.showToast("工单", getActivity());
		mTaskAll = (TextView) mRootView.findViewById(R.id.tv_task_all);
		mTaskReceive = (TextView) mRootView.findViewById(R.id.tv_task_receive);
		mTaskOrder = (TextView) mRootView.findViewById(R.id.tv_task_order);
		mTaskVisit = (TextView) mRootView.findViewById(R.id.tv_task_visit);
		mTaskAccount = (TextView) mRootView.findViewById(R.id.tv_task_account);
		mTaskEvaluation = (TextView) mRootView
				.findViewById(R.id.tv_task_evaluation);

		initialCycleViewPager();

		mTaskAll.setOnClickListener(this);
		mTaskReceive.setOnClickListener(this);
		mTaskOrder.setOnClickListener(this);
		mTaskVisit.setOnClickListener(this);
		mTaskAccount.setOnClickListener(this);
		mTaskEvaluation.setOnClickListener(this);
	}

	private void initialCycleViewPager() {
		// TODO Auto-generated method stub
		ImageLoader.getInstance().initContext(getActivity());// 初始化ImageView;
		cycleViewPager = (CycleViewPager) getActivity().getFragmentManager()
				.findFragmentById(R.id.fragment_cycle_viewpager_content);
		for (int i = 0; i < imageUrls.length; i++) {
			ADInfo info = new ADInfo();
			info.setUrl(imageUrls[i]);
			info.setContent("图片-->" + i);
			infos.add(info);
		}

		// 将最后一个ImageView添加进来
		views.add(ViewFactory.getImageView(getActivity(),
				infos.get(infos.size() - 1).getUrl()));
		for (int i = 0; i < infos.size(); i++) {
			views.add(ViewFactory.getImageView(getActivity(), infos.get(i)
					.getUrl()));
		}
		// 将第一个ImageView添加进来
		views.add(ViewFactory
				.getImageView(getActivity(), infos.get(0).getUrl()));

		// 设置循环，在调用setData方法前调用
		cycleViewPager.setCycle(true);

		// 在加载数据前设置是否循环
		cycleViewPager.setData(views, infos, null);
		// 设置轮播
		cycleViewPager.setWheel(true);

		// 设置轮播时间，默认5000ms
		cycleViewPager.setTime(2000);
		// 设置圆点指示图标组居中显示，默认靠右
		cycleViewPager.setIndicatorCenter();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mTaskAll.setSelected(false);
		mTaskReceive.setSelected(false);
		mTaskOrder.setSelected(false);
		mTaskVisit.setSelected(false);
		mTaskAccount.setSelected(false);
		mTaskEvaluation.setSelected(false);
		switch (v.getId()) {
		case R.id.tv_task_all:
			mTaskAll.setSelected(true);
			break;
		case R.id.tv_task_receive:
			mTaskReceive.setSelected(true);
			break;
		case R.id.tv_task_order:
			mTaskOrder.setSelected(true);
			break;
		case R.id.tv_task_visit:
			mTaskVisit.setSelected(true);
			break;
		case R.id.tv_task_account:
			mTaskAccount.setSelected(true);
			break;
		case R.id.tv_task_evaluation:
			mTaskEvaluation.setSelected(true);
			break;

		default:
			break;
		}
	}
}
