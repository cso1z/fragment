package com.xyz.fragment.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.xyz.fragment.BaseFragment;
import com.xyz.fragment.R;


/**
 * created by shenyonghui on 2020/7/21
 */
public class ExampleFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment_test.xml作为该Fragment的布局文件
        // 即相当于FragmentLayoutTest直接调用fragment_test.xml来显示到Fragment中
        return inflater.inflate(R.layout.fragment_test, container, false);

    }
}
