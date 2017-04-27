package com.cqut.haiyuchen.parkapp.presentation.account;

import com.cqut.haiyuchen.parkapp.common.network.APIService;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/4/27.
 */

public class ChangePasswordPresenter extends AppPresenter<ChangePasswordView> {
  @Inject APIService serverApi;

  @Inject public ChangePasswordPresenter(ChangePasswordView changePasswordView) {
    super(changePasswordView);
    baseView = changePasswordView;
  }

  @Override public void attach() {

  }

  @Override public void detach() {

  }
}
