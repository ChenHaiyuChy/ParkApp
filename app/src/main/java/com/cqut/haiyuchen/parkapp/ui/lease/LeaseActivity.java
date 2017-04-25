package com.cqut.haiyuchen.parkapp.ui.lease;

import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.ui.AuxiliaryFragment;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class LeaseActivity extends AuxiliaryFragment {

  @BindView(R.id.lease_btn_rent) Button btnRent;
  @BindView(R.id.lease_btn_rented) Button btnRented;
  @BindView(R.id.lease_layout_rent) View layoutRent;
  @BindView(R.id.lease_layout_rented) View layoutRented;

  @Override public int layoutResId() {
    return R.layout.activity_lease;
  }

  @Override public void onInit() {
    super.onInit();
  }

  @OnClick(R.id.lease_btn_rent) public void rentClick() {
    btnRent.setEnabled(false);
    btnRented.setEnabled(true);
    layoutRent.setVisibility(View.VISIBLE);
    layoutRented.setVisibility(View.GONE);
  }

  @OnClick(R.id.lease_btn_rented) public void rentedClick() {
    btnRent.setEnabled(true);
    btnRented.setEnabled(false);
    layoutRent.setVisibility(View.GONE);
    layoutRented.setVisibility(View.VISIBLE);
  }
}
