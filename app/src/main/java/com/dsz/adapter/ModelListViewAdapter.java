package com.dsz.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dsz.activity.R;
import com.dsz.bean.ModelAddName;
import com.dsz.db.ModelAddDB;
import com.dsz.widget.SwitchButton;

import java.util.List;


/**
 * the adpater for selecting base tools item.
 */
public class ModelListViewAdapter extends BaseAdapter {
    private static final String TAG = "Cloudy/SelectAdapter";

    private Context mContext = null;
    //    private List<AddNameBean> mData = null;
    private List<ModelAddName> mData = null;
    private ModelAddName modelAddName;
    private Dialog dialog;

    private boolean isOpens;
    private ModelAddDB modelAddDB;
    public int modelID;

    ViewHolder viewHolder;
    Bitmap bitmap_nor;
    Bitmap bitmap_sel;
//    public ModelListViewAdapter(Context Context, List<AddNameBean> Data) {
//        mContext = Context;
//        mData = Data;
//        bitmap_nor = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.monitor_select_image);
//        bitmap_sel = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.view_button_01_sel);
//
//    }

    public ModelListViewAdapter(Context Context, List<ModelAddName> data) {
        mContext = Context;
        mData = data;
        bitmap_nor = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.monitor_select_image);
        bitmap_sel = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.view_button_01_sel);


    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(ModelAddName itemBean) {
        mData.add(itemBean);
    }

    public void remove(ModelAddName itemBean) {
        mData.remove(itemBean);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: position: " + position);
        View view = null;
        modelAddDB = new ModelAddDB(mContext);
        modelID = ((ModelAddName) getItem(position)).getModelID();
        viewHolder = new ViewHolder();

        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.model_listview, null);
            viewHolder.iconView = (ImageView) view.findViewById(R.id.add_model_icon_imageView);
            viewHolder.naneTV = (TextView) view.findViewById(R.id.add_model_txt_textview);
//            viewHolder.add_model_msg_switchbutton = (ImageView) view.findViewById(R.id.add_model_msg_switchbutton);
            viewHolder.switchButton = (SwitchButton) view.findViewById(R.id.add_model_msg_switchbutton);
            viewHolder.model_dele_layout = (RelativeLayout) view.findViewById(R.id.model_dele_layout);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.iconView.setImageResource(R.mipmap.view_icon_01_nor);
//        viewHolder.mode1_switch4.setImageResource(R.drawable.model_open);
//        viewHolder.naneTV.setText(((AddNameBean) getItem(position)).getName());
        viewHolder.naneTV.setText(((ModelAddName) getItem(position)).getModelName());

//        modelAddName = (ModelAddName) getItem(position);

//        Toast.makeText(mContext, "modelID:" + modelID, Toast.LENGTH_SHORT).show();

//        boolean fi =

//        modelAddDB.getAllModel();

        viewHolder.switchButton.setSwitchID(((ModelAddName) getItem(position)).getModelID());




        isOpens = ((ModelAddName) getItem(position)).isModelFlag();        //可以修改这里来给变switchButton的状态

//        isOpens = true;
        if (isOpens) {
            // //设置滑动图片资源
            // // 设置背景图片资源
            viewHolder.switchButton.setSlideBackground(R.mipmap.switch_bg_on);
            viewHolder.switchButton.setSlideImage(R.mipmap.switch_slide_on);
//            viewHolder.switchButton.setSlideImage(R.drawable.view_button_01_sel);
            viewHolder.switchButton.setOpened(isOpens);
//            Toast.makeText(mContext, "isOpens:" + isOpens, Toast.LENGTH_SHORT).show();
            //
        } else {
            // //设置滑动图片资源
            // // 设置背景图片资源
            viewHolder.switchButton.setSlideBackground(R.mipmap.switch_bg_off);
            viewHolder.switchButton.setSlideImage(R.mipmap.switch_slide_off);
            viewHolder.switchButton.setOpened(isOpens);
//            Toast.makeText(mContext, "isOpens:" + isOpens, Toast.LENGTH_SHORT).show();
//            viewHolder.switchButton.setSlideImage(R.drawable.view_button_01_nor);
            //
        }


//        viewHolder.switchButton.setId(position);



        //给滑动图片设置监听
        viewHolder.switchButton.setOnToggleListener(new SwitchButton.OnToggleListener() {

            @Override
            public void onToggleChanged(SwitchButton view, boolean isOpened) {
                int updateID = view.getSwitchID();      //获取view的下标

                if (isOpened) {
                    //设置滑动图片资源
                    // 设置背景图片资源
                    view.setSlideBackground(R.mipmap.switch_bg_on);
                    view.setSlideImage(R.mipmap.switch_slide_on);

                    ModelAddName update = new ModelAddName(updateID,true);

                    modelAddDB.updateModel(update);
                    Toast.makeText(mContext, "updateID:" + updateID, Toast.LENGTH_SHORT).show();

                } else {
                    //设置滑动图片资源
                    // 设置背景图片资源
                    view.setSlideBackground(R.mipmap.switch_bg_off);
                    view.setSlideImage(R.mipmap.switch_slide_off);
                    ModelAddName update = new ModelAddName(updateID,false);

                    modelAddDB.updateModel(update);

                }
            }

        });


        viewHolder.iconView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        viewHolder.naneTV.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                viewHolder.model_dele_layout.setVisibility(View.GONE);

                return false;
            }
        });

//        view.setOnLongClickListener(new View.OnLongClickListener() {
//
//            @Override
//            public boolean onLongClick(View v) {
//                viewHolder.model_dele_layout.setVisibility(View.GONE);
//                return true;
//            }
//        });

        return view;
    }


    class ViewHolder {
        //        public ImageView iconView;
        public ImageView iconView;
        //        public ImageView mode1_switch4;
        public SwitchButton switchButton;
        //        public ImageView add_model_msg_switchbutton;
        public TextView naneTV;

        public RelativeLayout model_dele_layout;

    }


}
