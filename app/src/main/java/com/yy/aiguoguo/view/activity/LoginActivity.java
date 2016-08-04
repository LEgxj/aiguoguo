package com.yy.aiguoguo.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.yy.aiguoguo.R;

/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class LoginActivity extends BaseActivity{
    private EditText editName;
    private EditText editPassword;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
