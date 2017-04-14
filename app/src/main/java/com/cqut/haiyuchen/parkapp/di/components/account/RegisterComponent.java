package com.cqut.haiyuchen.parkapp.di.components.account;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.account.RegisterModule;
import com.cqut.haiyuchen.parkapp.presentation.account.RegisterPresenter;
import com.cqut.haiyuchen.parkapp.ui.account.RegisterActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/14.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = { RegisterModule.class })
public interface RegisterComponent {

  void inject(RegisterActivity registerActivity);

  void inject(RegisterPresenter registerPresenter);
}
