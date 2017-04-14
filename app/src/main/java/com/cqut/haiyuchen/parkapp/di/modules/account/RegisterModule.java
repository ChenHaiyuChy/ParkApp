package com.cqut.haiyuchen.parkapp.di.modules.account;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.account.RegisterView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/14.
 */

@Module public class RegisterModule {
  private RegisterView registerView;

  public RegisterModule(RegisterView registerView) {
    this.registerView = registerView;
  }

  @Provides @ActivityScope RegisterView provideRegisterView() {
    return registerView;
  }
}
