package com.xyz.fragment;

import android.os.Bundle;


import com.example.menucontainer.*;
import com.xyz.fragment.activity.DynamicAddFragmentActivity;
import com.xyz.fragment.activity.ReplaceFragmentActivity;
import com.xyz.fragment.activity.ActivityAndFragmentDataCommunicationActivity;
import com.xyz.fragment.activity.StaticallyAddFragmentActivity;


import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private Map<String, Class> map = new LinkedHashMap<>();
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MenuContainer menuContainer = new MenuContainer(this);
        setContentView(menuContainer);
        adapter = new Adapter(map);
        menuContainer.setAdapter(adapter);
        addData();
    }

    private void addData() {
        map.put("静态添加Fragment", StaticallyAddFragmentActivity.class);
        map.put("动态添加Fragment", DynamicAddFragmentActivity.class);
        map.put("动态替换Fragment", ReplaceFragmentActivity.class);
        map.put("Activity 传递数据给Fragment ", ActivityAndFragmentDataCommunicationActivity.class);
        adapter.notifyDataSetChanged();
    }
}
