package com.cqut.haiyuchen.parkapp.ui.service;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.entitis.ABC;
import com.cqut.haiyuchen.parkapp.ui.listview.ListViewAdapter;
import com.cqut.haiyuchen.parkapp.ui.listview.OnScrollListView;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haiyu.chen on 2017/4/1.
 */

public class ServiceActivity {

  /*@BindView(R.id.list_view) OnScrollListView listView;
  @BindView(R.id.empty_view) TextView emptyView;

  List<Map<String, Object>> list = new ArrayList<>();
  ListViewAdapter adapter;

  @Override public int layoutResId() {
    return R.layout.activity_service;
  }

  @Override public void onInit(@Nullable Bundle savedInstanceState) {
    super.onInit(savedInstanceState);
    listView.setEmptyView(emptyView);
    setListView();
    adapter = new ListViewAdapter(this, list,listView);
    listView.setAdapter(adapter);
    listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      // 用户在选择的时候，也会调用该方法，在该方法中调用notifyDataSetChanged刷新选中状态
      public void onItemClick(AdapterView<?> parent, View view,
          int position, long id) {
        Toast.makeText(getApplication(),position+"",Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
      }
    });
    TextView tv = new TextView(this);
    tv.setText("addHeaderView!");
    tv.setHeight(40);
    tv.setBackgroundColor(0xffffffff);
    tv.setTextSize(15);
    //listView.addHeaderView(tv);
    listView.setonRefreshListener(new OnScrollListView.OnRefreshListener() {
      @Override public void onRefresh() {
        new AsyncTask<Void, Void, Void>() {
          protected Void doInBackground(Void... params) {
            try {
              Thread.sleep(1000);
            } catch (Exception e) {
              e.printStackTrace();
            }
            Map<String, Object> map = new HashMap<>();
            map.put("number", list.size() + "");
            map.put("info", ABC.values()[(int) (Math.random() * 26)].getName());
            list.add(map);
            return null;
          }

          @Override protected void onPostExecute(Void result) {
            adapter.notifyDataSetChanged();
            listView.onRefreshComplete();
          }
        }.execute(null, null, null);
      }
    });
  }

  public void setListView() {
    Map<String, Object> map;
    for (int i = 0; i <= 30; i++) {
      map = new HashMap<>();
      map.put("number", i + "");
      map.put("info", ABC.values()[(int) (Math.random() * 26)].getName());
      list.add(map);
    }
  }*/
}
