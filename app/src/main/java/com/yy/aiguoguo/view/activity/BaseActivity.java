package com.yy.aiguoguo.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.yy.aiguoguo.controller.tools.SharedPreferencesUtil;

/**
 * Created by yyan on 2016/8/3 0003.
 */
public class BaseActivity extends Activity{
    public SharedPreferencesUtil sp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = new SharedPreferencesUtil(getBaseContext());
    }
}
