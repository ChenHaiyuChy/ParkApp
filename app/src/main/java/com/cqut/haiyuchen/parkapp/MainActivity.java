package com.cqut.haiyuchen.parkapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity  {
  /*private static final int REFRESH_DELAY = 500;
  @BindView(R.id.main_tv_ledtime) TextView mTextView;

  @Override public int layoutResId() {
    return R.layout.activity_main;
  }

  @Override public void onInit(@Nullable Bundle savedInstanceState) {
    super.onInit(savedInstanceState);
  }

  private final Handler mHandler = new Handler();
  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
  Date curDate ;
  String str ;
  private final Runnable mTimeRefresher = new Runnable() {
    @Override public void run() {
      curDate = new Date(System.currentTimeMillis());
      str = formatter.format(curDate);
      mTextView.setText(str);
      mHandler.postDelayed(this, REFRESH_DELAY);
    }
  };

  @Override protected void onResume() {
    super.onResume();
    mHandler.post(mTimeRefresher);
  }

  @Override protected void onStop() {
    super.onStop();
    mHandler.removeCallbacks(mTimeRefresher);
  }*/
}
