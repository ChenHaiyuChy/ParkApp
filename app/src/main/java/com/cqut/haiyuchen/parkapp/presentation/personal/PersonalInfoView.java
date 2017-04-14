package com.cqut.haiyuchen.parkapp.presentation.personal;

import com.cqut.haiyuchen.parkapp.di.MvpView;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public interface PersonalInfoView extends MvpView {
  void viewModify();

  void showDialog();

  void hideDialog();
}
