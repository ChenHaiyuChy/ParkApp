package com.cqut.haiyuchen.parkapp.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import com.cqut.haiyuchen.parkapp.R;
import java.util.List;
import java.util.Map;

/**
 * Created by haiyu.chen on 2017/4/1.
 */

public class ListViewAdapter extends BaseAdapter {
  private List<Map<String, Object>> data;
  private List<Map<String, Object>> checkedData;
  private LayoutInflater layoutInflater;
  private Context context;
  private ListView listView;

  public ListViewAdapter(Context context, List<Map<String, Object>> data,ListView listView) {
    this.context = context;
    this.data = data;
    this.layoutInflater = LayoutInflater.from(context);
    this.listView = listView;
  }

  public final class ViewHolder {
    public TextView number;
    public TextView information;
    public CheckBox state;
  }

  @Override public int getCount() {
    return data.size();
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    final ViewHolder viewHolder;
    if (convertView == null) {
      convertView = layoutInflater.inflate(R.layout.item_service_info, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.number = (TextView) convertView.findViewById(R.id.item_home_info_num);
      viewHolder.information = (TextView) convertView.findViewById(R.id.item_home_info_content);
      viewHolder.state = (CheckBox) convertView.findViewById(R.id.view_checkbox);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    if (listView.isItemChecked(position+1)) {
      viewHolder.state.setChecked(true);
    } else {
      viewHolder.state.setChecked(false);
    }
    viewHolder.number.setText((String) data.get(position).get("number"));
    viewHolder.information.setText((String) data.get(position).get("info"));
    return convertView;
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public Map<String, Object> getItem(int position) {
    return data.get(position);
  }
}
