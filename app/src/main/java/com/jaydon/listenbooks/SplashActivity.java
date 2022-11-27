package com.jaydon.listenbooks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import me.wangyuwei.particleview.ParticleView;

public class SplashActivity extends AppCompatActivity {
    ParticleView mParticview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mParticview = (ParticleView) findViewById(R.id.particlview);
        mParticview.postDelayed(new Runnable() {
            @Override
            public void run() {
                mParticview.startAnim();
            }
        }, 300);
        mParticview.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
