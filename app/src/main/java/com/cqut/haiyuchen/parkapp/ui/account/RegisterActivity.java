package com.cqut.haiyuchen.parkapp.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.mock.SmsCaptcha;
import com.cqut.haiyuchen.parkapp.di.components.account.DaggerRegisterComponent;
import com.cqut.haiyuchen.parkapp.di.components.account.RegisterComponent;
import com.cqut.haiyuchen.parkapp.di.modules.account.RegisterModule;
import com.cqut.haiyuchen.parkapp.presentation.account.RegisterPresenter;
import com.cqut.haiyuchen.parkapp.presentation.account.RegisterView;
import com.cqut.haiyuchen.parkapp.ui.BaseActivity;
import com.cqut.haiyuchen.parkapp.ui.home.HomeTabActivity;
import com.cqut.haiyuchen.parkapp.ui.untils.StringCheckUtils;
import com.squareup.phrase.Phrase;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {

  @BindView(R.id.register_et_phone_number) EditText etPhoneNumber;
  @BindView(R.id.register_et_password) EditText etPassword;
  @BindView(R.id.register_et_captcha) EditText etCaptcha;
  @BindView(R.id.register_iv_password) ImageView ivPassword;
  @BindView(R.id.register_btn_fetch_captcha) TextView btnFetchCaptcha;
  @BindView(R.id.register_btn_register) Button btnRegister;
  @BindView(R.id.register_ib_back) ImageButton ivBack;

  private int TIME_SECOND = 60;
  private final Handler handler = new Handler();
  private final Runnable runnable = new Runnable() {
    @Override public void run() {
      if (TIME_SECOND < 0) {
        TIME_SECOND = 60;
        btnFetchCaptcha.setEnabled(true);
        btnFetchCaptcha.setText(getString(R.string.get_sms_captch));
        handler.removeCallbacks(runnable);
      } else {
        btnFetchCaptcha.setText((Phrase.from(getApplication(), R.string.captcha_resend)
            .put("second", TIME_SECOND + "")
            .format()
            .toString()));
        TIME_SECOND--;
        handler.postDelayed(this, 1000);
      }
    }
  };

  @Override public int layoutResId() {
    return R.layout.activity_register;
  }

  @Override public void onInit(@Nullable Bundle savedInstanceState) {
    super.onInit(savedInstanceState);
    RegisterComponent component = DaggerRegisterComponent.builder()
        .appComponent(getAppComponent())
        .registerModule(new RegisterModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
    setRegisterButtonEnabled(false);
  }

  @Override public void registerResult(boolean success, String message) {
    if (success) {
      presenter.saveRegisterInfo();
      this.finish();
      startActivity(new Intent(this, HomeTabActivity.class));
    } else {
      toaster.showText(message);
    }
  }

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }

  @OnTextChanged(value = {
      R.id.register_et_phone_number, R.id.register_et_password, R.id.register_et_captcha
  }, callback = OnTextChanged.Callback.TEXT_CHANGED) public void etTextChanged() {
    if (etPhoneNumber.getText().length() == 0
        || etPassword.getText().length() == 0
        || etCaptcha.getText().length() == 0) {
      setRegisterButtonEnabled(false);
    } else {
      setRegisterButtonEnabled(true);
    }
  }

  @OnTextChanged(value = R.id.register_et_phone_number, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
  public void phoneTextChanged() {
    presenter.resetSmsCaptcha();
  }

  @OnClick(R.id.register_iv_password) public void showPassword() {
    boolean shouldShowPassword =
        etPassword.getTransformationMethod() == PasswordTransformationMethod.getInstance();
    TransformationMethod method = shouldShowPassword ? HideReturnsTransformationMethod.getInstance()
        : PasswordTransformationMethod.getInstance();
    ivPassword.setImageResource(
        shouldShowPassword ? R.drawable.ic_password_invisible : R.drawable.ic_password_visible);
    etPassword.setTransformationMethod(method);
  }

  public void setRegisterButtonEnabled(boolean enabled) {
    btnRegister.setEnabled(enabled);
  }

  @OnClick(R.id.register_btn_fetch_captcha) public void fetchCaptcha() {
    if (!StringCheckUtils.checkMobile(etPhoneNumber.getText().toString())) {
      toaster.showText(getString(R.string.input_right_phone_number));
    } else {
      btnFetchCaptcha.setEnabled(false);
      handler.post(runnable);
      //获取假的验证码
      presenter.setSmsCaptcha(SmsCaptcha.getSmsCaptcha());
    }
  }

  @OnClick(R.id.register_btn_register) public void registerSubmit() {
    if (!StringCheckUtils.checkMobile(etPhoneNumber.getText().toString())) {
      toaster.showText(getString(R.string.input_right_phone_number));
    } else if (presenter.getSmsCaptcha().equals("")) {
      toaster.showText(getString(R.string.need_fetch_captcha));
    } else if (!presenter.getSmsCaptcha().equals(etCaptcha.getText().toString())) {
      toaster.showText(getString(R.string.input_right_captcha));
    } else {
      presenter.saveRegisterInfo(etPhoneNumber.getText().toString(),
          etPassword.getText().toString(), etCaptcha.getText().toString());
      presenter.register();
    }
  }

  @OnClick(R.id.register_ib_back) public void backToLogin() {
    this.finish();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.detach();
    handler.removeCallbacks(runnable);
  }
}
