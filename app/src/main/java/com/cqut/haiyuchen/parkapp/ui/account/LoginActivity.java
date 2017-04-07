package com.cqut.haiyuchen.parkapp.ui.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.di.components.DaggerLoginComponent;
import com.cqut.haiyuchen.parkapp.di.components.LoginComponent;
import com.cqut.haiyuchen.parkapp.di.modules.LoginModule;
import com.cqut.haiyuchen.parkapp.presentation.account.LoginPresenter;
import com.cqut.haiyuchen.parkapp.presentation.account.LoginView;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseActivity;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {
  @BindView(R.id.login_et_username) TextView loginEtUsername;
  @BindView(R.id.login_tv_result) TextView loginTvResult;
  @BindView(R.id.login_btn_login) Button loginBtnLogin;

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
  }

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }

  @Override public void loginResult(String result) {
    loginTvResult.setText(result);
  }

  @OnClick(R.id.login_btn_login) void login() {
    presenter.login();
  }
}
