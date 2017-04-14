package com.cqut.haiyuchen.parkapp.ui.personal;

import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.di.components.personal.DaggerPersonalComponent;
import com.cqut.haiyuchen.parkapp.di.components.personal.PersonalComponent;
import com.cqut.haiyuchen.parkapp.di.modules.personal.PersonalModule;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalPresenter;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalView;
import com.cqut.haiyuchen.parkapp.ui.BaseFragment;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class PersonalActivity extends BaseFragment<PersonalPresenter> implements PersonalView {
  @BindView(R.id.personal_tv_test) TextView test;
  @Override public int layoutResId() {
    return R.layout.activity_personal;
  }

  @Override public void onInit() {
    super.onInit();
    PersonalComponent component = DaggerPersonalComponent.builder()
        .appComponent(getAppComponent())
        .personalModule(new PersonalModule(this))
        .build();
    component.inject(this);
    component.inject(presenter);
  }

  @Override public void showDialog() {
    showLoadingDialog();
  }

  @Override public void hideDialog() {
    hideLoadingDialog();
  }
  @OnClick(R.id.personal_tv_test) void testOnClick(){
    presenter.getPersonalInfo();
  }

  @Override public void viewModify() {

  }
}
