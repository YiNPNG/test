package com.example.dell.textfour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.dell.textfour.R;

import io.vov.vitamio.widget.VideoView;

/**
 * Created by DELL on 2017/5/3.
 */

public class MyFragment1 extends Fragment {
    private Button fragment_click;

    //原本的
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_file,container,false);
        fragment_click = (Button) view.findViewById(R.id.fragment_click);
        fragment_click.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent_1 = new Intent(getActivity(),VideoView.class);
                //启动
                startActivity(intent_1);
            }
        });
        return view;
    }
    //原本的

}
