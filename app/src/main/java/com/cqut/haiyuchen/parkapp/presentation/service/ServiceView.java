package com.cqut.haiyuchen.parkapp.presentation.service;

import com.cqut.haiyuchen.parkapp.di.MvpView;

/**
 * Created by haiyu.chen on 2017/4/27.
 */

public interface ServiceView extends MvpView {
  void showDialog();

  void hideDialog();
}
