package com.dsz.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.dsz.adapter.GuideFragmentAdapter;


/**
 * Created by Administrator on 2016/10/17.
 */

public class MonitorAcitivty extends FragmentActivity implements View.OnClickListener {
    public static final int TAB_KETING=0;
    public static final int TAB_ZHUWO=1;
    public static final int TAB_CEWO=2;
    public static final int TAB_CHUWEI=3;
//    public static final int TAB_QITA=4;
//    private TextView textTitle;
    private ViewPager viewPager;
    private RadioButton keting,zhuwo,cewo,chuwei;
    private ImageView monitor_back_iv;
    private TextView monitor_main_btn;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        context = MonitorAcitivty.this;
        initView();
        addListener();
    }
    private void initView() {

        monitor_back_iv = (ImageView) findViewById(R.id.monitor_back_iv);
        monitor_main_btn = (TextView) findViewById(R.id.monitor_main_btn);


//        textTitle=(TextView)findViewById(R.id.title_txt);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        keting = (RadioButton) findViewById(R.id.monitor_one_radiobutton);
        zhuwo = (RadioButton) findViewById(R.id.monitor_tow_radiobutton);
        cewo = (RadioButton) findViewById(R.id.monitor_three_radiobutton);
        chuwei=(RadioButton)findViewById(R.id.monitor_four_radiobutton);
//        qita=(RadioButton)findViewById(R.id.monitor_other_radiobutton);
//        textTitle.setText("居家");
        chuwei.setOnClickListener(this);
//        qita.setOnClickListener(this);
        keting.setOnClickListener(this);
        zhuwo.setOnClickListener(this);
        cewo.setOnClickListener(this);

        monitor_back_iv.setOnClickListener(this);
        monitor_main_btn.setOnClickListener(this);

        GuideFragmentAdapter adapter = new GuideFragmentAdapter(
                getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    private void addListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {




            @SuppressLint("NewApi")
            @Override
            public void onPageSelected(int id) {
                switch (id) {
                    case TAB_KETING:
                        keting.setChecked(true);
                        keting.setBackground(context.getDrawable(R.mipmap.blue_down));
                        zhuwo.setBackground(context.getDrawable(R.mipmap.empty));
                        cewo.setBackground(context.getDrawable(R.mipmap.empty));
                        chuwei.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        keting.setTextColor(context.getResources().getColor(R.color.text_on));
                        zhuwo.setTextColor(context.getResources().getColor(R.color.text_off));
                        cewo.setTextColor(context.getResources().getColor(R.color.text_off));
                        chuwei.setTextColor(context.getResources().getColor(R.color.text_off));
//                        qita.setTextColor(context.getResources().getColor(R.color.text_off));
                        break;
                    case TAB_ZHUWO:
                        zhuwo.setChecked(true);
                        keting.setBackground(context.getDrawable(R.mipmap.empty));
                        zhuwo.setBackground(context.getDrawable(R.mipmap.blue_down));
                        cewo.setBackground(context.getDrawable(R.mipmap.empty));
                        chuwei.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        keting.setTextColor(context.getResources().getColor(R.color.text_off));
                        zhuwo.setTextColor(context.getResources().getColor(R.color.text_on));
                        cewo.setTextColor(context.getResources().getColor(R.color.text_off));
                        chuwei.setTextColor(context.getResources().getColor(R.color.text_off));
//                        qita.setTextColor(context.getResources().getColor(R.color.text_off));
                        break;
                    case TAB_CEWO:
                        cewo.setChecked(true);
                        keting.setBackground(context.getDrawable(R.mipmap.empty));
                        zhuwo.setBackground(context.getDrawable(R.mipmap.empty));
                        cewo.setBackground(context.getDrawable(R.mipmap.blue_down));
                        chuwei.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        keting.setTextColor(context.getResources().getColor(R.color.text_off));
                        zhuwo.setTextColor(context.getResources().getColor(R.color.text_off));
                        cewo.setTextColor(context.getResources().getColor(R.color.text_on));
                        chuwei.setTextColor(context.getResources().getColor(R.color.text_off));
//                        qita.setTextColor(context.getResources().getColor(R.color.text_off));
                        break;
                    case TAB_CHUWEI:
                        chuwei.setChecked(true);
                        keting.setBackground(context.getDrawable(R.mipmap.empty));
                        zhuwo.setBackground(context.getDrawable(R.mipmap.empty));
                        cewo.setBackground(context.getDrawable(R.mipmap.empty));
                        chuwei.setBackground(context.getDrawable(R.mipmap.blue_down));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        keting.setTextColor(context.getResources().getColor(R.color.text_off));
                        zhuwo.setTextColor(context.getResources().getColor(R.color.text_off));
                        cewo.setTextColor(context.getResources().getColor(R.color.text_off));
                        chuwei.setTextColor(context.getResources().getColor(R.color.text_on));
//                        qita.setTextColor(context.getResources().getColor(R.color.text_off));
                        break;
//                    case TAB_QITA:
////                        qita.setChecked(true);
//                        keting.setBackground(context.getDrawable(R.drawable.empty));
//                        zhuwo.setBackground(context.getDrawable(R.drawable.empty));
//                        cewo.setBackground(context.getDrawable(R.drawable.empty));
//                        chuwei.setBackground(context.getDrawable(R.drawable.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.blue_down));
//                        keting.setTextColor(context.getResources().getColor(R.color.text_off));
//                        zhuwo.setTextColor(context.getResources().getColor(R.color.text_off));
//                        cewo.setTextColor(context.getResources().getColor(R.color.text_off));
//                        chuwei.setTextColor(context.getResources().getColor(R.color.text_off));
//                        qita.setTextColor(context.getResources().getColor(R.color.text_on));
//                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.monitor_one_radiobutton:
                viewPager.setCurrentItem(TAB_KETING);
                break;
            case R.id.monitor_tow_radiobutton:
                viewPager.setCurrentItem(TAB_ZHUWO);
                break;
            case R.id.monitor_three_radiobutton:
                viewPager.setCurrentItem(TAB_CEWO);
                break;
            case R.id.monitor_four_radiobutton:
                viewPager.setCurrentItem(TAB_CHUWEI);
                break;
//            case R.id.monitor_other_radiobutton:
//                viewPager.setCurrentItem(TAB_QITA);
//                break;


            case R.id.monitor_back_iv:
                finish();
                break;

            case R.id.monitor_main_btn:
                Intent intent=new Intent(MonitorAcitivty.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }
}