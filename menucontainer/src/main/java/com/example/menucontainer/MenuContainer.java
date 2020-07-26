package com.example.menucontainer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Map;

/**
 * created by john on 2020/7/22
 */
public class MenuContainer extends ScrollView implements ChangeDataListener {

    private LinearLayout container;
    private Adapter adapter;

    public MenuContainer(Context context) {
        super(context);
        init();
    }

    public MenuContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MenuContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        adapter.setChangeDataListener(this);
        container.removeAllViews();
        addItem();
    }

    private void init() {
        removeAllViews();
        container = new LinearLayout(getContext());
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        container.setOrientation(LinearLayout.VERTICAL);
        addView(container);
    }

    @Override
    public void notifyDataSetChanged() {
        removeItem();
        addItem();
    }

    private void removeItem() {
        container.removeAllViews();
    }

    public void addItem() {
        if (adapter == null || adapter.getDataResource() == null) {
            return;
        }
        for (Map.Entry<String, Class> entry : adapter.getDataResource().entrySet()) {
            String title = entry.getKey();
            Class clazz = entry.getValue();
            ClickItemView itemView = new ClickItemView(getContext());
            itemView.setData(title, clazz);
            itemView.requestLayout();
            container.addView(itemView);
        }
    }

}