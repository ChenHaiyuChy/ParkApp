package com.cqut.haiyuchen.parkapp.ui.untils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by haiyu.chen on 2017/4/27.
 */

public class DateTimeFormat {
  public static String dtformat(String dt) {
    return dt.replace("年", "-").replace("月", "-").replace("日", "");
  }

  public static String getNowDateTimeFormat() {
    return new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(new Date());
  }

  public static long dtToLong(String dt) {
    Pattern p = Pattern.compile("[^0-9]");
    Matcher m = p.matcher(dt);
    return Long.parseLong(m.replaceAll("").trim());
  }
}
