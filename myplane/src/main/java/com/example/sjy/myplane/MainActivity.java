package com.example.sjy.myplane;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button_start)
    Button buttonStart;
    @BindView(R.id.button_exit)
    Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.button_start, R.id.button_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                if(buttonStart!=null){
                    startActivity(new Intent(MainActivity.this,
                            GameActivity.class));
                }
                break;
            case R.id.button_exit:
                if(buttonExit!=null){
                    finish();
                }
                break;
        }
    }
}
