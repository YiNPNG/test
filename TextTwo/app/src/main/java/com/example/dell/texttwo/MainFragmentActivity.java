package com.example.dell.texttwo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.texttwo.FragmentFile;

import java.util.ArrayList;
import java.util.List;


public class MainFragmentActivity extends FragmentActivity {

    private View view1,view2;
    private List<View> viewList;
    private ViewPager mPager;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        mPager = (ViewPager) findViewById(R.id.pager);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.fragment_file,null);
        view2 = inflater.inflate(R.layout.fragment_online,null);

        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);

        titleList = new ArrayList<String>();
        titleList.add("本地视频");
        titleList.add("网络视频");
        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));

                return viewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {

                return titleList.get(position);
            }
        };

        mPager.setAdapter(pagerAdapter);
    }
}