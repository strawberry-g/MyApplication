package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.User;

import java.util.ArrayList;
import java.util.List;

//ListView的数据适配功能
public class MyListAdapter extends BaseAdapter {
    //正常数据从后台获取,此处先模拟搭建模式
    private Context context;
    private LayoutInflater layoutInflater;
    private List<User> userList = new ArrayList<>();

    public MyListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        for (int i = 1;i <= 20;i++){
            userList.add(new User("雅俗共赏","VAE","2016-06-27"));
        }
    }

    //返回数据大小
    @Override
    public int getCount() {
        return userList.size();
    }

    //返回要显示结果,i:当前数据下标(0,1,2...)
    @Override
    public Object getItem(int i) {
        Log.d("gp","i:" + i);
        return userList.get(i);
    }

    //返回当前记录的主键
    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
    }

    //返回ListView中要显示的视图View:lv_item
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        //获取每个要显示的数据(i)
        User user = (User) getItem(i);
        //获取要显示的ListItem,并且存储数据至item布局文件中
        //View.inflate(ListViewActivity.this,R.layout.layout_lv_item,null);
        if (view == null){
            //视图绑定 inflate:第一个参数：想要添加的布局、第二个参数：想要添加到哪个布局上面
            view = layoutInflater.inflate(R.layout.layout_lv_item,null);

            viewHolder = new ViewHolder();
            viewHolder.tv1 = view.findViewById(R.id.lv_tv1);
            viewHolder.tv2 = view.findViewById(R.id.lv_tv2);
            viewHolder.tv3 = view.findViewById(R.id.lv_tv3);
            //存储view的数据 setTag()是把Object对象作为参数对view进行存储的
            view.setTag(viewHolder);
        }
        else {
            //第二次使用的时候就可以通过getTag()把holder取出来直接使用
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv1.setText(user.getTitle());
        viewHolder.tv2.setText(user.getName());
        viewHolder.tv3.setText(user.getDate());

        return view;
    }
}
