package com.yy.aiguoguo.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.yy.aiguoguo.R;

/**
 * Created by yyan on 2016/8/3 0003.
 */
public class WelcomeActivity extends BaseActivity{
    private static final int sleepTime = 2000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        }).start();
    }
}
