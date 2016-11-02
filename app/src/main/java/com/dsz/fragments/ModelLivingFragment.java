package com.dsz.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.dsz.activity.R;
import com.dsz.adapter.AddModelAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/13.
 */
public class ModelLivingFragment extends Fragment implements AdapterView.OnItemClickListener {
    private static final String TAG = "ModelLivingFragment";
    private ListView mListView = null;
    private Button fragment_add_model_text = null;
    private AddModelAdapter mAdapter = null;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= View.inflate(getActivity(), R.layout.fragment_add_model,null);
        Log.d(TAG, "onCreate: ");

        fragment_add_model_text = (Button) view.findViewById(R.id.fragment_add_model_text);
        fragment_add_model_text.setOnClickListener(new addTextListener());
        mListView = (ListView) view.findViewById(R.id.fragment_add_model_listview);
        if (mListView != null) {
            mListView.setOnItemClickListener(this);
        }
        configListView();

        return view;
    }




    private void configListView() {
        createAndConfigAdapter(getActivity(), initData());
    }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    private List<Map<String, Object>> initData() {
        Map<String, Object> map;
        for(int i=0;i<5;i++)
        {
            map = new HashMap<String, Object>();
            map.put("img", R.mipmap.view_icon_01_nor);
            map.put("title", "跆拳道");
            map.put("info", "快乐源于生活...");
            list.add(map);
        }
        return list;
    }

    private BaseAdapter createAndConfigAdapter(Context context, List<Map<String, Object>> data) {
        mAdapter = new AddModelAdapter(context, data);
        mListView.setAdapter(mAdapter);
        return mAdapter;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    private class addTextListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            createAndConfigAdapter(getActivity(), initData());
        }
    }
}


