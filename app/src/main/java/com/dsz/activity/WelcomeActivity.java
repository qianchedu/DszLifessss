package com.dsz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.dsz.utils.PrefUtils;
import com.dsz.utils.ToastUtils;

import java.util.ArrayList;

public class WelcomeActivity extends Activity {

	private static final int[] mImageIds = new int[] { R.mipmap.a,
			R.mipmap.b, R.mipmap.c };
	private ViewPager vpWelcome;
	private Button btStart;//立即体验
	private ArrayList<ImageView> mImageViewList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//去标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_welcome);
		vpWelcome = (ViewPager) findViewById(R.id.vp_welcome);
		btStart = (Button) findViewById(R.id.bt_start);
		btStart.setVisibility(View.INVISIBLE);
		btStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//更新sp,表示已经显示了新手指导
				PrefUtils.setBoolean(WelcomeActivity.this,"is_user_guide_showed", true);
				startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
				finish();
			}
		});

		initViews();
		vpWelcome.setAdapter(new GuideAdapter());
		vpWelcome.setOnPageChangeListener(new GuidePageListener());
	}

	/**
	 * 界面初始化
	 */
	private void initViews(){
		mImageViewList=new ArrayList<ImageView>();
		//初始化引导页的3个界面
		for(int i=0;i<mImageIds.length;i++){
			ImageView image = new ImageView(this);
			image.setBackgroundResource(mImageIds[i]);
			mImageViewList.add(image);
		}
	}

	/**
	 * ViewPager数据适配器
	 */
	class GuideAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImageIds.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mImageViewList.get(position));
			return mImageViewList.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}




	/**
	 * ViewPager的滑动监听
	 */

	class GuidePageListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			if(arg0==mImageIds.length-1){
				btStart.setVisibility(View.VISIBLE);
			}else{
				btStart.setVisibility(View.INVISIBLE);
			}

		}

	}


	/**
	 * 点击退出
	 */
	private boolean isExit = false;

	@Override
	public void onBackPressed() {
		if (isExit) {
			finish();
		} else {
			ToastUtils.Message(getApplicationContext(), "再点一次退出");
			isExit = true;
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					isExit = false;
				}
			}, 3000);
		}
	}
//	/**
//	 * 捕捉返回键
//	 */
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK) {
//			if (isExit) {
//				return super.onKeyDown(keyCode, event);
//			} else {
//				return true;
//			}
//		}
//		return super.onKeyDown(keyCode, event);
//	}



}
