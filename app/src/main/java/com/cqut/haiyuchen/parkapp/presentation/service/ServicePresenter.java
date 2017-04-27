package com.cqut.haiyuchen.parkapp.presentation.service;

import com.cqut.haiyuchen.parkapp.common.network.APIService;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/4/27.
 */

public class ServicePresenter extends AppPresenter<ServiceView> {
  @Inject APIService serverApi;

  @Inject public ServicePresenter(ServiceView serviceView) {
    super(serviceView);
    baseView = serviceView;
  }

  @Override public void attach() {

  }

  @Override public void detach() {

  }
}
