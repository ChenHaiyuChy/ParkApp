package com.cqut.haiyuchen.parkapp.di.components.lease;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.lease.LeaseModule;
import com.cqut.haiyuchen.parkapp.presentation.lease.LeasePresenter;
import com.cqut.haiyuchen.parkapp.ui.lease.LeaseActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/27.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = { LeaseModule.class })
public interface LeaseComponent {
  void inject(LeaseActivity leaseActivity);

  void inject(LeasePresenter leasePresenter);
}
