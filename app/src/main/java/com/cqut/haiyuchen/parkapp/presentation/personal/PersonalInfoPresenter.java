package com.cqut.haiyuchen.parkapp.presentation.personal;

import android.util.Log;
import com.cqut.haiyuchen.parkapp.common.EndSubscriber;
import com.cqut.haiyuchen.parkapp.common.network.APIService;
import com.cqut.haiyuchen.parkapp.data.model.Book;
import com.cqut.haiyuchen.parkapp.di.AppPresenter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by haiyu.chen on 2017/4/12.
 */

public class PersonalInfoPresenter extends AppPresenter<PersonalInfoView> {

  private int year;
  private int month;
  private int day;

  @Inject APIService serverApi;

  @Inject public PersonalInfoPresenter(PersonalInfoView personalInfView) {
    super(personalInfView);
    baseView = personalInfView;
  }

  @Override public void attach() {

  }

  @Override public void detach() {

  }

  public void dateInit() {
    Calendar calendar = Calendar.getInstance();
    year = calendar.get(Calendar.YEAR);
    month = calendar.get(Calendar.MONTH);
    day = calendar.get(Calendar.DAY_OF_MONTH);
  }

  public void setDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public String getTextDate() {
    return year + "年" + (month + 1) + "月" + day + "日";
  }

  public String getFormatDate() {
    return year + "-" + month + "-" + day;
  }

  public int getYear() {
    return year;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public long getMinDate() {
    long dateLong = new Date().getTime();
    try {
      dateLong = new SimpleDateFormat("yyyy-MM-dd").parse("1930-01-01").getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return dateLong;
  }

  public void getPersonalInfo() {
    baseView.showDialog();
    serverApi.requestUrl("小王子", 0, 3)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new EndSubscriber<Book>() {
          @Override public void onEnd() {
            baseView.hideDialog();
            Log.e("end", "end");
          }

          @Override public void onNext(Book map) {
            Log.e("next", map.toString());
          }
        });
  }
}
