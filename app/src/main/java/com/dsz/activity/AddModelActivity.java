package com.dsz.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.dsz.adapter.ModelFragmentAdapter;
import com.dsz.bean.AddNameBean;
import com.dsz.db.AddNameSql;
import com.dsz.widget.SelfDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/10/19.
 */
public class AddModelActivity extends FragmentActivity implements View.OnClickListener {
//    RestaurantModel obj = new RestaurantModel();
    AddNameBean addNameBean = new AddNameBean();
    private AddNameSql addNameSql;
    ArrayAdapter<AddNameBean> addArray;

    public static final int TAB_LIVING_ROOM = 0;
    public static final int TAB_MASTER_ROOM = 1;
    public static final int TAB_KITCHEN = 2;
    public static final int TAB_SECOND_ROOM = 3;
    public static final int TAB_OTHER = 4;


    private ViewPager addModelViewPager;
    private RadioButton livingRoom, masterRoom, kitChen, secondRoom, other;

    private ImageView model_back_iv;
    private Button model_main_btn;
    private Context context;


    private ListView listView;
    private List<Map<String, Object>> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_model_add);


        context = AddModelActivity.this;
        initView(); //初始化布局文件
        initEvents();
        addListener();  //事件监听


//        listView = (ListView) findViewById(R.id.add_model_listview);
//        data = getData();
//        AddModelAdapter addModelAdapter = new AddModelAdapter(this,data);
//        listView.setAdapter(addModelAdapter);
    }

    private void initEvents() {
        livingRoom.setOnClickListener(this);
//        qita.setOnClickListener(this);
        masterRoom.setOnClickListener(this);
        kitChen.setOnClickListener(this);
        secondRoom.setOnClickListener(this);
        other.setOnClickListener(this);

        model_back_iv.setOnClickListener(this);
        model_main_btn.setOnClickListener(this);

        ModelFragmentAdapter adapter = new ModelFragmentAdapter(
                getSupportFragmentManager());
        addModelViewPager.setAdapter(adapter);
    }

    private void addListener() {
        addModelViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("NewApi")
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case TAB_LIVING_ROOM:
                        livingRoom.setChecked(true);
                        livingRoom.setBackground(context.getDrawable(R.mipmap.blue_down));
                        masterRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        kitChen.setBackground(context.getDrawable(R.mipmap.empty));
                        secondRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        other.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        livingRoom.setTextColor(context.getResources().getColor(R.color.text_on));
                        masterRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        kitChen.setTextColor(context.getResources().getColor(R.color.text_off));
                        secondRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        other.setTextColor(context.getResources().getColor(R.color.text_off));
//                        qita.setTextColor(context.getResources().getColor(R.color.text_off));
                        break;


                    case TAB_MASTER_ROOM:
                        masterRoom.setChecked(true);
                        livingRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        masterRoom.setBackground(context.getDrawable(R.mipmap.blue_down));
                        kitChen.setBackground(context.getDrawable(R.mipmap.empty));
                        secondRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        other.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        livingRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        masterRoom.setTextColor(context.getResources().getColor(R.color.text_on));
                        kitChen.setTextColor(context.getResources().getColor(R.color.text_off));
                        secondRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        other.setTextColor(context.getResources().getColor(R.color.text_off));
//

                        break;
                    case TAB_KITCHEN:
                        kitChen.setChecked(true);
                        livingRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        masterRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        kitChen.setBackground(context.getDrawable(R.mipmap.blue_down));
                        secondRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        other.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        livingRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        masterRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        kitChen.setTextColor(context.getResources().getColor(R.color.text_on));
                        secondRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        other.setTextColor(context.getResources().getColor(R.color.text_off));
//

                        break;
                    case TAB_SECOND_ROOM:
                        secondRoom.setChecked(true);
                        livingRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        masterRoom.setBackground(context.getDrawable(R.mipmap.blue_down));
                        kitChen.setBackground(context.getDrawable(R.mipmap.empty));
                        secondRoom.setBackground(context.getDrawable(R.mipmap.blue_down));
                        other.setBackground(context.getDrawable(R.mipmap.empty));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        livingRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        masterRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        kitChen.setTextColor(context.getResources().getColor(R.color.text_off));
                        secondRoom.setTextColor(context.getResources().getColor(R.color.text_on));
                        other.setTextColor(context.getResources().getColor(R.color.text_off));
//

                        break;
                    case TAB_OTHER:
                        other.setChecked(true);
                        livingRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        masterRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        kitChen.setBackground(context.getDrawable(R.mipmap.empty));
                        secondRoom.setBackground(context.getDrawable(R.mipmap.empty));
                        other.setBackground(context.getDrawable(R.mipmap.blue_down));
//                        qita.setBackground(context.getDrawable(R.drawable.empty));
                        livingRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        masterRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        kitChen.setTextColor(context.getResources().getColor(R.color.text_off));
                        secondRoom.setTextColor(context.getResources().getColor(R.color.text_off));
                        other.setTextColor(context.getResources().getColor(R.color.text_on));
//

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        addNameSql = new AddNameSql(AddModelActivity.this);
        addNameSql.open();
        List<AddNameBean> listBean = addNameSql.getAllRestaurants();
        addArray = new ArrayAdapter<AddNameBean>(this, android.R.layout.simple_list_item_1, listBean);
        model_back_iv = (ImageView) findViewById(R.id.add_model_back_imageview);
        model_main_btn = (Button) findViewById(R.id.add_model_confirm_btn);


//        textTitle=(TextView)findViewById(R.id.title_txt);
        addModelViewPager = (ViewPager) findViewById(R.id.add_model_viewpager);

        livingRoom = (RadioButton) findViewById(R.id.add_model_living_room_radiobutton);
        masterRoom = (RadioButton) findViewById(R.id.add_model_master_room_radiobutton);
        kitChen = (RadioButton) findViewById(R.id.add_model_kitchen_radiobutton);
        secondRoom = (RadioButton) findViewById(R.id.add_model_second_room_radiobutton);
        other = (RadioButton) findViewById(R.id.add_model_other_radiobutton);
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<>();
            map.put("img", R.mipmap.view_icon_01_nor);
            map.put("title", "跆拳道");
            map.put("info", "shishsi");
            list.add(map);
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_model_living_room_radiobutton:
                addModelViewPager.setCurrentItem(TAB_LIVING_ROOM);
                break;
            case R.id.add_model_master_room_radiobutton:
                addModelViewPager.setCurrentItem(TAB_MASTER_ROOM);
                break;
            case R.id.add_model_kitchen_radiobutton:
                addModelViewPager.setCurrentItem(TAB_KITCHEN);
                break;
            case R.id.add_model_second_room_radiobutton:
                addModelViewPager.setCurrentItem(TAB_SECOND_ROOM);
                break;

            case R.id.add_model_other_radiobutton:
                addModelViewPager.setCurrentItem(TAB_OTHER);
                break;


            case R.id.add_model_back_imageview:
//                Log.d("haocan","haocan");
                finish();
//                Intent intent = new Intent(AddModelActivity.this,ModelActivity.class);
//                startActivity(intent);
                break;

            case R.id.add_model_confirm_btn:
                confirmDialog();
//                finish();
                break;

            default:
                break;
        }

    }
