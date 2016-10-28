package com.dsz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dsz.entity.ADInfo;
import com.dsz.utils.ToastUtils;
import com.dsz.view.ImageCycleView;
import com.dsz.view.SlidingLayout;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements SlidingLayout.IsClickListener{

	private String[] imageUrls = {
			"http://down1.sucaitianxia.com/psd02/psd158/psds27988.jpg",
			"http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
			"http://pic2.ooopic.com/11/35/98/12bOOOPIC8f.jpg",
			"http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
			"http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"
	};

	private ImageCycleView mAdView;
	private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();
	private ImageView id_home;
	private ImageView id_health;
	private ImageView id_data;
	private ImageView id_recreation;
	private ImageView id_toggleMenu;
	private SlidingLayout slidingLayout;
	private TextView id_model;
	private TextView monitoring1;
	boolean isClick = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		regReceiver();
		init();
	}

	private void init() {
		for(int i=0;i < imageUrls.length; i++){
			ADInfo info = new ADInfo();
			info.setUrl(imageUrls[i]);
			//info.setContent("top-->" + i);
			infos.add(info);
		}
		mAdView = (ImageCycleView) findViewById(R.id.ad_view);
		mAdView.setImageResources(infos, mAdCycleViewListener);


		//找到侧滑菜单
		slidingLayout = (SlidingLayout) findViewById(R.id.slidingLayout);
		slidingLayout.setClickListener(this);
		id_home = (ImageView) findViewById(R.id.id_home);//居家
		id_health = (ImageView) findViewById(R.id.id_health);//健康
		id_data = (ImageView) findViewById(R.id.id_data);//数据
		id_recreation = (ImageView) findViewById(R.id.id_recreation);//娱乐

		//主界面的线性布局
		LinearLayout id_outerLayout = (LinearLayout) findViewById(R.id.ly);
		//将监听滑动事件绑定在最外面那个布局上面
     	slidingLayout.setScrollEvent(id_outerLayout);
		slidingLayout.setScrollEvent(id_home);
		slidingLayout.setScrollEvent(id_health);
		slidingLayout.setScrollEvent(id_data);
		slidingLayout.setScrollEvent(id_recreation);

		id_toggleMenu = (ImageView) findViewById(R.id.id_toggleMenu);//侧滑菜单开关


		id_model=(TextView)findViewById(R.id.id_mode1);//情景模式
		monitoring1=(TextView)findViewById(R.id.monitoring1);//情景模式


		id_toggleMenu.setOnClickListener(new id_toggleMenuOnClickListener());
		id_home.setOnClickListener(new ID_homeOnClickListener());
		id_health.setOnClickListener(new ID_healthOnClickListener());
		id_data.setOnClickListener(new ID_dataOnClicklistener());
		id_recreation.setOnClickListener(new ID_recreationOnClicklistener());
		id_model.setOnClickListener(new ID_mode1Onclicklistener());
		monitoring1.setOnClickListener(new ID_monitoringOnclicklistener());


	}

	@Override
	public void isClick(boolean isClick) {
		this.isClick = isClick;
	}

	//居家监听
	class ID_homeOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (isClick) {
				Intent intent=new Intent(MainActivity.this,ModelActivity.class);
				startActivity(intent);
			} else {

			}


		}

	}
	//健康监听
	class ID_healthOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (isClick) {
				Intent intent=new Intent(MainActivity.this,ModelActivity.class);
				startActivity(intent);
			} else {

			}
		}
	}
	//数据监听
	class ID_dataOnClicklistener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (isClick) {
				Intent intent=new Intent(MainActivity.this,ModelActivity.class);
				startActivity(intent);
			} else {

			}
		}
	}
	//娱乐监听
	class ID_recreationOnClicklistener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (isClick) {
				Intent intent=new Intent(MainActivity.this,ModelActivity.class);
				startActivity(intent);
			} else {

			}
		}
	}







	//侧滑情景模式监听
	class ID_mode1Onclicklistener implements OnClickListener {
		@Override
		public void onClick(View view) {
			Intent intent=new Intent(MainActivity.this,ModelActivity.class);
			startActivity(intent);
		}
	}






	//侧滑菜单开关
	class id_toggleMenuOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// 实现点击一下id_toggleMenu展示左侧布局，再点击一下隐藏左侧布局的功能
			if (slidingLayout.isLeftLayoutVisible()) {
				slidingLayout.scrollToRightLayout();
			} else {
				slidingLayout.scrollToLeftLayout();
			}
		}
	}







	//轮播图监听
	private ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {

		@Override
		public void onImageClick(ADInfo info, int position, View imageView) {
			switch (position+1) {
				case 1:
					Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(MainActivity.this,"2", Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
					break;
				case 5:
					Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
			}

		}
		@Override
		public void displayImage(String imageURL, ImageView imageView) {
			ImageLoader.getInstance().displayImage(imageURL, imageView);// 使用ImageLoader对图片进行加装！
		}
	};


	@Override
	protected void onResume() {
		super.onResume();
		mAdView.startImageCycle();
	};

	@Override
	protected void onPause() {
		super.onPause();
		mAdView.pushImageCycle();
	}

	/**
	 * 取消广播注册
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregReceiver();
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


	private class ID_monitoringOnclicklistener implements OnClickListener {
		@Override
		public void onClick(View view) {
			Intent intent = new Intent(MainActivity.this,MonitorAcitivty.class);
			startActivity(intent);
		}
	}
}
