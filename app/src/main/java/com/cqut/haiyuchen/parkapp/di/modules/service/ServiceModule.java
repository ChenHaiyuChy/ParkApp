package com.cqut.haiyuchen.parkapp.di.modules.service;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.service.ServiceView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/27.
 */
@Module public class ServiceModule {
  private ServiceView serviceView;

  public ServiceModule(ServiceView serviceView) {
    this.serviceView = serviceView;
  }

  @Provides @ActivityScope ServiceView provideServiceView() {
    return serviceView;
  }
}
