package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //完成了布局文件的加载
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.btn_lv);
        setOnClickListener();
    }

    private void setOnClickListener(){
        OnClick onClick = new OnClick();
        lv.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_lv:
                    intent = new Intent(MainActivity.this,ListViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
