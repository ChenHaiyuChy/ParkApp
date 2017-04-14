package com.cqut.haiyuchen.parkapp.di.modules.personal;

import com.cqut.haiyuchen.parkapp.di.ActivityScope;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalInfoView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by haiyu.chen on 2017/4/12.
 */
@Module public class PersonalInfoModule {
  private PersonalInfoView personalInfView;

  public PersonalInfoModule(PersonalInfoView personalInfView) {
    this.personalInfView = personalInfView;
  }

  @Provides @ActivityScope PersonalInfoView providePersonalInfoView() {
    return personalInfView;
  }
}
