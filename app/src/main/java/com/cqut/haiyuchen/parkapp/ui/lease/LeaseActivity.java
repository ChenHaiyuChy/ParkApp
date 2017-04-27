package com.cqut.haiyuchen.parkapp.ui.lease;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.di.components.lease.DaggerLeaseComponent;
import com.cqut.haiyuchen.parkapp.di.components.lease.LeaseComponent;
import com.cqut.haiyuchen.parkapp.di.modules.lease.LeaseModule;
import com.cqut.haiyuchen.parkapp.presentation.lease.LeasePresenter;
import com.cqut.haiyuchen.parkapp.presentation.lease.LeaseView;
import com.cqut.haiyuchen.parkapp.ui.BaseFragment;
import com.cqut.haiyuchen.parkapp.ui.untils.DateTimeFormat;
import com.cqut.haiyuchen.parkapp.ui.widget.DateTimePicker;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class LeaseActivity extends BaseFragment<LeasePresenter> implements LeaseView {

  /* Master */
  @BindView(R.id.lease_btn_rent) Button btnRent;
  @BindView(R.id.lease_btn_rented) Button btnRented;
  @BindView(R.id.lease_layout_rent) View layoutRent;
  @BindView(R.id.lease_layout_rented) View layoutRented;

  /*Rent*/

  /*Rented*/
  @BindView(R.id.rented_sp_lock) Spinner spLock;
  @BindView(R.id.rented_et_name) EditText etName;
  @BindView(R.id.rented_et_start_time) EditText etStartTime;
  @BindView(R.id.rented_et_end_time) EditText etEndTime;
  @BindView(R.id.rented_et_address) EditText etAddress;
  @BindView(R.id.rented_et_contact_way) EditText etContactWay;
  @BindView(R.id.rented_btn_rented) Button btnRentedRented;

  private SpinnerAdapter spinnerAdapter;
  private boolean spinnerFirstSelect = true;

  @Override public int layoutResId() {
    return R.layout.activity_lease;
  }

  @Override public void onInit() {
    super.onInit();
    LeaseComponent component = DaggerLeaseComponent.builder()
        .appComponent(getAppComponent())
        .leaseModule(new LeaseModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
    presenter.initLockList();
    controlsInit();
  }

  public void controlsInit() {

    rentClick();

    spinnerAdapter =
        new ArrayAdapter<>(getContext(), R.layout.item_lock_spinner_item, presenter.getLockList());
    spLock.setAdapter(spinnerAdapter);

    etStartTime.setFocusable(false);
    etEndTime.setFocusable(false);
    etStartTime.setText(DateTimeFormat.getNowDateTimeFormat());
    etEndTime.setText(DateTimeFormat.getNowDateTimeFormat());

    etContactWay.setText(PreferencesManager.getInstance().getPhoneNumber());
    etContactWay.setFocusable(false);
  }

  @Override public void onResume() {
    super.onResume();
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
  /* Master */

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }

  /* Rent */

  /* Rented */
  @OnItemSelected(R.id.rented_sp_lock) public void lockSelect(int index) {
    if (spinnerFirstSelect) {
      spinnerFirstSelect = false;
      return;
    }
    Toast.makeText(getContext(), presenter.getLockList().get(index), Toast.LENGTH_SHORT).show();
  }

  @OnClick(R.id.rented_et_start_time) public void startTimeClick() {
    DateTimePicker dateTimePicKer =
        new DateTimePicker(getActivity(), etStartTime.getText().toString());
    dateTimePicKer.dateTimePicKDialog(etStartTime);
  }

  @OnClick(R.id.rented_et_end_time) public void endTimeClick() {
    DateTimePicker dateTimePicKer =
        new DateTimePicker(getActivity(), etEndTime.getText().toString());
    dateTimePicKer.dateTimePicKDialog(etEndTime);
  }

  @OnClick(R.id.rented_btn_rented) public void rentedRentedClick() {
    if (etName.getText() == null || etName.getText().length() == 0) {
      toaster.showText(getString(R.string.please_input) + getString(R.string.name));
    } else if (DateTimeFormat.dtToLong(etStartTime.getText().toString()) > DateTimeFormat.dtToLong(
        etEndTime.getText().toString())) {
      toaster.showText(getString(R.string.message_se_time));
    } else if (etAddress.getText() == null || etAddress.getText().length() == 0) {
      toaster.showText(getString(R.string.please_input) + getString(R.string.address));
    }
    //toaster.showText(DateTimeFormat.dtformat(etStartTime.getText().toString()));
  }
}
