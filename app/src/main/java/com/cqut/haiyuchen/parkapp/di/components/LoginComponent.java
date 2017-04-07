package com.cqut.haiyuchen.parkapp.di.components;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.LoginModule;
import com.cqut.haiyuchen.parkapp.presentation.account.LoginPresenter;
import com.cqut.haiyuchen.parkapp.ui.account.LoginActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/5.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = { LoginModule.class })
public interface LoginComponent {
  void inject(LoginActivity loginActivity);

  void inject(LoginPresenter loginPresenter);
}
