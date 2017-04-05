package com.cqut.haiyuchen.parkapp.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by haiyu.chen on 2017/4/1.
 */

public class ServiceData {
  List<Map<String, Object>> list = new ArrayList<>();

  public void setList(List<Map<String, Object>> list) {
    this.list = list;
  }

  public List<Map<String, Object>> getList() {
    return list;
  }
}
