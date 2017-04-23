package com.example.dell.mylistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] autoStr = new String[]
            {"Italy","IT","item","its","itself"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* new ArrayAdapter对象并将autoStr字符串数组传入 */
        ArrayAdapter adapter =
                new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, autoStr);
	    /* 以findViewById()取得AutoCompleteTextView对象 */
        AutoCompleteTextView myAutoCompleteTextView =
                (AutoCompleteTextView) findViewById(R.id.myAutoCompleteTextView);
	    /* 将ArrayAdapter加入AutoCompleteTextView对象中 */
        myAutoCompleteTextView.setAdapter(adapter);

        /**
         * 用MultiAutoCompleteTextView来实现
         * 继承自AutoCompleteTextView，延长AutoCompleteTextView的长度
         * 它和AutoCompleteTextView的区别就是MultiAutoCompleteTextView可以在输入框中一直增加新的选取值。
         * 编写方式也有所不同，在进行setAdapter之后还需要调用setTokenizer(),否则会出现错误
         */
        MultiAutoCompleteTextView myMultiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.myMultiAutoCompleteTextView);
        myMultiAutoCompleteTextView.setAdapter(adapter);
        myMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
