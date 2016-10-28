package com.dsz.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterActivity extends Activity {
    private ImageView RegisterBack;
    private EditText PhoneEditText1;
    private EditText VerifyEditText1;
    private Button getCAPTCHA1;
    private Button NextButton1;

    //注册账号
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterBack = (ImageView) findViewById(R.id.RegisterBack);//注册返回键
        PhoneEditText1 = (EditText) findViewById(R.id.PhoneEditText1);//注册输入手机号框
        VerifyEditText1 = (EditText) findViewById(R.id.VerifyEditText1);//注册输入验证码框
        getCAPTCHA1 = (Button) findViewById(R.id.getCAPTCHA1);//注册时获取验证码按钮
        NextButton1 = (Button) findViewById(R.id.Nextbutton1);//注册界面下一步按钮

        RegisterBack.setOnClickListener(new RegisterBackOnClickListener());
        PhoneEditText1.setOnClickListener(new PhoneEditText1OnClickListener());
        VerifyEditText1.setOnClickListener(new VerifyEditText1OnClickListener());
        getCAPTCHA1.setOnClickListener(new getCAPTCHA1OnClickListener());
        NextButton1.setOnClickListener(new NextButton1OnClickListener());

    }

    //注册返回键
    class RegisterBackOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    //注册输入手机号框
    class PhoneEditText1OnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }
    //注册输入验证码框
    class VerifyEditText1OnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    //注册时获取验证码按钮
    class getCAPTCHA1OnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    //注册界面下一步按钮
    class NextButton1OnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }






}
