package com.dsz.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/10/18.
 */
public class FullScreenActivity extends Activity {

    private boolean isShow;

    LinearLayout fullscreen_widget_control_ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置为没有title模式
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getActionBar().setBackgroundDrawable(
        //       getResources().getDrawable(R.drawable.semi_transparent));


        setContentView(R.layout.activity_fullscreen);

        initViews();

    }

    private void initViews() {
        fullscreen_widget_control_ll = (LinearLayout) findViewById(R.id.fullscreen_widget_control_ll);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(isShow){
            hide();
            isShow = false;
        }else{
            show();
            isShow = true;
        }


        return super.onTouchEvent(event);
    }

    private void show() {
        fullscreen_widget_control_ll.setVisibility(View.VISIBLE);
    }

    private void hide() {
        fullscreen_widget_control_ll.setVisibility(View.GONE);

    }
}
