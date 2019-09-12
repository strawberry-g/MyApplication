package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private Button lv;
    private RadioButton rd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //完成了布局文件的加载
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.btn_lv);
        setOnClickListener();

        rd = findViewById(R.id.first);
        rd.setChecked(true);

        //rg = findViewById(R.id.rg);
        /*rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                final RadioButton radioButton = radioGroup.findViewById(i);
                radioButton.setFocusableInTouchMode(true);
                radioButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View view, boolean b) {
                        if (b){
                            radioButton.setTextColor(getResources().getColor(R.color.colorIcon));
                        }
                        else{
                            radioButton.setTextColor(getResources().getColor(R.color.colorGrey));
                        }
                    }
                });

                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        radioButton.setFocusable(false);
                    }
                });
            }
        });*/
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
