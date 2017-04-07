package com.cqut.haiyuchen.parkapp.ui.widget;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.cqut.haiyuchen.parkapp.di.AppComponent;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import com.cqut.haiyuchen.parkapp.di.BaseApplication;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/3/31.
 */

public abstract class BaseActivity<T extends AppPresenter> extends AppCompatActivity {
  private ProgressDialog progressDialog;
  @Inject protected T presenter;

  public abstract int layoutResId();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layoutResId());
    onInit(savedInstanceState);
    presenter.attach();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    hideLoadingDialog();
    presenter.detach();
  }

  protected AppComponent getAppComponent() {
    return BaseApplication.getInstance().getAppComponent();
  }

  public void onInit(@Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this);
  }

  protected void showLoadingDialog(String message) {
    if (progressDialog == null) {
      progressDialog = new ProgressDialog(this);
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
