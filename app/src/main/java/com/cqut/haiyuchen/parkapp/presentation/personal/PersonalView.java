package com.cqut.haiyuchen.parkapp.presentation.personal;

import android.content.Intent;
import com.cqut.haiyuchen.parkapp.di.MvpView;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public interface PersonalView extends MvpView {
  void doShare(Intent intent);
  void doCallService(Intent intent);
  void viewModify();
  void showDialog();
  void hideDialog();
}
