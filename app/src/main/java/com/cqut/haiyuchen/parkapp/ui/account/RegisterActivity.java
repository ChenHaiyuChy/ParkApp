package com.cqut.haiyuchen.parkapp.ui.account;

import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.mock.SmsCaptcha;
import com.cqut.haiyuchen.parkapp.ui.AuxiliaryActivity;
import com.cqut.haiyuchen.parkapp.ui.untils.StringCheckUtils;
import com.squareup.phrase.Phrase;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public class RegisterActivity extends AuxiliaryActivity {

  @BindView(R.id.register_et_phone_number) EditText etPhoneNumber;
  @BindView(R.id.register_et_password) EditText etPassword;
  @BindView(R.id.register_et_captcha) EditText etCaptcha;
  @BindView(R.id.register_iv_password) ImageView ivPassword;
  @BindView(R.id.register_btn_fetch_captcha) TextView btnFetchCaptcha;
  @BindView(R.id.register_btn_register) Button btnRegister;

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

  private String smsCaptcha = "";

  @Override public int layoutResId() {
    return R.layout.activity_register;
  }

  @Override public void onInit() {
    super.onInit();
    setRegisterButtonEnabled(false);
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
    smsCaptcha = "";
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
      smsCaptcha = SmsCaptcha.getSmsCaptcha();
    }
  }

  @OnClick(R.id.register_btn_register) public void registerSubmit() {
    if (!StringCheckUtils.checkMobile(etPhoneNumber.getText().toString())) {
      toaster.showText(getString(R.string.input_right_phone_number));
    } else if (smsCaptcha.equals("")) {
      toaster.showText(getString(R.string.need_fetch_captcha));
    } else if (!smsCaptcha.equals(etCaptcha.getText().toString())) {
      toaster.showText(getString(R.string.input_right_captcha));
    } else {

    }
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    handler.removeCallbacks(runnable);
  }
}
