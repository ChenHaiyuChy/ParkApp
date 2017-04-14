package com.cqut.haiyuchen.parkapp.presentation.account;

import com.cqut.haiyuchen.parkapp.di.MvpView;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public interface LoginView extends MvpView{
  void loginResult(boolean success,String message);
  void initEdits();
  void showDialog();
  void hideDialog();
}
