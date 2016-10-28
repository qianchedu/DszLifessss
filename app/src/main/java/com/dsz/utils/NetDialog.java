package com.dsz.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

public class NetDialog {
	//开机判断网络提示
	public static void myget(final Context context) {
		String Mtype = NetUtils.getNetworkType(context);

		if(Mtype.equals("无网络")) {
			AlertDialog.Builder builder = new Builder(context);
			builder.setTitle("网络提示");
			builder.setMessage(Mtype+"连接,建议开启Wifi.");
			builder.setPositiveButton("确定", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent("android.net.wifi.PICK_WIFI_NETWORK");
					context.startActivity(intent);
				}
			});
			builder.setNegativeButton("忽略", new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			AlertDialog dialog = builder.create();
			dialog.show();

		}
	}}
