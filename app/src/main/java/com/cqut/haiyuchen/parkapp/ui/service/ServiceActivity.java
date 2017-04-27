package com.cqut.haiyuchen.parkapp.ui.service;

import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.di.components.service.DaggerServiceComponent;
import com.cqut.haiyuchen.parkapp.di.components.service.ServiceComponent;
import com.cqut.haiyuchen.parkapp.di.modules.service.ServiceModule;
import com.cqut.haiyuchen.parkapp.presentation.service.ServicePresenter;
import com.cqut.haiyuchen.parkapp.presentation.service.ServiceView;
import com.cqut.haiyuchen.parkapp.ui.BaseFragment;

/**
 * Created by haiyu.chen on 2017/4/1.
 */

public class ServiceActivity extends BaseFragment<ServicePresenter> implements ServiceView {

  @Override public int layoutResId() {
    return R.layout.activity_service;
  }

  @Override public void onInit() {
    super.onInit();
    ServiceComponent component = DaggerServiceComponent.builder()
        .appComponent(getAppComponent())
        .serviceModule(new ServiceModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
  }

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }
}
