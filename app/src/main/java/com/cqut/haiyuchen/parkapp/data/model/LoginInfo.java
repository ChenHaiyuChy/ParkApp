package com.cqut.haiyuchen.parkapp.data.model;

/**
 * Created by haiyu.chen on 2017/4/14.
 */

public class LoginInfo {
  private String phoneNumber;
  private String password;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override public String toString() {
    return "LoginInfo{" +
        "phoneNumber='" + phoneNumber + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
