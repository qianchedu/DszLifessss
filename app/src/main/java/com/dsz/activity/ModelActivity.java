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
import com.dsz.bean.AddNameBean;
import com.dsz.db.AddNameSql;

import java.util.List;


/**
 * Created by Administrator on 2016/10/12.
 */
public class ModelActivity extends Activity {

    private TextView id_model;
    private ImageView model_back;
    private TextView model_main;
    private AddNameSql addNameSql;
    ModelListViewAdapter modelListViewAdapter;

    ListView listView;
    List<AddNameBean> listAddName;
    AddNameBean addNameBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        model_back = (ImageView) findViewById(R.id.mode1_back);//情景模式返回键
        model_main = (TextView) findViewById(R.id.mode1_main);//情景模式主页键
        model_back.setOnClickListener(new model_backOnclicklistener());
        model_main.setOnClickListener(new model_mainOnclicklistener());
        listView = (ListView) findViewById(R.id.model_msg_listview);

        addNameSql = new AddNameSql(this);
        addNameSql.open();

        listAddName = addNameSql.getAllRestaurants();

        modelListViewAdapter = new ModelListViewAdapter(this,listAddName);

        listView.setAdapter(modelListViewAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ModelActivity.this, ":" + modelListViewAdapter.getItem(position), Toast.LENGTH_SHORT).show();

                return true;
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
        addNameSql = new AddNameSql(this);
        addNameSql.open();

//        listRestaurant = datasource.getAllRestaurants();
        listAddName = addNameSql.getAllRestaurants();



        modelListViewAdapter = new ModelListViewAdapter(this,listAddName);

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
