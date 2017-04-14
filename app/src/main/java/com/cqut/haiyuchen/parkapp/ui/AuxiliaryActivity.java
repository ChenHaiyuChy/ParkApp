package com.cqut.haiyuchen.parkapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseToast;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public abstract class AuxiliaryActivity extends AppCompatActivity {
  protected PreferencesManager preferencesManager;
  protected BaseToast toaster;
  public abstract int layoutResId();

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layoutResId());
    onInit();
  }

  public void onInit() {
    ButterKnife.bind(this);
    preferencesManager = new PreferencesManager(getApplication());
    toaster = new BaseToast();
  }
}
