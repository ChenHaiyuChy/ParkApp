package com.cqut.haiyuchen.parkapp.common;

import android.support.annotation.CallSuper;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseToast;
import rx.Subscriber;

/**
 * Created by haiyu.chen on 2017/4/6.
 */

public abstract class EndSubscriber<T> extends Subscriber<T> {

  @CallSuper @Override public void onCompleted() {
    onEnd();
  }

  @CallSuper @Override public void onError(Throwable e) {
    BaseToast.showText("网络连接失败！");
    e.printStackTrace();
    onEnd();
  }

  public abstract void onEnd();
}
