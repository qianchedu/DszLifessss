package com.dsz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dsz.utils.PrefUtils;

import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends Activity {

	private ImageView logo1;
	private ImageView logo2;
	private ImageView logo3;
	private ImageView logo4;
	private ImageView logo5;
	private ImageView logo6;
	private int width;//屏幕宽度
	private int height;//屏幕高

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		init();
	}

	private void init(){
		//显示的4张组合logo
		logo1 = (ImageView) findViewById(R.id.logo1);
		logo2 = (ImageView) findViewById(R.id.logo2);
		logo3 = (ImageView) findViewById(R.id.logo3);
		logo4 = (ImageView) findViewById(R.id.logo4);
		//隐藏的2张logo
		logo5 = (ImageView) findViewById(R.id.logo5);
		logo6 = (ImageView) findViewById(R.id.logo6);

		//把RelativeLayout中的logo1移至View的最上层
		RelativeLayout hiddenLayout = (RelativeLayout) findViewById(R.id.hiddenLayout);
		hiddenLayout.bringToFront();

		//获取屏幕宽高
		WindowManager wm = this.getWindowManager();
		width = wm.getDefaultDisplay().getWidth();
		height = wm.getDefaultDisplay().getHeight();

		//开始动画
		startAnim();
		new Reminder((int)(4));

	}



	/**
	 * 延时
	 * 动画执行完 再进入主界面
	 */
	public class Reminder {
		Timer timer;
		public Reminder(int seconds) {
			timer = new Timer();
			timer.schedule(new RemindTask(), seconds*1000);
		}
		class RemindTask extends TimerTask {
			public void run() {

				jumpNextPage();
				timer.cancel();
				finish();
			}
		}
	}

	/**
	 * 开启动画
	 */
	private void startAnim() {
		System.out.println("开始");
		// 动画集合
		AnimationSet set = new AnimationSet(false);
		// 渐变动画
		System.out.println("开始执行");
		AlphaAnimation alpha = new AlphaAnimation(0.8f, 0f);
		alpha.setDuration(2000);// 动画时间
		alpha.setFillAfter(true);// 保持动画状态
		set.addAnimation(alpha);

		// 设置动画监听
		set.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				System.out.println("动画开始...");
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				System.out.println("动画重复...");
			}

			// 动画执行结束
			@Override
			public void onAnimationEnd(Animation animation) {
				System.out.println("动画结束...");

				logo1.setVisibility(View.INVISIBLE);
				logo2.setVisibility(View.INVISIBLE);
				logo4.setVisibility(View.INVISIBLE);

				logo5.setVisibility(View.GONE);
				logo6.setVisibility(View.GONE);

				//D平移的代码
				int logo5height = PrefUtils.screenHeight(logo5);
				System.out.println("D高"+logo5height);
				int logo5width = PrefUtils.screenWidth(logo5);
				System.out.println("x2图片宽+"+logo5width);
				final TranslateAnimation animation2 = new TranslateAnimation(0,(width/2-logo5height)+(logo5height/2+0.5f),0,0);
				animation2.setDuration(2000);
				animation2.setFillAfter(true);
				logo5.startAnimation(animation2);
				System.out.println((width/2-logo5height)+(logo5height/2+0.5f));




				//F平移的代码
				int logo3width = PrefUtils.screenWidth(logo3);
				System.out.println("F的宽+"+logo3width);
				int logo3height=PrefUtils.screenHeight(logo3);
				System.out.println("F的高"+logo3height);

				int logo3X = PrefUtils.Xcoords(logo3);
				System.out.println("x一"+logo3X);
				final TranslateAnimation animation1 = new TranslateAnimation(0,((width/2)-logo3X)+(((width/2)-logo3X)/2+0.5f),0,0);
				animation1.setDuration(2000);
				animation1.setFillAfter(true);
				logo3.startAnimation(animation1);
				System.out.println(((width/2)-logo3X)+(((width/2)-logo3X)/2-0.5f));


				//Z平移代码
				int logo6height = PrefUtils.screenHeight(logo6);
				System.out.println("Z的高"+logo6height);
				int logo6width = PrefUtils.screenWidth(logo6);
				System.out.println("Z的宽+"+logo6width);
				final TranslateAnimation animation3 = new TranslateAnimation(0,-((width/2)-(logo3width/2)-logo6width),0,-((height/2)-(logo3height/2)-logo6height));
				animation3.setDuration(2000);
				animation3.setFillAfter(true);
				logo6.startAnimation(animation3);
				System.out.println("+++++"+-((width/2)-(logo3width/2)-logo6width));
				System.out.println("------"+-((height/2)-(logo3height/2)-logo6height));
			}
		});

		logo1.startAnimation(set);
		logo2.startAnimation(set);
		logo4.startAnimation(set);
	}


	/**
	 * 跳转下一个页面
	 */
	private void jumpNextPage() {
		// 判断之前有没有显示过新手引导
		boolean userGuide = PrefUtils.getBoolean(this, "is_user_guide_showed",
				false);
		if (!userGuide) {
			// 跳转到新手引导页
			startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
		} else {
			startActivity(new Intent(SplashActivity.this,LoginActivity.class));
		}
		finish();
	}











}
