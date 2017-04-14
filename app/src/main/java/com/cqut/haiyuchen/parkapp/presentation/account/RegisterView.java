package com.cqut.haiyuchen.parkapp.presentation.account;

import com.cqut.haiyuchen.parkapp.di.MvpView;

/**
 * Created by haiyu.chen on 2017/4/14.
 */

public interface RegisterView extends MvpView {
  void registerResult(boolean success, String message);

  void showDialog();

  void hideDialog();
}
