package com.cqut.haiyuchen.parkapp.di.components.service;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.service.ServiceModule;
import com.cqut.haiyuchen.parkapp.presentation.service.ServicePresenter;
import com.cqut.haiyuchen.parkapp.ui.service.ServiceActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/27.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = { ServiceModule.class })
public interface ServiceComponent {
  void inject(ServiceActivity serviceActivity);

  void inject(ServicePresenter servicePresenter);
}
