package com.cqut.haiyuchen.parkapp.presentation.account;

import android.app.Application;
import com.cqut.haiyuchen.parkapp.common.network.APIService;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.data.model.LoginInfo;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public class LoginPresenter extends AppPresenter<LoginView> {
  @Inject APIService serverApi;
  private LoginInfo loginInfo;

  @Inject public LoginPresenter(LoginView loginView) {
    super(loginView);
    baseView = loginView;
    loginInfo = new LoginInfo();
  }

  @Override public void attach() {

  }

  @Override public void detach() {
    loginInfo = null;
  }

  public void setLoginInfo(String phoneNUmber, String password) {
    loginInfo.setPhoneNumber(phoneNUmber);
    loginInfo.setPassword(password);
  }

  public void saveLoginInfo(Application application) {
    PreferencesManager.getInstance()
        .saveLoginInfo(loginInfo.getPhoneNumber(), loginInfo.getPassword(), true);
  }

  public void initEdits() {
    if (PreferencesManager.getInstance().getPhoneNumber().length() > 0) {
      baseView.initEdits();
    }
  }

  public void login() {
    baseView.showDialog();
    if (!loginInfo.getPhoneNumber().equals("13555555555")) {
      baseView.loginResult(false, "电话号码尚未注册");
    } else if (!loginInfo.getPassword().equals("123456")) {
      baseView.loginResult(false, "密码错误");
    } else {
      baseView.loginResult(true, "");
    }
    baseView.hideDialog();
    /*serverApi.requestUrl("小王子", 0, 3)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new EndSubscriber<Book>() {
          @Override public void onEnd() {
            baseView.hideDialog();
            Log.e("end", "end");
          }

          @Override public void onNext(Book map) {
            Log.e("next", map.toString());
          }
        });*/
  }
}