//    String d;
    private SelfDialog selfDialog;
    private void confirmDialog() {


        selfDialog = new SelfDialog(context);
//                selfDialog.setTitle("提示");
//        selfDialog.setMessage("情景模式名称");
        selfDialog.setYesOnclickListener("确定", new SelfDialog.onYesOnclickListener() {
            @Override
            public void onYesClick(final String txt) {
                 String name =selfDialog.getTxt();
//                Log.d(d + "rentg",d + "hao");
                if(name.equals("") || name == null){
                    Toast.makeText(getBaseContext(),"请输入名称",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getBaseContext(),"添加" + name + "成功",Toast.LENGTH_LONG).show();
                    addNameBean = addNameSql.createRestaurant(name);


//                            obj = datasource.createRestaurant(user,address , typeGroup.getCheckedRadioButtonId());
//                    toast = Toast.makeText(context, edtName.getText().toString() + " has been inserted", Toast.LENGTH_SHORT);
//                    toast.show();
//                            Toast.makeText(SaveActivity.this, "nahoa" +address, Toast.LENGTH_SHORT).show();
                    addArray.add(addNameBean);

                    selfDialog.dismiss();
                }

            }
        });
        selfDialog.setNoOnclickListener("取消", new SelfDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                Toast.makeText(getBaseContext(),"点击了--取消--按钮",Toast.LENGTH_LONG).show();
                selfDialog.dismiss();
            }
        });
        selfDialog.show();


//        Toast.makeText(context, d, Toast.LENGTH_SHORT).show();


//        LayoutInflater inflater = getLayoutInflater();
//        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
//        final EditText etUsername = (EditText) alertLayout.findViewById(R.id.et_username);
//        final EditText etPassword = (EditText) alertLayout.findViewById(R.id.et_password);
//        final CheckBox cbShowPassword = (CheckBox) alertLayout.findViewById(R.id.cb_show_password);
//
//        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    // to encode password in dots
//                    etPassword.setTransformationMethod(null);
//                } else {
//                    // to display the password in normal text
//                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                }
//            }
//        });
//
//        @SuppressLint("NewApi")
//        AlertDialog.Builder alert = new AlertDialog.Builder(this,R.style.bg_color);
//        alert.setTitle("请输入模式名称");
//
//        // this is set the view from XML inside AlertDialog
//        alert.setView(alertLayout);
//
//        // disallow cancel of AlertDialog on click of back button and outside touch
//        alert.setCancelable(true);
//        alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String user = etUsername.getText().toString();
//                String pass = etPassword.getText().toString();
//                Toast.makeText(getBaseContext(), "添加数据成功", Toast.LENGTH_SHORT).show();
////                            Intent in = new Intent();
////                            in.putExtra("user",user);
////                            addNameSql = new AddNameSql(SaveActivity.this);
////                            addNameSql.open();
//
//                addNameBean = addNameSql.createRestaurant(user);
//
//
////                            obj = datasource.createRestaurant(user,address , typeGroup.getCheckedRadioButtonId());
////                    toast = Toast.makeText(context, edtName.getText().toString() + " has been inserted", Toast.LENGTH_SHORT);
////                    toast.show();
////                            Toast.makeText(SaveActivity.this, "nahoa" +address, Toast.LENGTH_SHORT).show();
//                addArray.add(addNameBean);
//
//
//            }
//        });
//        AlertDialog dialog = alert.create();
//        dialog.show();

    }
}
