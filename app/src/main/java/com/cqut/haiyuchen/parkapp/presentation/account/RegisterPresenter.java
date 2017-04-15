package com.cqut.haiyuchen.parkapp.presentation.account;

import android.app.Application;
import com.cqut.haiyuchen.parkapp.common.network.APIService;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.data.model.RegisterInfo;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/4/14.
 */

public class RegisterPresenter extends AppPresenter<RegisterView> {
  @Inject APIService serverApi;
  private RegisterInfo registerInfo;

  @Inject public RegisterPresenter(RegisterView registerView) {
    super(registerView);
    baseView = registerView;
  }

  @Override public void attach() {

  }

  public void saveRegisterInfo(String phoneNumber, String password, String captcha) {
    registerInfo.setPhoneNumber(phoneNumber);
    registerInfo.setPassword(password);
    registerInfo.setSmsCaptcha(captcha);
  }

  public String getSmsCaptcha() {
    return registerInfo.getSmsCaptcha();
  }

  public void setSmsCaptcha(String captcha) {
    registerInfo.setSmsCaptcha(captcha);
  }

  public void resetSmsCaptcha() {
    registerInfo.setSmsCaptcha("");
  }

  public void register() {
    baseView.registerResult(true, "");
  }

  public void saveRegisterInfo() {
    PreferencesManager.getInstance()
        .saveLoginInfo(registerInfo.getPhoneNumber(), registerInfo.getPassword(), true);
  }

  @Override public void detach() {
    registerInfo = null;
  }
}
