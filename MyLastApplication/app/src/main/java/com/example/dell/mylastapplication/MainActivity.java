package com.example.dell.mylastapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //屏蔽真机的menu来显示右边overflow button按钮
            ViewConfiguration mconfig_1 = ViewConfiguration.get(this);
            Field menuKeyField_1;
            menuKeyField_1 = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField_1 != null){
                menuKeyField_1.setAccessible(true);
                menuKeyField_1.setBoolean(mconfig_1, false);
            }
        }catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //button1按键点击页面跳转
        //view层的控件和业务层的控件，靠id关联和映射  给btn赋值，即设置布局文件中的Button按钮id进行关联
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);

        ButtonListener MyListener = new ButtonListener();
        btn1.setOnClickListener(MyListener);
        btn2.setOnClickListener(MyListener);
        btn3.setOnClickListener(MyListener);
        btn4.setOnClickListener(MyListener);
        btn5.setOnClickListener(MyListener);
        btn6.setOnClickListener(MyListener);

    }

    //给btn绑定监听事件
    private class ButtonListener implements View.OnClickListener{
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.button1:
                    // 给bnt1添加点击响应事件
                    Intent intent_1 = new Intent(MainActivity.this,Button1Activity.class);
                    //启动
                    startActivity(intent_1);
                    break;
                case R.id.button2:
                    // 给bnt1添加点击响应事件
                    Intent intent_2 = new Intent(MainActivity.this,MainFragmentActivity.class);
                    //启动
                    startActivity(intent_2);
                    break;
                case R.id.button3:
                    // 给bnt1添加点击响应事件
                    Intent intent_3 = new Intent(MainActivity.this,ListViewActivity.class);
                    //启动
                    startActivity(intent_3);
                    break;
                case R.id.button4:
                    // 给bnt1添加点击响应事件
                    Intent intent_4 = new Intent(MainActivity.this,Button1Activity.class);
                    //启动
                    startActivity(intent_4);
                    break;
                case R.id.button5:
                    // 给bnt1添加点击响应事件
                    Intent intent_5 = new Intent(MainActivity.this,ListViewActivity.class);
                    //启动
                    startActivity(intent_5);
                    break;
                case R.id.button6:
                    // 给bnt1添加点击响应事件
                    Intent intent_6 = new Intent(MainActivity.this,SettingActivity.class);
                    //启动
                    startActivity(intent_6);
                    break;
                default:
                    break;
            }
        }
    }

    //实现退出程序时弹出对话框
    protected void dialog()
    {
        Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        dialog.setTitle("退出程序");
        dialog.setMessage("确定退出本程序？");
        dialog.setPositiveButton("确定", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.setNegativeButton("取消", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.create();
        dialog.show();
    }

    //menu菜单点击响应
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_exit){
            //调用弹出对话框的函数
            dialog();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        setIconsVisible(menu,true);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void setIconsVisible(Menu menu, boolean flag) {
        //判断menu是否为空
        if(menu != null) {
            try {
                //如果不为空,就反射拿到menu的setOptionalIconsVisible方法
                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                //暴力访问该方法
                method.setAccessible(true);
                //调用该方法显示icon
                method.invoke(menu, flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
