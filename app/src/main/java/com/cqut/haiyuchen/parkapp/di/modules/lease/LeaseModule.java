package com.cqut.haiyuchen.parkapp.di.modules.lease;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.lease.LeaseView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/27.
 */
@Module public class LeaseModule {
  private LeaseView leaseView;

  public LeaseModule(LeaseView leaseView) {
    this.leaseView = leaseView;
  }

  @Provides @ActivityScope LeaseView provideLeaseView() {
    return leaseView;
  }
}
