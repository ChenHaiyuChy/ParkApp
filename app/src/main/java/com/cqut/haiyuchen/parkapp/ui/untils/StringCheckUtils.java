package com.cqut.haiyuchen.parkapp.ui.untils;

/**
 * Created by haiyu.chen on 2017/4/13.
 */

public class StringCheckUtils {
  private static String phonePattern = "[1][358]\\d{9}";

  public static boolean checkMobile(String number) {
    if (number == null) {
      return false;
    } else {
      return number.matches(phonePattern);
    }
  }
}
