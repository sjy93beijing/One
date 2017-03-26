package com.example.sjy.sqlitetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sjy_1993 on 2017/3/13.
 */
public class ResultActivity extends Activity {
    @BindView(R.id.show)
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        //从bundle包中得到的数据
        Bundle data = intent.getExtras();
        List<Map<String, String>> list = (List<Map<String, String>>) data.getSerializable("data");
        //封装成adapter
        SimpleAdapter adapter = new SimpleAdapter(ResultActivity.this, list, R.layout.line, new String[]
                {"word", "detail"}, new int[]{R.id.word, R.id.detail});
        //填充
        show.setAdapter(adapter);

    }
}
