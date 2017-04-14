package com.cqut.haiyuchen.parkapp.di;

import android.app.Application;
import android.content.Context;

/**
 * Created by haiyu.chen on 2017/4/5.
 */

public class BaseApplication extends Application {
  private static BaseApplication instance;

  public static BaseApplication getInstance() {
    return instance;
  }

  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    if (appComponent == null) {
      appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }

  public Context getContext() {
    return getApplicationContext();
  }


}
