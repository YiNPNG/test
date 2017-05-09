package com.example.dell.texttwo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.dell.texttwo.po.PFile;
import com.example.dell.texttwo.ui.FragmentBase;

import java.io.File;
import java.util.ArrayList;
import com.example.dell.texttwo.util.FileUtils;


/**
 * Created by DELL on 2017/4/27.
 */

public class FragmentFile extends FragmentBase implements AdapterView.OnItemClickListener {

    private FileAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);
        mAdapter = new FileAdapter(getActivity(),0, null);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        new ScanVideoTask().execute();
        return v;
    }

    /** 单击启动播放 */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final File f = mAdapter.getItem(position);
        Intent intent = new Intent(getActivity(), VideoViewDemo.class);
        intent.putExtra("path", f.getPath());
        startActivity(intent);
    }

    /** 扫描SD卡 */
    private class ScanVideoTask extends AsyncTask<Void, File, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            eachAllMedias(Environment.getExternalStorageDirectory());
            return null;
        }

        @Override
        protected void onProgressUpdate(File... values) {
            mAdapter.add(values[0]);
            mAdapter.notifyDataSetChanged();
        }

        /** 遍历所有文件夹，查找出视频文件 */
        public void eachAllMedias(File f) {
            if (f != null && f.exists() && f.isDirectory()) {
                File[] files = f.listFiles();
                if (files != null) {
                    for (File file : f.listFiles()) {
                        if (file.isDirectory()) {
                            eachAllMedias(file);
                        } else if (file.exists() && file.canRead() && FileUtils.isVideoOrAudio(file)) {
                            publishProgress(file);
                        }
                    }
                }
            }
        }
    }

    private class FileAdapter extends ArrayAdapter<File> {

        public FileAdapter(Context ctx,int a, ArrayList<File> l) {
            super(ctx,a,l);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final File f = getItem(position);
            if (convertView == null) {
                final LayoutInflater mInflater = getActivity().getLayoutInflater();
                convertView = mInflater.inflate(R.layout.fragment_file_item, null);
            }
            ((TextView) convertView.findViewById(R.id.title)).setText(f.getName());
            return convertView;
        }
    }
}
