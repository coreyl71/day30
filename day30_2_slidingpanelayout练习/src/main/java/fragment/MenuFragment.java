package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Corey on 2016/5/27.
 * 用于控制菜单部分的Fragment对象
 */
public class MenuFragment extends ListFragment{

    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    public interface ListItemClickCallback {
        void itemClick(String str);
    }

    ListItemClickCallback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback = (ListItemClickCallback) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 初始化数据
        initData();
        // 设置适配器
        setAdapter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setAdapter() {
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        setListAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            list.add("item " + i);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        callback.itemClick(list.get(position));
    }
}
