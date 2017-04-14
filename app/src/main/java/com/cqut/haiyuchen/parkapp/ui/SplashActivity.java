package com.cqut.haiyuchen.parkapp.ui;

import android.content.Intent;
import android.os.Handler;
import butterknife.BindView;
import butterknife.OnClick;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.ui.home.HomeTabActivity;
import com.cqut.haiyuchen.parkapp.ui.widget.SimpleButton;
import com.squareup.phrase.Phrase;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class SplashActivity extends AuxiliaryActivity {
  @BindView(R.id.sb_skip) SimpleButton mSbSkip;
  private boolean mIsSkip = false;
  private int TIME_SECOND = 5;
  private final Handler handler = new Handler();
  private final Runnable runnable = new Runnable() {
    @Override public void run() {
      if (TIME_SECOND < 0) {
        handler.removeCallbacks(runnable);
        _doSkip();
      } else {
        mSbSkip.setText(Phrase.from(getApplication(), R.string.splash_jump)
            .put("second", TIME_SECOND)
            .format()
            .toString());
        TIME_SECOND--;
        handler.postDelayed(this, 1000);
      }
    }
  };

  @Override public int layoutResId() {
    return R.layout.activity_splash;
  }

  @Override public void onInit() {
    super.onInit();
    handler.post(runnable);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    handler.removeCallbacks(runnable);
  }

  private void _doSkip() {
    if (!mIsSkip) {
      mIsSkip = true;
      TIME_SECOND = 5;
      this.finish();
      if (preferencesManager.getLogged()) {
        startActivity(new Intent(SplashActivity.this, HomeTabActivity.class));
      } else {
        startActivity(new Intent(SplashActivity.this, HomeTabActivity.class));
        //startActivity(new Intent(SplashActivity.this, LoginActivity.class));
      }
      overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
    }
  }

  @Override public void onBackPressed() {
    return;
  }

  @OnClick(R.id.sb_skip) void onClick() {
    _doSkip();
  }
}
