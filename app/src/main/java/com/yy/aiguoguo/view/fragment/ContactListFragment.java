package com.yy.aiguoguo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yy.aiguoguo.R;

/**
 * Created by yyan on 2016/8/3 0003.
 */
public class ContactListFragment extends BaseFragment{

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_contactlist,null);

        return view;
    }
}
