package com.dsz.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsz.activity.R;
import com.dsz.bean.AddNameBean;
import com.dsz.utils.ScalableImageView;
import com.dsz.widget.SwitchButton;

import java.util.List;


/**
 * the adpater for selecting base tools item.
 */
public class ModelListViewAdapter extends BaseAdapter {
    private static final String TAG = "Cloudy/SelectAdapter";

    private Context mContext = null;
    private List<AddNameBean> mData = null;
    private Dialog dialog;

    private boolean isOpens;
    ///
    private int screenWidth;
    private int screenHeight;
    private int bitmapWidth;
    private int bitmapHeight;
    private float baseScale;
    private float originalScale;
    ViewHolder viewHolder;
    Bitmap bitmap_nor;
    Bitmap bitmap_sel;
    //
    public ModelListViewAdapter(Context Context, List<AddNameBean> Data) {
        mContext = Context;
        mData = Data;
        create();
         bitmap_nor = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.monitor_select_image);
        bitmap_sel = BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.view_button_01_sel);

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

    public void add(AddNameBean itemBean) {
        mData.add(itemBean);
    }

    public void remove(AddNameBean itemBean) {
        mData.remove(itemBean);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: position: " + position);
        View view = null;
        viewHolder = new ViewHolder();

        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.model_listview, null);
            viewHolder.iconView = (ImageView) view.findViewById(R.id.add_model_icon_imageView);
            viewHolder.actionView = (TextView) view.findViewById(R.id.add_model_txt_textview);
//            viewHolder.add_model_msg_switchbutton = (ImageView) view.findViewById(R.id.add_model_msg_switchbutton);
            viewHolder.switchButton = (SwitchButton) view.findViewById(R.id.add_model_msg_switchbutton);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.iconView.setImageResource(R.mipmap.view_icon_01_nor);
//        viewHolder.mode1_switch4.setImageResource(R.drawable.model_open);
        viewHolder.actionView.setText(((AddNameBean) getItem(position)).getName());

//        isOpens = true;
//
////        viewHolder.add_model_msg_switchbutton.setImageBitmap(bitmap);
//        if(isOpens){
//            viewHolder.add_model_msg_switchbutton.setImageBitmap(bitmap_sel);
//        }else{
//            viewHolder.add_model_msg_switchbutton.setImageBitmap(bitmap_nor);
//        }
//
//
//        viewHolder.add_model_msg_switchbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "ND", Toast.LENGTH_SHORT).show();
////                Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.view_button_01_nor);
//                isOpens = false;
//                viewHolder.add_model_msg_switchbutton.setImageBitmap(bitmap_nor);
//            }
//        });



        isOpens = true;        //可以修改这里来给变switchButton的状态

        if (isOpens) {
            // //设置滑动图片资源
            // // 设置背景图片资源
            viewHolder.switchButton.setSlideBackground(R.mipmap.switch_bg_on);
            viewHolder.switchButton.setSlideImage(R.mipmap.switch_slide_on);
//            viewHolder.switchButton.setSlideImage(R.drawable.view_button_01_sel);
            //
        } else {
            // //设置滑动图片资源
            // // 设置背景图片资源
            viewHolder.switchButton.setSlideBackground(R.mipmap.switch_bg_off);
            viewHolder.switchButton.setSlideImage(R.mipmap.switch_slide_off);
//            viewHolder.switchButton.setSlideImage(R.drawable.view_button_01_nor);
            //
        }


        viewHolder.switchButton.setOpened(isOpens);

        //给滑动图片设置监听
        viewHolder.switchButton.setOnToggleListener(new SwitchButton.OnToggleListener() {

            @Override
            public void onToggleChanged(SwitchButton view, boolean isOpened) {

                if(isOpened){
                    //设置滑动图片资源
                    // 设置背景图片资源
                    view.setSlideBackground(R.mipmap.switch_bg_on);
                    view.setSlideImage(R.mipmap.switch_slide_on);
//                    viewHolder.switchButton.setSlideImage(R.drawable.view_button_01_sel);

                }else{
                    //设置滑动图片资源
                    // 设置背景图片资源
                    view.setSlideBackground(R.mipmap.switch_bg_off);
                    view.setSlideImage(R.mipmap.switch_slide_off);
//                    viewHolder.switchButton.setSlideImage(R.drawable.view_button_01_nor);

                }
            }
        });




//        viewHolder.mode1_switch4.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "dadada", Toast.LENGTH_SHORT).show();
//
////                show();
//
//            }
//        });

        viewHolder.iconView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }


    class ViewHolder {
//        public ImageView iconView;
        public ImageView iconView;
//        public ImageView mode1_switch4;
        public SwitchButton switchButton;
//        public ImageView add_model_msg_switchbutton;
        public TextView actionView;

    }


    private void show() {
        dialog.show();
    }

    private void create() {
        dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.setContentView(R.layout.image_dialog);
        initImageView();
    }

    private void initImageView() {
        ScalableImageView image = (ScalableImageView) dialog.findViewById(R.id.image);
//        Display viewss = dialog.getWindow().getWindowManager().getDefaultDisplay();


        screenWidth =     1080;
        screenHeight =   1920;


        Log.d(TAG,screenWidth + "和");
        Log.d(TAG,screenHeight + "和");
        final Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.move_right_01);
        bitmapWidth = bitmap.getWidth();
        bitmapHeight = bitmap.getHeight();


        // 计算缩放比，因为如果图片的尺寸超过屏幕，那么就会自动匹配到屏幕的尺寸去显示。
        // 那么，我们就不知道图片实际上在屏幕上显示的宽高，所以先计算需要全部显示的缩放比，
        // 在去计算图片显示时候的实际宽高，然后，才好进行下一步的缩放。
        // 要不然，会导致缩小和放大没效果，或者内存泄漏等等
        float scaleX = screenWidth / (float) bitmapWidth;
        float scaleY = screenHeight / (float) bitmapHeight;
//        float scaleX =  (float) (bitmapWidth*(screenWidth/bitmapWidth));
//        float scaleY =  (float)(bitmapWidth*(screenHeight/bitmapWidth));;
        baseScale = Math.min(scaleX, scaleY);// 获得缩放比例最大的那个缩放比，即scaleX和scaleY中小的那个
        originalScale = baseScale;

        final Matrix matrix = new Matrix();
        matrix.setScale(originalScale, originalScale);
        // 关于setScale和preScale和postScale的区别以后再说
        // matrix.preScale(originalScale, originalScale);
        // matrix.postScale(originalScale, originalScale);
//        Bitmap bitmap2 = Bitmap
//                .createBitmap(bitmap, 0, 0, screenWidth, screenHeight, matrix, false);
  Bitmap bitmap2 = Bitmap
                .createBitmap(bitmap, 0, 0, bitmapWidth, bitmapHeight, matrix, false);


//        image.setImageResource(R.drawable.a);
        image.setImageBitmap(bitmap2);
        image.setOnClickListener(new ScalableImageView.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
    }


}
