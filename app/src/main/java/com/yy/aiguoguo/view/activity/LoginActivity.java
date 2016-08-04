package com.yy.aiguoguo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.yy.aiguoguo.R;

/**
 * Created by yyan on 2016/8/3 0003.
 */
public class LoginActivity extends BaseActivity{
    private EditText editName;
    private EditText editPassword;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editName = (EditText) findViewById(R.id.edit_name);
        editPassword = (EditText) findViewById(R.id.edit_password);

    }
    public void register(View view){

        startActivity(new Intent(getBaseContext(),RegisterActivity.class));

    }
    public void login(View view){
        String name = editName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            toast.showToast("用户名不能为空");
            return;
        }if (TextUtils.isEmpty(password)){
            toast.showToast("密码不能为空");
            return;
        }

    }
}
