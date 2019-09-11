package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

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
        //适配器都可以用来提升性能
        //lv.setAdapter(new MyListAdapter(ListViewActivity.this));

        //自定义添加
        //lv.setAdapter(new TestAdapter(ListViewActivity.this));
        //远程获取
        this.getServletData("http://192.168.1.158:8080/appser/servlet/AjaxServlet");
    }

    public void getServletData(String url){
        RequestParams params =new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            //请求成功
            @Override
            public void onSuccess(String result) {
                //先把字符串转回为json格式
                Gson gson = new Gson();
                List<User> userList = gson.fromJson(result,new TypeToken<List<User>>(){}.getType());
                lv = findViewById(R.id.lv);
                lv.setAdapter(new DataAdapter(userList));
            }

            //请求失败
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }

            //请求取消
            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(x.app(), "cancelled", Toast.LENGTH_LONG).show();
            }

            //请求完成(成功或失败,用于释放资源)
            @Override
            public void onFinished() {
            }
        });
    }

    private class DataAdapter extends BaseAdapter{
        private List<User> userList = null;

        public DataAdapter(List<User> userList) {
            this.userList = userList;
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
                view1 = View.inflate(ListViewActivity.this,R.layout.layout_lv_item,null);
            }

            TextView tv1 = view1.findViewById(R.id.lv_tv1);
            TextView tv2 = view1.findViewById(R.id.lv_tv2);
            TextView tv3 = view1.findViewById(R.id.lv_tv3);
            tv1.setText(user.getTitle());
            tv2.setText(user.getName());
            tv3.setText(user.getDate());

            return view1;
        }
    }
}

