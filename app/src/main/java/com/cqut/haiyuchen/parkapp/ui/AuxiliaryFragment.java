package com.cqut.haiyuchen.parkapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.cqut.haiyuchen.parkapp.data.local.PreferencesManager;
import com.cqut.haiyuchen.parkapp.ui.widget.BaseToast;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public abstract class AuxiliaryFragment extends Fragment {
  protected BaseToast toaster;
  private Unbinder unbinder;
  private View view;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(layoutResId(), container, false);
    onInit();
    return view;
  }

  public abstract int layoutResId();

  public void onInit() {
    unbinder = ButterKnife.bind(this, view);
    toaster = new BaseToast();
  }

  @Override public void onDestroyView() {
    unbinder.unbind();
    super.onDestroyView();
  }
}
