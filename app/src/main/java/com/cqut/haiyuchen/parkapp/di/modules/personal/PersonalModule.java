package com.cqut.haiyuchen.parkapp.di.modules.personal;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

@Module public class PersonalModule {
  private PersonalView personalView;

  public PersonalModule(PersonalView personalView) {
    this.personalView = personalView;
  }

  @Provides @ActivityScope PersonalView providePersonalView() {
    return personalView;
  }
}
