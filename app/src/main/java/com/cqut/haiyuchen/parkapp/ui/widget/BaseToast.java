package com.cqut.haiyuchen.parkapp.ui.widget;

import android.widget.Toast;
import com.cqut.haiyuchen.parkapp.di.BaseApplication;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class BaseToast {
  /* define the toast */
  private static Toast toast;

  /* useless constant */
  private int USELESS_CONSTANT = 0;

  /**
   * show the only toast.
   *
   * @param content the content of want to show
   */
  public static void showText(String content) {

    if (toast == null) {
      toast =
          Toast.makeText(BaseApplication.getInstance().getContext(), content, Toast.LENGTH_SHORT);
    } else {
      toast.cancel();
      toast =
          Toast.makeText(BaseApplication.getInstance().getContext(), content, Toast.LENGTH_SHORT);
      // toast.setText(content);
    }

    /* show toast  */
    toast.show();
  }
}
