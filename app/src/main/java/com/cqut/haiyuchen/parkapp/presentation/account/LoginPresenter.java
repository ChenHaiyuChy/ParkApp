package com.cqut.haiyuchen.parkapp.presentation.account;

import android.util.Log;
import com.cqut.haiyuchen.parkapp.common.EndSubscriber;
import com.cqut.haiyuchen.parkapp.common.retrofit.ServerApi;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import java.util.Map;
import javax.inject.Inject;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public class LoginPresenter extends AppPresenter<LoginView> {

  @Inject ServerApi serverApi;

  @Inject public LoginPresenter(LoginView loginView) {
    super(loginView);
    baseView = loginView;
  }

  @Override public void attach() {

  }

  @Override public void detach() {

  }

  public void login() {
    baseView.showDialog();
    serverApi.requestUrl("小王子", 0, 3)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new EndSubscriber<Map<String, Object>>() {
          @Override public void onEnd() {
            baseView.hideDialog();
          }

          @Override public void onNext(Map<String, Object> s) {
            baseView.loginResult(s.toString());
          }
        });
  }
}
