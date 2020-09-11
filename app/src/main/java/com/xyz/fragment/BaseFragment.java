package com.xyz.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * created by shenyonghui on 2020/7/21
 */
public class BaseFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.getInstance().logCurrentMethod(this.getClass());
        //test
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.getInstance().logCurrentMethod(this.getClass());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.getInstance().logCurrentMethod(this.getClass());
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.getInstance().logCurrentMethod(this.getClass());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.getInstance().logCurrentMethod(this.getClass());
    }
}
