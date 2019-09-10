package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv = findViewById(R.id.lv);
        //在Android中组件分为:基本组件、布局组件(布局组件可以添加子组件),布局组件都继承了ViewGroup
        //lv.addView(new Button(this));不支持,会抛出异常。
        //所有继承了AdapterView的组件都要采用适配器设计模式
        lv.setAdapter(new MyListAdapter(ListViewActivity.this));//适配器都可以用来提升性能
    }
}
