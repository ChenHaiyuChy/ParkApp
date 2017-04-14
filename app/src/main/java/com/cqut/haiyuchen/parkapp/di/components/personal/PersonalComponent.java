package com.cqut.haiyuchen.parkapp.di.components.personal;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.modules.personal.PersonalModule;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalPresenter;
import com.cqut.haiyuchen.parkapp.ui.personal.PersonalActivity;
import dagger.Component;

/**
 * Created by haiyu.chen on 2017/4/12.
 */
@ActivityScope @Component(dependencies = AppComponent.class, modules = { PersonalModule.class })
public interface PersonalComponent {
  void inject(PersonalActivity personalActivity);

  void inject(PersonalPresenter personalPresenter);
}
