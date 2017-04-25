package com.cqut.haiyuchen.parkapp.ui.personal;

import android.content.Intent;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.data.ConfigInternal;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.di.components.personal.DaggerPersonalComponent;
import com.cqut.haiyuchen.parkapp.di.components.personal.PersonalComponent;
import com.cqut.haiyuchen.parkapp.di.modules.personal.PersonalModule;
import com.cqut.haiyuchen.parkapp.ui.account.ChangePasswordActivity;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalPresenter;
import com.cqut.haiyuchen.parkapp.presentation.personal.PersonalView;
import com.cqut.haiyuchen.parkapp.ui.BaseFragment;
import com.cqut.haiyuchen.parkapp.ui.account.LoginActivity;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class PersonalActivity extends BaseFragment<PersonalPresenter> implements PersonalView {

  @BindView(R.id.personal_view_info) View viewInfo;
  @BindView(R.id.personal_view_my_collection) View viewCollection;
  @BindView(R.id.personal_view_history_order) View viewOrder;
  @BindView(R.id.personal_view_lock_manage) View viewLock;
  @BindView(R.id.personal_view_modify_password) View viewPasswrod;
  @BindView(R.id.personal_view_version_update) View viewVersion;
  @BindView(R.id.personal_view_share_to_friends) View viewShare;
  @BindView(R.id.personal_view_contact_service) View viewService;
  @BindView(R.id.personal_view_sign_out) View viewSignout;

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

  @Override public void viewModify() {

  }

  @Override public void doShare(Intent intent) {
    startActivity(Intent.createChooser(intent, getString(R.string.share_to_friends)));
  }

  @Override public void doCallService(Intent intent) {
    startActivity(intent);
  }

  @OnClick(R.id.personal_view_info) public void infoClick() {
    startActivity(new Intent(getContext(), PersonalInfoActivity.class));
  }

  @OnClick(R.id.personal_view_my_collection) public void collectionClick() {

  }

  @OnClick(R.id.personal_view_history_order) public void orderClick() {

  }

  @OnClick(R.id.personal_view_lock_manage) public void lockClick() {

  }

  @OnClick(R.id.personal_view_modify_password) public void passwordClick() {
    startActivity(new Intent(getContext(), ChangePasswordActivity.class));
  }

  @OnClick(R.id.personal_view_version_update) public void versionClick() {

  }

  @OnClick(R.id.personal_view_share_to_friends) public void shareClick() {
    presenter.shareMsg(getString(R.string.share_title_message),
        ConfigInternal.PARK_APP_DOWNLOAD_PATH);
  }

  @OnClick(R.id.personal_view_contact_service) public void serviceClick() {
    presenter.callService(getString(R.string.call_service_number));
  }

  @OnClick(R.id.personal_view_sign_out) public void signoutClick() {
    PreferencesManager.getInstance().setLogged(false);
    getActivity().finish();
    startActivity(new Intent(getContext(), LoginActivity.class).setFlags(
        Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
  }
}
