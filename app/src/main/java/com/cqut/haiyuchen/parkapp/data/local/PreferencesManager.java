package com.cqut.haiyuchen.parkapp.data.local;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.cqut.haiyuchen.parkapp.di.BaseApplication;

/**
 * Created by haiyu.chen on 2017/4/7.
 */

public class PreferencesManager {
  public static final String PREFERENCES_NAME = "parkapp";
  SharedPreferences sharedPreferences;

  public PreferencesManager(Application application) {
    sharedPreferences = application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
  }

  public void saveLoginInfo(String username, String password, boolean logged) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("username", username);
    editor.putString("password", password);
    editor.putBoolean("logged", logged);
    editor.commit();
  }

  public String getUserName() {
    return sharedPreferences.getString("username", "");
  }

  public String getPassword() {
    return sharedPreferences.getString("password", "");
  }

  public boolean getLogged() {
    return sharedPreferences.getBoolean("logged", false);
  }
}
