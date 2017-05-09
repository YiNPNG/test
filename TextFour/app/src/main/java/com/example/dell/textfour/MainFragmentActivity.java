package com.example.dell.textfour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainFragmentActivity extends FragmentActivity {

    private View view1, view2;
    private List<View> pageList;
    private ViewPager mPager;
    private MyPagerAdapter myPagerAdapter;
    private RadioButton bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        // ~~~~~~ 绑定控件
        //mPager = (ViewPager) findViewById(R.id.pager);
        initView();
        bt1 = (RadioButton) findViewById(R.id.radio_file);
        bt2 = (RadioButton) findViewById(R.id.radio_online);


        // ~~~~~~ 绑定事件
        ButtonListener MyListener = new ButtonListener();
        bt1.setOnClickListener(MyListener);
        bt2.setOnClickListener(MyListener);

        PageChangeListener MyPageChangeListener = new PageChangeListener();
        mPager.addOnPageChangeListener(MyPageChangeListener);

        //mPager.setOnPageChangeListener(MyPageChangeListener);
        //调用setOnPageChangeListener()时会出现一个删除线，告诉调用者，该方法可以调用，但不是最佳实践。


    }

    private class ButtonListener implements View.OnClickListener {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.radio_file:
                    mPager.setCurrentItem(0);
                    break;
                case R.id.radio_online:
                    mPager.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        }
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    bt1.setBackgroundResource(R.drawable.home_bg_checked);
                    bt2.setBackgroundResource(R.drawable.home_bg_normal);
                    break;
                case 1:
                    bt2.setBackgroundResource(R.drawable.home_bg_checked);
                    bt1.setBackgroundResource(R.drawable.home_bg_normal);
                    break;
                default:
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private void initView() {
        mPager = (ViewPager) findViewById(R.id.pager);

        MyFragment1 myFragment1 = new MyFragment1();
        MyFragment2 myFragment2 = new MyFragment2();

        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        // ~~~~~~ 绑定数据
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragmentList);
        mPager.setAdapter(myFragmentAdapter);
    }

}
