package com.xyz.fragment.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xyz.fragment.BaseActivity;
import com.xyz.fragment.R;

/**
 * created by shenyonghui on 2020/7/23
 * 动态添加Fragment
 */
public class DynamicAddFragmentActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add_fragment);

        //1. 获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //2. 获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //3. 创建需要添加的Fragment
        ExampleFragment fragment = new ExampleFragment();

        //4. 动态添加Fragment(即将创建的fragment添加到Activity布局文件中定义的FrameLayout)
        fragmentTransaction.add(R.id.fragment, fragment);

        fragmentTransaction.commit();
    }
}
