package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.myapplication.adapter.WelcomePageAdapter;

public class WelcomeActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setContentView(R.layout.start_main);

        //绑定组件
        initView();
        //初始化数据
        initData();

    }

    public void goMainActivity(View view){
        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
    }

    private void initView(){
        viewPager = findViewById(R.id.viewpager);
    }

    private void initData(){
        viewPager.setAdapter(new WelcomePageAdapter(WelcomeActivity.this));
    }
}
