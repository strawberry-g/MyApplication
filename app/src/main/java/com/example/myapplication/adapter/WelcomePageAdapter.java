package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomePageAdapter extends PagerAdapter {
    private Context context;

    private int[] array = {R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3};
    //所有可视化图片都是View的子类
    private List<View> imageList = new ArrayList<>();

    public WelcomePageAdapter(Context context) {
        this.context = context;

        for (int i = 0;i<array.length;i++){
            ImageView imageView = new ImageView(context);
            //给ImageView添加图片
            imageView.setBackgroundResource(array[i]);
            imageList.add(imageView);
        }
        imageList.add(LayoutInflater.from(context).inflate(R.layout.start_main,null));
    }

    //定义图片集合的大小
    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //把ImageView交给ViewPager
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("image","ViewPager-->" + container + ",position-->" + position);
        View view = (View) imageList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Log.d("image","ViewPager-->" + container + ",object-->" + object);
        container.removeView((View) object);
    }
}
