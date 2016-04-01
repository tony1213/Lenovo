package com.overtech.lenovo.app;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.overtech.lenovo.app.service.LocationService;

import android.app.Application;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class MyApplication extends Application {
	public LocationService locationService;
	public MyBDLocaitonListener listener;
	public String city;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		locationService = new LocationService(getApplicationContext());
		listener = new MyBDLocaitonListener();
		locationService.registerListener(listener);
		locationService.start();
	}

	class MyBDLocaitonListener implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// TODO Auto-generated method stub
			if (location != null) {
				city = location.getCity();
				locationService.stop();
			}else{
				locationService.start();
			}
		}

	}
}
