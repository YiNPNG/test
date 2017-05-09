package com.example.dell.mylastapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * Created by DELL on 2017/4/22.
 */

public class SettingActivity extends AppCompatActivity {
    private Button shape_btn1,shape_btn2,shape_btn3,shape_btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        try{
            ViewConfiguration mconfig_2 = ViewConfiguration.get(this);
            Field menuKeyField_2;
            menuKeyField_2 = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField_2 != null){
                menuKeyField_2.setAccessible(true);
                menuKeyField_2.setBoolean(mconfig_2, false);
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
        shape_btn1 = (Button)findViewById(R.id.shape_1);
        shape_btn2 = (Button)findViewById(R.id.shape_2);
        shape_btn3 = (Button)findViewById(R.id.shape_3);
        shape_btn4 = (Button)findViewById(R.id.shape_4);
        ShapeButtonListener MyListener = new ShapeButtonListener();
        shape_btn1.setOnClickListener(MyListener);
        shape_btn2.setOnClickListener(MyListener);
        shape_btn3.setOnClickListener(MyListener);
        shape_btn4.setOnClickListener(MyListener);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_back){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_1, menu);
        return true;
    }
    private class ShapeButtonListener implements View.OnClickListener{
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.shape_1:
                    Toast.makeText(SettingActivity.this,
                            "不知道写什么", Toast.LENGTH_LONG).show();
                    break;
                case R.id.shape_2:
                    Toast.makeText(SettingActivity.this,
                            "将就着看看吧", Toast.LENGTH_LONG).show();
                    break;
                case R.id.shape_3:
                    Toast.makeText(SettingActivity.this,
                            "将就着看看吧", Toast.LENGTH_LONG).show();
                    break;
                case R.id.shape_4:
                    Toast.makeText(SettingActivity.this,
                            "将就着看看吧", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }

}
