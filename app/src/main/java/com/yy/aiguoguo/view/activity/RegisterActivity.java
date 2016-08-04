package com.yy.aiguoguo.view.activity;

import android.os.Bundle;
import android.view.View;

import com.yy.aiguoguo.R;

/**
 * Created by yyan on 2016/8/4 0004.
 */
public class RegisterActivity extends  BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void register(View view){
        toast.showToast("正在注册。。。");
    }
}
