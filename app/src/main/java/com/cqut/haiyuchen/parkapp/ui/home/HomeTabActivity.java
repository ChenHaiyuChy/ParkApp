package com.cqut.haiyuchen.parkapp.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import butterknife.BindView;
import butterknife.OnPageChange;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cqut.haiyuchen.parkapp.R;
import com.cqut.haiyuchen.parkapp.ui.AuxiliaryActivity;
import com.cqut.haiyuchen.parkapp.ui.lease.LeaseActivity;
import com.cqut.haiyuchen.parkapp.ui.personal.PersonalActivity;
import com.cqut.haiyuchen.parkapp.ui.service.ServiceActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class HomeTabActivity extends AuxiliaryActivity
    implements BottomNavigationBar.OnTabSelectedListener {
  @BindView(R.id.home_tab_vp) ViewPager viewPager;
  @BindView(R.id.home_tab_bar) BottomNavigationBar bottomNavigationBar;

  private List<Fragment> fragments;
  private long FIRST_TIME = 0;

  @Override public int layoutResId() {
    return R.layout.activity_home_tab;
  }

  @Override public void onInit() {
    super.onInit();
    initView();
  }

  private void initView() {
    initBottomNavigationBar();
    initViewPager();
  }

  private void initBottomNavigationBar() {
    bottomNavigationBar.setTabSelectedListener(this);
    bottomNavigationBar.clearAll();
    bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
    bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
    bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_tab_home_selected,
        R.string.rent).setInactiveIconResource(R.mipmap.ic_tab_home_normal)
        .setActiveColorResource(R.color.primary_color)
        .setInActiveColorResource(R.color.text_gray_dark))
        .addItem(new BottomNavigationItem(R.mipmap.ic_tab_msg_selected,
            R.string.service).setInactiveIconResource(R.mipmap.ic_tab_msg_normal)
            .setActiveColorResource(R.color.primary_color)
            .setInActiveColorResource(R.color.text_gray_dark))
        .addItem(new BottomNavigationItem(R.mipmap.ic_tab_profile_selected,
            R.string.personal).setInactiveIconResource(R.mipmap.ic_tab_profile_normal)
            .setActiveColorResource(R.color.primary_color)
            .setInActiveColorResource(R.color.text_gray_dark))
        .initialise();
  }

  private void initViewPager() {
    fragments = new ArrayList<>();
    fragments.add(new LeaseActivity());
    fragments.add(new ServiceActivity());
    fragments.add(new PersonalActivity());

    viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
    viewPager.setCurrentItem(0);
    viewPager.setOffscreenPageLimit(2);
  }

  @OnPageChange(R.id.home_tab_vp) void vpChange(int position) {
    bottomNavigationBar.selectTab(position);
  }

  protected class SectionsPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;

    public SectionsPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
      super(fm);
      this.fragments = fragments;
    }

    @Override public Fragment getItem(int position) {
      return fragments.get(position);
    }

    @Override public int getCount() {
      return fragments.size();
    }
  }

  @Override public void onTabSelected(int position) {
    viewPager.setCurrentItem(position);
  }

  @Override public void onTabReselected(int position) {
  }

  @Override public void onTabUnselected(int position) {
  }

  @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
      long secondTime = System.currentTimeMillis();
      if (secondTime - FIRST_TIME > 2000) {
        toaster.showText(getString(R.string.repress_exit_app));
        FIRST_TIME = secondTime;
      } else {
        System.exit(0);
      }
    }
    return false;
  }
}
