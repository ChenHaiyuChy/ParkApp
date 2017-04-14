package com.cqut.haiyuchen.parkapp.data.mock;

/**
 * Created by haiyu.chen on 2017/4/14.
 */

public class SmsCaptcha {

  public static String getSmsCaptcha() {
    return getRandom() + getRandom() + getRandom() + getRandom();
  }

  private static String getRandom() {
    return (int) (Math.random() * 10) + "";
  }
}
