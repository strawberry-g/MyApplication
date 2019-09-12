package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.User;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList = new ArrayList<>();

    public TestAdapter(Context context) {
        this.context = context;
        for (int i = 1;i <= 20;i++){
            userList.add(new User("雅俗共赏","VAE","2016-06-27"));
        }
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        User user = (User) getItem(i);
        View view1 = null;

        if (view != null){
            view1 = view;
        }
        else{
            view1 = LayoutInflater.from(context).inflate(R.layout.layout_lv_item,null);
        }

        //TextView tv1 = view1.findViewById(R.id.lv_tv1);
        TextView tv2 = view1.findViewById(R.id.lv_tv2);
        TextView tv3 = view1.findViewById(R.id.lv_tv3);
        //tv1.setText(user.getTitle());
        tv2.setText(user.getName());
        tv3.setText(user.getDate());

        return view1;
    }
}
