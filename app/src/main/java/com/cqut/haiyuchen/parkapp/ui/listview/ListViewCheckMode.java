package com.cqut.haiyuchen.parkapp.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cqut.haiyuchen.parkapp.R;

/**
 * Created by haiyu.chen on 2017/4/1.
 */

public class ListViewCheckMode extends LinearLayout implements Checkable {
  private TextView num;
  private TextView info;
  private CheckBox state;

  public ListViewCheckMode(Context context) {
    super(context);
    LayoutInflater inflater = LayoutInflater.from(context);
    View v = inflater.inflate(R.layout.item_service_info, this, true);
    num = (TextView) v.findViewById(R.id.item_home_info_num);
    info = (TextView) v.findViewById(R.id.item_home_info_content);
    state = (CheckBox) v.findViewById(R.id.view_checkbox);
  }

  public void setNum(TextView num) {
    this.num = num;
  }

  public void setInfo(TextView info) {
    this.info = info;
  }

  @Override public boolean isChecked() {
    return state.isChecked();
  }

  @Override public void setChecked(boolean checked) {
    state.setChecked(checked);
  }

  @Override public void toggle() {
    state.toggle();
  }
}
