package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.day30_2_slidingpanelayout.R;

/**
 * Created by Corey on 2016/5/27.
 * 用于控制内容部分的显示
 */
public class ContentFragment extends Fragment {
    private Button btn;
    private TextView textView;

    // 处理回调
    public interface ButtonClickCallback {
        void buttonClick();
    }

    ButtonClickCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ButtonClickCallback) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    /**
     * onCreateView方法运行完成后，自动调用的方法
     * @param view  此参数就是onCreateView方法的返回值
     *              即当前Fragment中显示view对象
     *              如果需要获取此控件，即可通过此view对象
     *              调用findViewById方法即可
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 初始化控件
        initView(view);

        //设置监听
        setListener();
    }

    private void setListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 通过方法，打开菜单
                callback.buttonClick();
            }
        });
    }

    private void initView(View view) {
        textView = (TextView) view.findViewById(R.id.textview);
        btn = (Button) view.findViewById(R.id.btn_content);
    }

    public void changeText(String str) {
        textView.setText(str);
    }
}
