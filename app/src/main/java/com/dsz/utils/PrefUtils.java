package com.dsz.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

public class PrefUtils {
	
	public static final String PREF_NAME = "config";

	public static boolean getBoolean(Context ctx, String key,
									 boolean defaultValue) {
		SharedPreferences sp = ctx.getSharedPreferences(PREF_NAME,
				Context.MODE_PRIVATE);
		return sp.getBoolean(key, defaultValue);
	}

	public static void setBoolean(Context ctx, String key, boolean value) {
		SharedPreferences sp = ctx.getSharedPreferences(PREF_NAME,
				Context.MODE_PRIVATE);
		sp.edit().putBoolean(key, value).commit();
	}
	
	//��ȡ��Ļ��ͼƬ�Ŀ�
	public static int screenWidth(final View v){
		v.post(new Runnable() {
			@Override
			public void run() {
				v.getWidth();
			}
		});
		return v.getWidth();}
	//��ȡ��Ļ��ͼƬ�ĸ�

	public static int screenHeight(final View v){
		
		v.post(new Runnable() {
		     @Override
	          public void run() {
	               v.getHeight(); //height is ready
	           }
	        });
		return v.getHeight();
	}
	//��ȡ��Ļ��ͼƬ��x����
	public static int Xcoords(View v){
		
		int[] location = new int[2];  
		v.getLocationOnScreen(location);  
		int x = location[0];
		return x;
	}
	//��ȡ��Ļ��ͼƬ��x����
	public static int Ycoords(View v){
		
		int[] location = new int[2];  
		v.getLocationOnScreen(location);  
		int y = location[1];
		
		return y;
	}
	
}
