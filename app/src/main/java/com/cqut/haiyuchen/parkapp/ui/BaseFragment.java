package com.cqut.haiyuchen.parkapp.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import com.cqut.haiyuchen.parkapp.di.BaseApplication;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseToast;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public abstract class BaseFragment<T extends AppPresenter> extends Fragment {
  private ProgressDialog progressDialog;
  protected PreferencesManager preferencesManager;
  protected BaseToast toaster;
  @Inject protected T presenter;
  private Unbinder unbinder;
  private View view;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(layoutResId(), container, false);
    onInit();
    presenter.attach();
    return view;
  }

  protected AppComponent getAppComponent() {
    return BaseApplication.getInstance().getAppComponent();
  }

  public abstract int layoutResId();

  public void onInit() {
    unbinder = ButterKnife.bind(this, view);
    unbinder = ButterKnife.bind(this, view);
    preferencesManager = new PreferencesManager(getActivity().getApplication());
    toaster = new BaseToast();
  }

  @Override public void onDestroyView() {
    unbinder.unbind();
    presenter.detach();
    super.onDestroyView();
  }

  protected void showLoadingDialog(String message) {
    if (progressDialog == null) {
      progressDialog = new ProgressDialog(getActivity());
      progressDialog.setCanceledOnTouchOutside(false);
      progressDialog.setCancelable(false);
    }
    progressDialog.setMessage(message);
    progressDialog.show();
  }

  protected void showLoadingDialog() {
    showLoadingDialog("加载中...");
  }

  protected void hideLoadingDialog() {
    if (progressDialog != null && progressDialog.isShowing()) {
      progressDialog.dismiss();
    }
  }
}
