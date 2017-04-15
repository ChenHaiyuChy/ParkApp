package com.cqut.haiyuchen.parkapp.presentation.account;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.ui.AuxiliaryActivity;

/**
 * Created by haiyu.chen on 2017/4/15.
 */

public class ChangePasswordActivity extends AuxiliaryActivity {

  @BindView(R.id.change_password_et_phone_number) EditText etPhoneNumber;
  @BindView(R.id.change_password_et_old_password) EditText etOldPassword;
  @BindView(R.id.change_password_et_new_password) EditText etNewPassword;
  @BindView(R.id.change_password_iv_old_password) ImageView ivOldPassword;
  @BindView(R.id.change_password_iv_new_password) ImageView ivNewPassword;
  @BindView(R.id.change_password_btn_change_password) Button btnChangePassword;
  @BindView(R.id.change_password_ib_back) ImageButton ibBack;

  @Override public int layoutResId() {
    return R.layout.activity_change_password;
  }

  @Override public void onInit() {
    super.onInit();
    setChangePasswordEnabled(false);
    etPhoneNumber.setText(PreferencesManager.getInstance().getPhoneNumber());
    etPhoneNumber.setEnabled(false);
    etPhoneNumber.setFocusable(false);
  }

  @OnClick(R.id.change_password_iv_old_password) public void ivShowOldPassword() {
    boolean shouldShowPassword =
        etOldPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance();
    TransformationMethod method = shouldShowPassword ? HideReturnsTransformationMethod.getInstance()
        : PasswordTransformationMethod.getInstance();
    ivOldPassword.setImageResource(
        shouldShowPassword ? R.drawable.ic_password_invisible : R.drawable.ic_password_visible);
    etOldPassword.setTransformationMethod(method);
  }

  @OnClick(R.id.change_password_iv_new_password) public void ivShowNewdPassword() {
    boolean shouldShowPassword =
        etNewPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance();
    TransformationMethod method = shouldShowPassword ? HideReturnsTransformationMethod.getInstance()
        : PasswordTransformationMethod.getInstance();
    ivNewPassword.setImageResource(
        shouldShowPassword ? R.drawable.ic_password_invisible : R.drawable.ic_password_visible);
    etNewPassword.setTransformationMethod(method);
  }

  @OnTextChanged(value = {
      R.id.change_password_et_phone_number, R.id.change_password_et_old_password,
      R.id.change_password_et_new_password
  }, callback = OnTextChanged.Callback.TEXT_CHANGED) public void etTextChanged() {
    if (etPhoneNumber.getText().length() == 0
        || etOldPassword.getText().length() == 0
        || etNewPassword.getText().length() == 0) {
      setChangePasswordEnabled(false);
    } else {
      setChangePasswordEnabled(true);
    }
  }

  @OnClick(R.id.change_password_ib_back) public void ibBackClick() {
    this.finish();
  }

  @OnClick(R.id.change_password_btn_change_password) public void btnChangePassword() {

  }

  public void setChangePasswordEnabled(boolean enabled) {
    btnChangePassword.setEnabled(enabled);
  }
}
