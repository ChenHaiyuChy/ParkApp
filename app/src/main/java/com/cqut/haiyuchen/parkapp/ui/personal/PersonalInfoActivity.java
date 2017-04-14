package com.cqut.haiyuchen.parkapp.ui.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.cqut.haiyuchen.parkapp.di.components.personal.DaggerPersonalInfoComponent;
import com.cqut.haiyuchen.parkapp.di.components.personal.PersonalInfoComponent;
import com.cqut.haiyuchen.parkapp.di.modules.personal.PersonalInfoModule;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalInfoView;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalInfoPresenter;
import com.cqut.haiyuchen.parkapp.ui.BaseActivity;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public class PersonalInfoActivity extends BaseActivity<PersonalInfoPresenter>
    implements PersonalInfoView {

  @Override public int layoutResId() {
    return 0;
  }

  @Override public void onInit(@Nullable Bundle savedInstanceState) {
    super.onInit(savedInstanceState);
    super.onInit(savedInstanceState);
    PersonalInfoComponent component = DaggerPersonalInfoComponent.builder()
        .appComponent(getAppComponent())
        .personalInfoModule(new PersonalInfoModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
  }

  @Override public void showDialog() {

  }

  @Override public void hideDialog() {

  }

  @Override public void viewModify() {

  }
}
