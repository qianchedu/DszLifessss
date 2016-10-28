package com.dsz.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsz.activity.R;

/**
 * Created by Administrator on 2016/10/13.
 */
public class QiTaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= View.inflate(getActivity(), R.layout.fragment_guide_qita,null);

        return view;
    }
}
