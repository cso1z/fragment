package com.xyz.fragment.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xyz.fragment.BaseActivity;
import com.xyz.fragment.R;
import com.xyz.fragment.fragment.ExampleFragment1;
import com.xyz.fragment.fragment.ExampleFragment2;

import java.util.List;

/**
 * created by john on 2020/7/26
 * 替换Fragment
 */
public class ReplaceFragmentActivity extends BaseActivity implements View.OnClickListener {
    private TextView fragmentTask;
    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace_fragment);
        fragmentTask = findViewById(R.id.fragment_task);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.replace).setOnClickListener(this);
        findViewById(R.id.remove).setOnClickListener(this);
        handler = new Handler();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.add) {
            add();
        } else if (id == R.id.replace) {
            replace();
        } else if (id == R.id.remove) {
            remove();
        }
        showFragmentTask();
    }

    private void add() {
        //1. 获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //2. 获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //3. 创建需要添加的Fragment
        ExampleFragment1 fragment = new ExampleFragment1();

        //4. 动态添加Fragment(即将创建的fragment添加到Activity布局文件中定义的FrameLayout)
        fragmentTransaction.add(R.id.fragment, fragment);

        fragmentTransaction.commit();
    }

    private void replace() {
        // Create fragment and give it an argument specifying the article it should show
        ExampleFragment2 exampleFragment2 = new ExampleFragment2();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.add(R.id.fragment, exampleFragment2);
        transaction.addToBackStack(String.valueOf(Math.random()));

        // Commit the transaction
        transaction.commit();
    }

    public void remove() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showFragmentTask();
    }

    private void showFragmentTask() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder fragmentNames = new StringBuilder("fragment task:\n");
                FragmentManager fragmentManager = getSupportFragmentManager();
                List<Fragment> fragments = fragmentManager.getFragments();
                for (Fragment fragment : fragments) {
                    fragmentNames.append(fragment.getClass().getSimpleName()).append("\n");
                }
                fragmentTask.setText(fragmentNames);
            }
        }, 200);

    }
}
