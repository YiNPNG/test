package com.example.dell.mytextapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.mytextapplication.circlemenu.view.CircleImageView;
import com.example.dell.mytextapplication.circlemenu.view.CircleLayout;
import com.example.dell.mytextapplication.circlemenu.view.CircleLayout.OnItemClickListener;
import com.example.dell.mytextapplication.circlemenu.view.CircleLayout.OnItemSelectedListener;
import com.example.dell.mytextapplication.online.WebVideo;
import com.example.dell.mytextapplication.util.AppLog;


import android.content.Intent;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener, OnItemClickListener {
    TextView selectedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppLog.enableLogging(true);
        CircleLayout circleMenu = (CircleLayout)findViewById(R.id.main_circle_layout);
        circleMenu.setOnItemSelectedListener(this);
        circleMenu.setOnItemClickListener(this);

        selectedTextView = (TextView)findViewById(R.id.main_selected_textView);
        selectedTextView.setText(((CircleImageView)circleMenu.getSelectedItem()).getName());
    }

    @Override
    public void onItemSelected(View view, int position, long id, String name) {
        selectedTextView.setText(name);
    }

    @Override
    public void onItemClick(View view, int position, long id, String name) {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.start_app) + " " + name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        switch(position){
            case 0:
                intent.setClass(MainActivity.this, JieVideo.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(MainActivity.this, WebVideo.class);
                startActivity(intent);
                break;
        }
    }

}
