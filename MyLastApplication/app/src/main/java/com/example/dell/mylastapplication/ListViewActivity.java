package com.example.dell.mylastapplication;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private String path;
    private String paths;
    String[] listFile = null;
    ShowRecorderAdpter showRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.list);
        showRecord = new ShowRecorderAdpter();

        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {

                path = Environment.getExternalStorageDirectory() + "/DCIM/Camera/text";
                File files = new File(path);
                if (!files.exists()) {
                    files.mkdir();
                }
                listFile = files.list();
        }

        if (listFile != null) {
            listView.setAdapter(showRecord);
        }

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
    class ShowRecorderAdpter extends BaseAdapter {

        @Override
        public int getCount() {
            return listFile.length;
        }

        @Override
        public Object getItem(int arg0) {
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;

        }
        @Override
        public View getView(final int postion, View arg1, ViewGroup arg2) {
            View views = LayoutInflater.from(ListViewActivity.this).inflate(R.layout.listview, null);
            TextView filename = (TextView) views.findViewById(R.id.show_file_name);
            Button plays = (Button) views.findViewById(R.id.list_play);


            filename.setText(listFile[postion]);

            // 播放录音
            plays.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {

                    Intent intent = new Intent(ListViewActivity.this,VideoViewDemo.class);
                    /* new 一个Bundle对象，并将要传递的数据传入 */
                    paths =  listFile[postion];
                    Bundle bundle = new Bundle();
                    bundle.putString("paths", paths);
			        /* 将Bundle 对象assign 给Intent */
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            return views;
        }

    }

}
