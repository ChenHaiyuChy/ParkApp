package com.cqut.haiyuchen.parkapp.presentation.account;

import com.cqut.haiyuchen.parkapp.di.MvpView;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public interface LoginView extends MvpView{
  void loginResult(String result);
  void showDialog();
  void hideDialog();
}
