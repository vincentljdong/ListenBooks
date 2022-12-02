package com.jaydon.listenbooks.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jaydon.listenbooks.R;
import com.skydoves.transformationlayout.TransformationAppCompatActivity;

public class DetailActivity extends TransformationAppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl);
    }

    @Override
    public void onClick(View view) {

    }
}
