package com.yy.aiguoguo.view.activity;

import android.os.Bundle;

import com.yy.aiguoguo.view.fragment.ChatListFragment;
import com.yy.aiguoguo.view.fragment.ContactListFragment;
import com.yy.aiguoguo.view.fragment.SettingsFragment;

/**
 * Created by Administrator on 2016/8/3 0003.
 */
public class HXActivity extends BaseActivity{
    private ChatListFragment chatListFragment;
    private ContactListFragment contactListFragment;
    private SettingsFragment settingsFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chatListFragment = new ChatListFragment();
        contactListFragment = new ContactListFragment();
        settingsFragment = new SettingsFragment();
    }
}
