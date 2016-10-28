package com.dsz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

//忘记密码
public class PasswordActivity extends Activity {

	private ImageView Myback;
	private Button Nextbutton;
	private EditText PhoneEditText;
	private EditText VerifyEditText;
	private Button getCAPTCHA;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password);

		Myback = (ImageView) findViewById(R.id.back);//返回键图片
		Nextbutton = (Button) findViewById(R.id.Nextbutton);//下一步按钮
		PhoneEditText=(EditText) findViewById(R.id.PhoneEditText);//手机号码输入框
		VerifyEditText=(EditText) findViewById(R.id.VerifyEditText);//验证码输入框
		getCAPTCHA = (Button) findViewById(R.id.getCAPTCHA);//获得验证码按钮
//		Nextbutton.setEnabled(false);//默认下一步按钮点击不了

		Myback.setOnClickListener(new MybackOnClickListener());
		Nextbutton.setOnClickListener(new NextbuttonOnClickListener());
		PhoneEditText.setOnClickListener(new PhoneEditTextOnClickListener());
		VerifyEditText.setOnClickListener(new VerifyEditTextOnClickListener());
		getCAPTCHA.setOnClickListener(new getCAPTCHAOnClickListener());



	}
	//手机号码输入框
	class PhoneEditTextOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {

		}

	}
	//验证码输入框
	class VerifyEditTextOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
//			Nextbutton.setEnabled(true);
		}
	}


	//返回键按钮
	class MybackOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			finish();
		}
	}
	//下一步按钮
	class NextbuttonOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			Intent intent = new Intent(PasswordActivity.this, SetPasswordActivity.class);
			startActivity(intent);
		}

	}
	//获得验证码按钮
	class getCAPTCHAOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {

		}
	}



}
