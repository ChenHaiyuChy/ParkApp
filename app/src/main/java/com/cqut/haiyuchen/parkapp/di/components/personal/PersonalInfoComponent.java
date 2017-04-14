package com.cqut.haiyuchen.parkapp.di.components.personal;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.personal.PersonalInfoModule;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalInfoPresenter;
import com.cqut.haiyuchen.parkapp.ui.personal.PersonalInfoActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/12.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = { PersonalInfoModule.class })
public interface PersonalInfoComponent {
  void inject(PersonalInfoActivity personalInfoActivity);

  void inject(PersonalInfoPresenter personalInfoPresenter);
}
