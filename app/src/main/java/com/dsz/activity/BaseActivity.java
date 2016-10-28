package com.dsz.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.dsz.utils.DeviceUtil;
import com.dsz.utils.ToastUtils;


public class BaseActivity extends Activity {
	
	private MyBroadcastReceiver myBroadcast;
	private IntentFilter mIntenFilter;

	/**
	 * 广播注册
	 */
	public void regReceiver(){
		mIntenFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
		mIntenFilter.setPriority(1000);//设置优先级
		myBroadcast=new MyBroadcastReceiver();
		this.registerReceiver(myBroadcast, mIntenFilter);
	}
	/**
	 * 取消广播
	 */
	public void unregReceiver(){
		this.unregisterReceiver(myBroadcast);
	}
	
	/**
	 * 接收广播
	 */
	static class MyBroadcastReceiver extends BroadcastReceiver {
		static boolean isFirstNetChange = true;
		static int type = 0;//0代表无网络，1代表34G// ，2代表wifi网络
		static Object lock = new Object();
		@Override
		public void onReceive(Context context, Intent intent) {
			if (isFirstNetChange) {//第一次进来不提示
				isFirstNetChange = false;
				if (DeviceUtil.isWifiConnected(context)) {//有wifi就不判断4G网认为4G网不可用
					type = 2;
				} else if (DeviceUtil.isMobileConnected(context)) {
					type = 1;
				} else {
					type = 0;
				}
				return;
			}
           
			synchronized (lock) {//里面的变量保证不会在同一个时间里面多处改变
				if (type == 0) {//之前是无网络
					if (DeviceUtil.isWifiConnected(context)) {//现在是WiFi
						type = 2;
						ToastUtils.Message(context, "wifi网络已启用 -.-");
					} else if (DeviceUtil.isMobileConnected(context)) {//现在是4G
						type = 1;
						ToastUtils.Message(context, "当前使用2G/3G/4G网络^?^");
					} else {
						//之前无网络现在还是无网络重复通知不处理
					}
				} else if (type == 1) {//之前是4G网络
					if (DeviceUtil.isWifiConnected(context)) {//現在是wifi
						type = 2;
						ToastUtils.Message(context, "wifi网络已启用 -.-");
					} else if (!DeviceUtil.isNetworkConnected(context)) {//现在没有网络
						type = 0;
						ToastUtils.Message(context,"当前无网络连接✘");
					} else {

						//之前4G网络现在还是4G络重复通知不处理
					}
				} else if (type == 2) {//之前是wifi
					if (DeviceUtil.isMobileConnected(context)) {//现在是4G
						type = 1; 
						ToastUtils.Message(context, "当前使用2G/3G/4G网络^?^");
					} else if (!DeviceUtil.isNetworkConnected(context)) {//现在没有网络
						type = 0;
						ToastUtils.Message(context,"当前无网络连接✘");
					} else {
						//之前是wifi现在还是wifi
					}
				}
			}
		}
	}
	
	
}
