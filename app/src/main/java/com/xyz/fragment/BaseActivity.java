package com.xyz.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * created by shenyonghui on 2020/7/21
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.getInstance().logCurrentMethod(this.getClass());

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public boolean hasWindowFocus() {
        Log.getInstance().logCurrentMethod(this.getClass());
        return super.hasWindowFocus();
    }
}
