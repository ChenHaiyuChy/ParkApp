package com.cqut.haiyuchen.parkapp.di.modules.account;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.account.LoginView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/5.
 */
@Module public class LoginModule {
  private LoginView loginView;

  public LoginModule(LoginView loginView) {
    this.loginView = loginView;
  }

  @Provides @ActivityScope LoginView provideLoginView() {
    return loginView;
  }
}
