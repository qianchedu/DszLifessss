package com.dsz.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

public class NetUtils {
	// / 没有连接
	public static final String NETWORN_NONE ="无网络";
	// / wifi连接
	public static final String NETWORN_WIFI ="Wifi网络";
	// / 手机网络数据连接
	public static final String NETWORN_2G = "2G网络";
	public static final String NETWORN_3G = "3G网络";
	public static final String NETWORN_4G = "4G网络";
	public static final String NETWORN_MOBILE = "移动网络";

	public static String getNetworkType(Context context){
		//获取手机网络信息
		ConnectivityManager connManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(null==connManager)
			return NETWORN_NONE;//没有网络

		//获取手机当前可用的网络
		NetworkInfo activeNetworkInfo = connManager.getActiveNetworkInfo();
		if(activeNetworkInfo==null||!activeNetworkInfo.isAvailable()){
			return NETWORN_NONE;
		}
		NetworkInfo wifiInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if(null!=wifiInfo){
			State state=wifiInfo.getState();
			if(state==state.CONNECTED||state==state.CONNECTING){
				return NETWORN_WIFI;
			}
		}
		//网络
		NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

		if(null!=networkInfo){
			State state = networkInfo.getState();
			String subtypeName = networkInfo.getSubtypeName();
			if(null!=state){
				if(state== State.CONNECTED||state== State.CONNECTING){
					switch(activeNetworkInfo.getSubtype()){
						case TelephonyManager.NETWORK_TYPE_GPRS: // 联通2g
						case TelephonyManager.NETWORK_TYPE_CDMA: // 电信2g
						case TelephonyManager.NETWORK_TYPE_EDGE: // 移动2g
						case TelephonyManager.NETWORK_TYPE_1xRTT:
						case TelephonyManager.NETWORK_TYPE_IDEN:
							return NETWORN_2G;

						case TelephonyManager.NETWORK_TYPE_EVDO_A: // 电信3g
						case TelephonyManager.NETWORK_TYPE_UMTS:
						case TelephonyManager.NETWORK_TYPE_EVDO_0:
						case TelephonyManager.NETWORK_TYPE_HSDPA:
						case TelephonyManager.NETWORK_TYPE_HSUPA:
						case TelephonyManager.NETWORK_TYPE_HSPA:
						case TelephonyManager.NETWORK_TYPE_EVDO_B:
						case TelephonyManager.NETWORK_TYPE_EHRPD:
						case TelephonyManager.NETWORK_TYPE_HSPAP:
							return NETWORN_3G;

						case TelephonyManager.NETWORK_TYPE_LTE:
							return NETWORN_4G;
						default:
							//中国移动 联通 电信 三种3G制式
							if (subtypeName.equalsIgnoreCase("TD-SCDMA") ||
									subtypeName.equalsIgnoreCase("WCDMA") ||
									subtypeName.equalsIgnoreCase("CDMA2000")){
								return NETWORN_3G;
							}else{
								return NETWORN_MOBILE;
							}
					}
				}
			}

		}
		return NETWORN_NONE;
	}


}

