package com.xyz.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.xyz.fragment.BaseFragment;
import com.xyz.fragment.R;


/**
 * created by shenyonghui on 2020/7/21
 * Fragment 2
 */
public class ExampleFragment2 extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        EditText textView = view.findViewById(R.id.text);
        textView.setText("测试 Fragment 2");
        textView.setBackgroundColor(0xFF555555);
        return view;
    }
}
