package com.example.dell.mylastapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Context;
import android.content.ContentResolver;
import android.provider.MediaStore;
import android.database.Cursor;
import android.provider.MediaStore.Images;

/**
 * Created by DELL on 2017/4/20.
 */

public class Button1Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button1);

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
    /**
     * @param context
     * @param cr
     * @param Videopath
     * @return
     */
    public static Bitmap getVideoThumbnail(Context context, ContentResolver cr, String Videopath) {
        ContentResolver testcr = context.getContentResolver();
        String[] projection = { MediaStore.Video.Media.DATA, MediaStore.Video.Media._ID, };
        String whereClause = MediaStore.Video.Media.DATA + " = '" + Videopath + "'";
        Cursor cursor = testcr.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, whereClause,
                null, null);
        int _id = 0;
        String videoPath = "";
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        }
        if (cursor.moveToFirst()) {

            int _idColumn = cursor.getColumnIndex(MediaStore.Video.Media._ID);
            int _dataColumn = cursor.getColumnIndex(MediaStore.Video.Media.DATA);
            do {
                _id = cursor.getInt(_idColumn);
                videoPath = cursor.getString(_dataColumn);
            } while (cursor.moveToNext());
        }
        cursor.close();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bitmap = MediaStore.Video.Thumbnails.getThumbnail(cr, _id, Images.Thumbnails.MINI_KIND,
                options);
        return bitmap;
    }
}
