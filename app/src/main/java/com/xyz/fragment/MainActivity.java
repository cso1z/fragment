package com.xyz.fragment;

import android.os.Bundle;
import android.view.View;


import com.example.menucontainer.*;
import com.xyz.fragment.activity.DynamicAddFragmentActivity;
import com.xyz.fragment.activity.StaticallyAddFragmentActivity;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static Map<String, Class> map;

    static {
        map = new LinkedHashMap<>();
        map.put("静态添加Fragment", StaticallyAddFragmentActivity.class);
        map.put("动态添加Fragment", DynamicAddFragmentActivity.class);

    }

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuContainer menuContainer = findViewById(R.id.menu);
        adapter = new Adapter();
        menuContainer.setAdapter(adapter);
        adapter.setData(map);

        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.remove).setOnClickListener(this);

    }

    int i = 0;

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (R.id.add == id) {
            map.put("动态添加Fragment " + i, DynamicAddFragmentActivity.class);
            i++;
            adapter.notifyDataSetChanged();
        } else if (R.id.remove == id) {
            if (map == null || map.isEmpty()) {
                return;
            }
            Iterator iterator = map.keySet().iterator();
            if (iterator.hasNext()) {
                map.remove(iterator.next());
            }
            adapter.notifyDataSetChanged();
        }
    }
}
