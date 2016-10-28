package com.dsz.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

	public static void Message(Context context, String text){
		Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	}
}
