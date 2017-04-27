package com.cqut.haiyuchen.parkapp.presentation.lease;

import com.cqut.haiyuchen.parkapp.common.network.APIService;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/4/27.
 */

public class LeasePresenter extends AppPresenter<LeaseView> {
  @Inject APIService serverApi;
  private List<String> lockList = new ArrayList<>();

  @Inject public LeasePresenter(LeaseView leaseView) {
    super(leaseView);
    baseView = leaseView;
  }

  @Override public void attach() {
  }

  @Override public void detach() {
  }

  public List<String> getLockList() {
    return lockList;
  }

  public void initLockList() {
    lockList.add("新增无锁泊位");
    lockList.add("锁1");
    lockList.add("锁2");
    lockList.add("锁3");
  }
}
