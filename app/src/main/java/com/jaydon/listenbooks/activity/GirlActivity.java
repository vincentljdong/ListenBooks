package com.jaydon.listenbooks.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jaydon.listenbooks.R;

public class GirlActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgGirlBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl);
        initView();
        initDta();
        initListener();
    }

    private void initView() {
        imgGirlBack = findViewById(R.id.img_girl_back);
    }

    private void initDta() {
    }

    private void initListener() {
        imgGirlBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_girl_back:
                finish();
                break;
            default:
                break;
        }
    }
}
