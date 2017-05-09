package com.example.dell.mylastapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by DELL on 2017/5/3.
 */

public class MyFragment2 extends Fragment {
    private Button why_click_me_1,why_click_me_2,why_click_me_3,why_click_me_4,why_click_me_5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_online,null);
        why_click_me_1 = (Button) view.findViewById(R.id.why_click_me_1);
        why_click_me_2 = (Button) view.findViewById(R.id.why_click_me_2);
        why_click_me_3 = (Button) view.findViewById(R.id.why_click_me_3);
        why_click_me_4 = (Button) view.findViewById(R.id.why_click_me_4);
        why_click_me_5 = (Button) view.findViewById(R.id.why_click_me_5);

        ClickListener MyListener = new ClickListener();
        why_click_me_1.setOnClickListener(MyListener);
        why_click_me_2.setOnClickListener(MyListener);
        why_click_me_3.setOnClickListener(MyListener);
        why_click_me_4.setOnClickListener(MyListener);
        why_click_me_5.setOnClickListener(MyListener);

        return view;
    }
    private class ClickListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.why_click_me_1:
                    Toast.makeText(getActivity(),
                            "想着连网？", Toast.LENGTH_LONG).show();
                    break;
                case R.id.why_click_me_2:
                    Toast.makeText(getActivity(),
                            "想太多了！", Toast.LENGTH_LONG).show();
                    break;
                case R.id.why_click_me_3:
                    Toast.makeText(getActivity(),
                            "想连自己弄啊", Toast.LENGTH_LONG).show();
                    break;
                case R.id.why_click_me_4:
                    Toast.makeText(getActivity(),
                            "我不弄咯，心好累", Toast.LENGTH_LONG).show();
                    break;
                case R.id.why_click_me_5:
                    Toast.makeText(getActivity(),
                            "你开心就好", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }

        }
    }
}
