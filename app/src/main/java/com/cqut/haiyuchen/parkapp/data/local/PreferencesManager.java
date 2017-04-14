package com.cqut.haiyuchen.parkapp.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import com.cqut.haiyuchen.parkapp.di.BaseApplication;

/**
 * Created by haiyu.chen on 2017/4/7.
 */

public class PreferencesManager {
  private static final String PREFERENCES_NAME = "parkapp";
  private SharedPreferences sharedPreferences = BaseApplication.getInstance()
      .getContext()
      .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
  private SharedPreferences.Editor editor = sharedPreferences.edit();

  private static PreferencesManager instance = new PreferencesManager();

  public static PreferencesManager getInstance() {
    return instance;
  }

  public void saveLoginInfo(String phoneNumber, String password, boolean logged) {
    editor.putString("phoneNumber", phoneNumber);
    editor.putString("password", password);
    editor.putBoolean("logged", logged);
    editor.commit();
  }

  public void setLogged(boolean logged) {
    editor.putBoolean("logged", logged);
    editor.commit();
  }

  public String getPhoneNumber() {
    return sharedPreferences.getString("phoneNumber", "");
  }

  public String getPassword() {
    return sharedPreferences.getString("password", "");
  }

  public boolean getLogged() {
    return sharedPreferences.getBoolean("logged", false);
  }
}
