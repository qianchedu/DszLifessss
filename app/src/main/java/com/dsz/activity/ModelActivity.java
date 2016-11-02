package com.dsz.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dsz.adapter.ModelListViewAdapter;
import com.dsz.bean.ModelAddName;
import com.dsz.db.ModelAddDB;

import java.util.List;


/**
 * Created by Administrator on 2016/10/12.
 */
public class ModelActivity extends Activity {

    private TextView id_model;
    private ImageView model_back;
    private TextView model_main;
//    private AddNameSql addNameSql;
    private ModelAddDB modelAddDB;
    ModelListViewAdapter modelListViewAdapter;

    ListView listView;

//    List<AddNameBean> listAddName;
//    AddNameBean addNameBean;
    List<ModelAddName> listAddModelName;



    ModelAddName modelAddName;

    private boolean delState=false;
    private int lastPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        model_back = (ImageView) findViewById(R.id.mode1_back);//情景模式返回键
        model_main = (TextView) findViewById(R.id.mode1_main);//情景模式主页键
        model_back.setOnClickListener(new model_backOnclicklistener());
        model_main.setOnClickListener(new model_mainOnclicklistener());
        listView = (ListView) findViewById(R.id.model_msg_listview);

        modelAddDB = new ModelAddDB(ModelActivity.this);

//        addNameSql = new AddNameSql(this);
//        addNameSql.open();

//        listAddName = addNameSql.getAllRestaurants();
//
//        modelListViewAdapter = new ModelListViewAdapter(this,listAddName);

        listAddModelName =modelAddDB.getAllModel();




        modelListViewAdapter = new ModelListViewAdapter(this,listAddModelName);


        listView.setAdapter(modelListViewAdapter);

//        listView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ModelActivity.this, "nihao", Toast.LENGTH_SHORT).show();
//            }
//        });





        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            private View deleview;
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                Toast.makeText(ModelActivity.this, ":" + modelListViewAdapter.getItem(position), Toast.LENGTH_SHORT).show();
                Toast.makeText(ModelActivity.this, ":" + position, Toast.LENGTH_SHORT).show();


                if (delState) {
                    if (lastPress < parent.getCount()) {
                        View delview = parent.getChildAt(lastPress).findViewById(R.id.model_dele_layout);
                        if (null != delview) {
                            delview.setVisibility(View.GONE);
                        }
                    }
                    delState = false;
                }
                if (lastPress < parent.getCount()) {
                    deleview = parent.getChildAt(position).findViewById(R.id.model_dele_layout);
                    if (null != deleview) {
                        deleview.setVisibility(View.GONE);
                    }
                }
                deleview = parent.getChildAt(position).findViewById(R.id.model_dele_layout);
                deleview.setVisibility(View.VISIBLE);

                deleview.findViewById(R.id.model_cancel_sb).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleview.setVisibility(View.GONE);
                        //adapter.notifyDataSetChanged();
                    }
                });
                ;
                deleview.findViewById(R.id.model_dele_sb).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        deleview.setVisibility(View.GONE);
//                            dbcon.initDB(mylist,KETING);
//                        long id = listAddName.get(position).getId();
//                        addNameSql.deleteRestaurant(id);
                        //dbcon.getData();


                        int deleteID = listAddModelName.get(position).getModelID();

                        ModelAddName mo = new ModelAddName(deleteID);

                        modelAddDB.deleteModel(mo);

                        listAddModelName =modelAddDB.getAllModel();
                        modelListViewAdapter = new ModelListViewAdapter(ModelActivity.this,listAddModelName);
                        listView.setAdapter(modelListViewAdapter);

                        Toast.makeText(ModelActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();

                        modelListViewAdapter.notifyDataSetChanged();
                    }
                });



                delState = true;
                lastPress = position;

                return true;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }



    //情景模式返回键
    class model_backOnclicklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            finish();
        }
    }

    //情景模式主页键
    class model_mainOnclicklistener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(ModelActivity.this,AddModelActivity.class);
            startActivity(intent);
//            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        addNameSql = new AddNameSql(this);
//        addNameSql.open();

//        listRestaurant = datasource.getAllRestaurants();
//        listAddName = addNameSql.getAllRestaurants();

        modelAddDB = new ModelAddDB(this);
        listAddModelName = modelAddDB.getAllModel();



        modelListViewAdapter = new ModelListViewAdapter(this,listAddModelName);

        listView.setAdapter(modelListViewAdapter);
    }


    @Override
    protected void onRestart() {
//        arrayAdapter.notifyDataSetChanged();
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
