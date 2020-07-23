package com.xyz.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.xyz.fragment.activity.DynamicAddFragmentActivity;
import com.xyz.fragment.activity.StaticallyAddFragmentActivity;
import com.xyz.fragment.weight.ClickItemView;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private static Map<String, Class> map;

    static {
        map = new LinkedHashMap<>();
        map.put("静态添加Fragment", StaticallyAddFragmentActivity.class);
        map.put("动态添加Fragment", DynamicAddFragmentActivity.class);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(scrollView);
        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        container.setOrientation(LinearLayout.VERTICAL);
        for (Map.Entry<String, Class> entry : map.entrySet()) {
            String title = entry.getKey();
            Class clazz = entry.getValue();
            ClickItemView itemView = new ClickItemView(this);
            itemView.setData(title, clazz);
            itemView.requestLayout();
            container.addView(itemView);
        }
        scrollView.addView(container);
    }
}
