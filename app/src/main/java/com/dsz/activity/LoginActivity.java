package com.dsz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dsz.utils.NetDialog;
import com.dsz.utils.ToastUtils;


public class LoginActivity extends BaseActivity{


	private Button login;
	private TextView password;
	private TextView register;
	private EditText IDEditText;
	private EditText PasswordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acvitity_login);
		//动态注册广播
		regReceiver();//注册广播
		NetDialog.myget(LoginActivity.this);
		login = (Button) findViewById(R.id.login);//登录
		password = (TextView) findViewById(R.id.password);//忘记密码
		register = (TextView) findViewById(R.id.Register);//会员注册
		IDEditText = (EditText) findViewById(R.id.IDEditText);//账号输入框
		PasswordEditText = (EditText) findViewById(R.id.PasswordEditText);//密码输入框

		login.setOnClickListener(new LoginOnClickListener());
		password.setOnClickListener(new PasswordOnClickListener());
		register.setOnClickListener(new RegisterOnClickListener());
		IDEditText.setOnClickListener(new IDEditTextOnClickListener());
		PasswordEditText.setOnClickListener(new PasswordEditTextOnClickListener());

	}
	//登录按钮
	class LoginOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
			LoginActivity.this.finish();

		}
	}

	//忘记密码
	class PasswordOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
			startActivity(intent);
		}

	}

	//会员注册

	class RegisterOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
			startActivity(intent);

		}
	}

	//账号输入框
	class IDEditTextOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {

		}
	}

	//密码输入框
	class PasswordEditTextOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {

		}
	}

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

}
