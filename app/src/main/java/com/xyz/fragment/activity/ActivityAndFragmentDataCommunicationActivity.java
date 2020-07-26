package com.xyz.fragment.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xyz.fragment.BaseActivity;
import com.xyz.fragment.R;
import com.xyz.fragment.callback.ICallBack;
import com.xyz.fragment.fragment.ActivityAndFragmentDataCommunicationFragment;

/**
 * created by john on 2020/7/26
 * Activity与Fragment 数据传递
 */
public class ActivityAndFragmentDataCommunicationActivity extends BaseActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_and_fragment_data_communication);

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);

        // 步骤1：获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 步骤2：获取FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 步骤3：创建需要添加的Fragment
        ActivityAndFragmentDataCommunicationFragment fragment = new ActivityAndFragmentDataCommunicationFragment();

        //设置fragment数据回调
        fragment.sendCallBack(new ICallBack() {
            @Override
            public void sendDataToActivity(String string) {
                textView.setText(string);
            }

            @Override
            public String getDataFromActivity() {
                return editText.getText().toString();
            }
        });

        // 步骤4:创建Bundle对象
        // 作用:存储数据，并传递到Fragment中
        Bundle bundle = new Bundle();

        // 步骤5:往bundle中添加数据
        bundle.putString("message", editText.getText().toString());

        // 步骤6:把数据设置到Fragment中
        fragment.setArguments(bundle);

        // 步骤7：动态添加fragment
        // 即将创建的fragment添加到Activity布局文件中定义的占位符中（FrameLayout）
        fragmentTransaction.add(R.id.fragment, fragment);
        fragmentTransaction.commit();

    }
}
