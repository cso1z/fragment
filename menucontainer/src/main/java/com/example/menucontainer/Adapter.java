package com.example.menucontainer;

import java.util.Map;

/**
 * created by john on 2020/7/23
 */
public class Adapter {

    Map<String, Class> dataResource;

    public Adapter() {
    }

    public Adapter(Map<String, Class> dataResource) {
        if (dataResource==null){
            throw new IllegalStateException("dataResource should init");
        }
        setData(dataResource);
    }

    public void setData(Map<String, Class> dataResource) {
        this.dataResource = dataResource;
        if (changeDataListener != null) {
            changeDataListener.notifyDataSetChanged();
        }
    }

    public void addData(String title, Class clazz) {
        dataResource.put(title, clazz);
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        if (changeDataListener == null) {
            throw new IllegalStateException("adapter should set whit ScrollView");
        }
        changeDataListener.notifyDataSetChanged();
    }

    public Map<String, Class> getDataResource() {
        return dataResource;
    }

    private ChangeDataListener changeDataListener;

    protected void setChangeDataListener(ChangeDataListener changeDataListener) {
        this.changeDataListener = changeDataListener;
    }
}
