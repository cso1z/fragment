package com.xyz.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.xyz.fragment.BaseFragment;
import com.xyz.fragment.R;
import com.xyz.fragment.callback.ICallBack;

/**
 * created by john on 2020/7/26
 * Activity与Fragment 数据传递
 */
public class ActivityAndFragmentDataCommunicationFragment extends BaseFragment implements View.OnClickListener {
    //获取Activity数据显示容器
    private TextView textView;

    //向Activity发送数据输入容器
    private EditText editText;

    private ICallBack callBack;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_activity_and_fragement_intent_data, container, false);
        view.findViewById(R.id.commit).setOnClickListener(this);
        view.findViewById(R.id.get).setOnClickListener(this);
        textView = view.findViewById(R.id.text_view);
        editText = view.findViewById(R.id.edit_text);
        //通过Bundle获取Activity向Fragment传递数据
        getData();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getData() {
        //1.获取Bundle
        Bundle bundle = getArguments();
        //2. 判断bundle对象是否包含key值为message的数据
        if (bundle != null && bundle.containsKey("message")) {
            //3. 从bundle中获取key值为message的数据
            String message = bundle.getString("message");
            textView.setText(message);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.get) {
            getDataFromActivity();
        } else if (id == R.id.commit) {
            sendDataToActivity();
        }
    }

    /**
     * 向Activity传递数据
     */
    private void sendDataToActivity() {
        if (callBack != null) {
            callBack.sendDataToActivity(editText.getText().toString());
        }
    }

    /**
     * 从Activity获取数据
     */
    private void getDataFromActivity() {
        if (callBack != null) {
            String data = callBack.getDataFromActivity();
            textView.setText(data);
        }
    }

    // 设置 接口回调 方法
    public void sendCallBack(ICallBack callBack) {
        this.callBack = callBack;
    }
}
