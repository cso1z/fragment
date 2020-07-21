package com.xyz.fragment.activity;

import android.app.Activity;
import android.os.Bundle;

import com.xyz.fragment.BaseActivity;
import com.xyz.fragment.R;

/**
 * created by shenyonghui on 2020/7/21
 * 静态添加Fragment
 */
public class StaticallyAddFragmentActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statically_add_fragment);
    }
}
