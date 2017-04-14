package com.cqut.haiyuchen.parkapp.ui.lease;

import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.ui.AuxiliaryFragment;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseToast;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class LeaseActivity extends AuxiliaryFragment {
  @BindView(R.id.tv_ddd) TextView tvDdd;

  @Override public int layoutResId() {
    return R.layout.activity_lease;
  }

  @Override public void onInit() {
    super.onInit();
    tvDdd.setText("ddd");
  }

  @OnClick(R.id.tv_ddd) void dddClick() {
    BaseToast.showText("ddd");
  }
}
