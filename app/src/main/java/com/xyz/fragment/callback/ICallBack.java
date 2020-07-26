package com.xyz.fragment.callback;

/**
 * created by john on 2020/7/26
 * 该接口用于用于Activity与Fragment通信
 */
public interface ICallBack {
    /**
     * 向Activity传递数据
     */
    void sendDataToActivity(String string);

    /**
     * 从Activity获取数据
     */
    String getDataFromActivity();
}
