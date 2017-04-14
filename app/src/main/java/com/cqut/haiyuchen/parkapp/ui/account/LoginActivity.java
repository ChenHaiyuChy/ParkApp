package com.cqut.haiyuchen.parkapp.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.di.components.account.DaggerLoginComponent;
import com.cqut.haiyuchen.parkapp.di.components.account.LoginComponent;
import com.cqut.haiyuchen.parkapp.di.modules.account.LoginModule;
import com.cqut.haiyuchen.parkapp.presentation.account.LoginPresenter;
import com.cqut.haiyuchen.parkapp.presentation.account.LoginView;
import com.cqut.haiyuchen.parkapp.ui.BaseActivity;
import com.cqut.haiyuchen.parkapp.ui.home.HomeTabActivity;
import com.cqut.haiyuchen.parkapp.ui.untils.StringCheckUtils;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {
  @BindView(R.id.login_et_phone_number) TextView etPhoneNumber;
  @BindView(R.id.login_et_password) TextView etPassword;
  @BindView(R.id.login_iv_password) ImageView ivPassword;
  @BindView(R.id.login_btn_login) Button btnLogin;
  @BindView(R.id.login_tv_forget_password) TextView tvForgetPassword;
  @BindView(R.id.login_tv_register) TextView tvRegister;

  @Override public int layoutResId() {
    return R.layout.activity_login;
  }

  @Override public void onInit(@Nullable Bundle savedInstanceState) {
    super.onInit(savedInstanceState);
    LoginComponent component = DaggerLoginComponent.builder()
        .appComponent(getAppComponent())
        .loginModule(new LoginModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
    setLoginButtonEnabled(false);
    presenter.initEdits();
  }

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }

  @Override public void loginResult(boolean success, String message) {
    if (success) {
      presenter.saveLoginInfo(getApplication());
      this.finish();
      startActivity(new Intent(this, HomeTabActivity.class));
    } else {
      toaster.showText(message);
    }
  }

  @Override public void initEdits() {
    etPhoneNumber.setText(PreferencesManager.getInstance().getPhoneNumber());
    etPassword.setText(PreferencesManager.getInstance().getPassword());
  }

  @OnTextChanged(value = {
      R.id.login_et_phone_number, R.id.login_et_password
  }, callback = OnTextChanged.Callback.TEXT_CHANGED) public void etTextChanged() {
    if (etPhoneNumber.getText().length() == 0 || etPassword.getText().length() == 0) {
      setLoginButtonEnabled(false);
    } else {
      setLoginButtonEnabled(true);
    }
  }

  @OnClick(R.id.login_iv_password) public void showPassword() {
    boolean shouldShowPassword =
        etPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance();
    TransformationMethod method = shouldShowPassword ? HideReturnsTransformationMethod.getInstance()
        : PasswordTransformationMethod.getInstance();
    ivPassword.setImageResource(
        shouldShowPassword ? R.drawable.ic_password_invisible : R.drawable.ic_password_visible);
    etPassword.setTransformationMethod(method);
  }

  public void setLoginButtonEnabled(boolean enabled) {
    btnLogin.setEnabled(enabled);
  }

  @OnClick(R.id.login_btn_login) public void loginSubmit() {
    if (!StringCheckUtils.checkMobile(etPhoneNumber.getText().toString())) {
      toaster.showText(getString(R.string.input_right_phone_number));
    } else {
      presenter.setLoginInfo(etPhoneNumber.getText().toString(), etPassword.getText().toString());
      presenter.login();
    }
  }

  @OnClick(R.id.login_tv_forget_password) public void forgetPassword() {
    //startActivity(new Intent(this, RegisterActivity.class));
  }

  @OnClick(R.id.login_tv_register) public void gotoRegister() {
    startActivity(new Intent(this, RegisterActivity.class));
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detach();
  }
}
