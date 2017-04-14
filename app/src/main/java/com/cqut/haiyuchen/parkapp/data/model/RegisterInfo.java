package com.cqut.haiyuchen.parkapp.data.model;

/**
 * Created by haiyu.chen on 2017/4/14.
 */

public class RegisterInfo {
  private String phoneNumber;
  private String password;
  private String smsCaptcha;

  public RegisterInfo() {
    this.smsCaptcha = "";
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getSmsCaptcha() {
    return smsCaptcha;
  }

  public void setSmsCaptcha(String smsCaptcha) {
    this.smsCaptcha = smsCaptcha;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void resetSmsCaptcha() {
    this.smsCaptcha = "";
  }

  @Override public String toString() {
    return "RegisterInfo{" +
        "phoneNumber='" + phoneNumber + '\'' +
        ", password='" + password + '\'' +
        ", smsCaptcha='" + smsCaptcha + '\'' +
        '}';
  }
}
