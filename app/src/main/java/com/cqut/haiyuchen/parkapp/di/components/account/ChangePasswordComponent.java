package com.cqut.haiyuchen.parkapp.di.components.account;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.account.ChangePasswordModule;
import com.cqut.haiyuchen.parkapp.presentation.account.ChangePasswordPresenter;
import com.cqut.haiyuchen.parkapp.ui.account.ChangePasswordActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/27.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = { ChangePasswordModule.class })
public interface ChangePasswordComponent {
  void inject(ChangePasswordActivity changePasswordActivity);

  void inject(ChangePasswordPresenter changePasswordPresenter);
}
