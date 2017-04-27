package com.cqut.haiyuchen.parkapp.di.modules.account;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.account.ChangePasswordView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/27.
 */
@Module public class ChangePasswordModule {
  private ChangePasswordView changePasswordView;

  public ChangePasswordModule(ChangePasswordView changePasswordView) {
    this.changePasswordView = changePasswordView;
  }

  @Provides @ActivityScope ChangePasswordView provideChangePasswordView() {
    return changePasswordView;
  }
}
