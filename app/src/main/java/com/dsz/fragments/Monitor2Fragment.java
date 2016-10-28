package com.dsz.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.dsz.activity.R;
import com.dsz.adapter.MonitorListViewAdapter;
import com.dsz.bean.SelectItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
public class Monitor2Fragment extends Fragment implements
        AdapterView.OnItemClickListener {
    private static final String TAG = "cloudy/EnterActivity";
    private ListView mListView = null;
    private BaseAdapter mAdapter = null;
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= View.inflate(getActivity(), R.layout.fragment_monitor1,null);
        Log.d(TAG, "onCreate: ");
        mListView = (ListView) view.findViewById(R.id.monitor_msg_listview);
        if (mListView != null) {
            mListView.setOnItemClickListener(this);
        }
        configListView();

        return view;



    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "onItemClick: position: " + position);
        int selectId = ((SelectItemBean) mAdapter.getItem(position)).getActionRes();
        switch (selectId) {
            case R.string.select_action_name_shareapk:
                Log.d(TAG, "onItemClick: share apk action is click!");
//                    Toast.makeText(this, "share apk will start!", Toast.LENGTH_SHORT).show();
                doShareApk();
                break;
            case R.string.select_action_name_qrcode:
//                    Toast.makeText(this, "scan had no implement!", Toast.LENGTH_SHORT).show();
                break;
            case R.string.select_action_name_musicrepeater:
//                    Toast.makeText(this, "repeater had no implements!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void configListView() {
        createAndConfigAdapter(getActivity(), initData());
    }

    private List<SelectItemBean> initData() {
        //get data
        int[] acitonNameArray = new int[]{
                R.string.select_action_name_shareapk,
                R.string.select_action_name_qrcode,
                R.string.select_action_name_musicrepeater};

        List<Drawable> iconArray = new ArrayList<Drawable>();
        iconArray.add(getResources().getDrawable(R.drawable.monitor_select_image));
        iconArray.add(getResources().getDrawable(R.drawable.monitor_select_image));
        iconArray.add(getResources().getDrawable(R.drawable.monitor_select_image));

        List<SelectItemBean> data = new ArrayList<SelectItemBean>();
        for (int i = 0; i < acitonNameArray.length; i++) {
            int actionNameResId = acitonNameArray[i];
            SelectItemBean itemBean = new SelectItemBean(iconArray.get(i),
                    this.getString(actionNameResId), actionNameResId);
            Log.d(TAG, "initData: itemBean: " + itemBean);
            data.add(itemBean);
        }

        return data;
    }

    private BaseAdapter createAndConfigAdapter(Context context, List<SelectItemBean> data) {
        mAdapter = new MonitorListViewAdapter(context, data);
        mListView.setAdapter(mAdapter);
        return mAdapter;
    }

    private void doShareApk() {
        Log.d(TAG, "doShareApk: ");
//        Intent shareIntent = new Intent(this, ShareActivity.class);
//        startActivity(shareIntent);
//        Toast.makeText(getActivity(), "hehehe", Toast.LENGTH_SHORT).show();
    }
}


