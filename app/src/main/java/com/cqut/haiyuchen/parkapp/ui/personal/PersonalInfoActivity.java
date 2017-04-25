package com.cqut.haiyuchen.parkapp.ui.personal;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.di.components.personal.DaggerPersonalInfoComponent;
import com.cqut.haiyuchen.parkapp.di.components.personal.PersonalInfoComponent;
import com.cqut.haiyuchen.parkapp.di.modules.personal.PersonalInfoModule;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalInfoPresenter;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalInfoView;
import com.cqut.haiyuchen.parkapp.ui.BaseActivity;
import java.util.Date;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public class PersonalInfoActivity extends BaseActivity<PersonalInfoPresenter>
    implements PersonalInfoView {

  @BindView(R.id.personal_info_et_nick_name) EditText etNickName;
  @BindView(R.id.personal_info_rg_sex) RadioGroup rgSex;
  @BindView(R.id.personal_info_rb_sex_male) RadioButton rbMale;
  @BindView(R.id.personal_info_rb_sex_female) RadioButton rbFemale;
  @BindView(R.id.personal_info_et_birthday) EditText etBirthday;
  @BindView(R.id.personal_info_et_email) EditText etEmail;
  @BindView(R.id.personal_info_et_address) EditText etAddress;
  @BindView(R.id.personal_info_et_address_detail) EditText etAddressDetail;
  @BindView(R.id.personal_info_et_mobile) EditText etMobile;
  @BindView(R.id.personal_info_et_car_number) EditText etCarNumber;
  @BindView(R.id.personal_info_et_account) EditText etAccount;
  @BindView(R.id.personal_info_ib_back) ImageButton ibBack;
  @BindView(R.id.personal_info_btn_save) Button btnSave;

  private DatePickerDialog datePickerDialog;

  @Override public int layoutResId() {
    return R.layout.activity_personal_info;
  }

  @Override public void onInit(@Nullable Bundle savedInstanceState) {
    super.onInit(savedInstanceState);
    super.onInit(savedInstanceState);
    PersonalInfoComponent component = DaggerPersonalInfoComponent.builder()
        .appComponent(getAppComponent())
        .personalInfoModule(new PersonalInfoModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
    controlsInit();
  }

  public void controlsInit() {
    etMobile.setText(PreferencesManager.getInstance().getPhoneNumber());
    etMobile.setFocusable(false);
    etBirthday.setFocusable(false);

    presenter.dateInit();
    datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
      @Override public void onDateSet(DatePicker view, int year, int month, int day) {
        presenter.setDate(year, month, day);
        etBirthday.setText(presenter.getTextDate());
      }
    }, presenter.getYear(), presenter.getMonth(), presenter.getDay());
    datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
    datePickerDialog.getDatePicker().setMinDate(presenter.getMinDate());
    datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.today),
        new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            presenter.dateInit();
            datePickerDialog.onDateChanged(datePickerDialog.getDatePicker(), presenter.getYear(),
                presenter.getMonth(), presenter.getDay());
          }
        });
  }

  @OnClick(R.id.personal_info_et_birthday) public void birthClick() {
    datePickerDialog.onDateChanged(datePickerDialog.getDatePicker(), presenter.getYear(),
        presenter.getMonth(), presenter.getDay());
    if (!datePickerDialog.isShowing()) {
      datePickerDialog.show();
    }
  }

  @OnClick(R.id.personal_info_ib_back) public void backClick() {
    this.finish();
  }

  @OnClick(R.id.personal_info_btn_save) public void saveClick() {
    toaster.showText(rbMale.isChecked() ? "1" : "0");
  }

  @Override protected void onResume() {
    super.onResume();
    presenter.dateInit();
  }

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }

  @Override public void viewModify() {

  }
}
