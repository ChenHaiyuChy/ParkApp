package com.cqut.haiyuchen.parkapp.ui.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import java.lang.reflect.Field;

/**
 * Created by haiyu.chen on 2017/3/31.
 */

public abstract class BaseActivity extends FragmentActivity {

  public abstract int layoutResId();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(layoutResId());
    onInit(savedInstanceState);
  }

  public void onInit(@Nullable Bundle savedInstanceState) {
    try {
      Class<?> clazz = this.getClass();
      Field[] fields = clazz.getDeclaredFields();//获得Activity中声明的字段
      for (Field field : fields) {
        // 查看这个字段是否有我们自定义的注解类标志的
        if (field.isAnnotationPresent(BindView.class)) {
          BindView inject = field.getAnnotation(BindView.class);
          int id = inject.value();
          if (id > 0) {
            field.setAccessible(true);
            field.set(this, this.findViewById(id));//给我们要找的字段设置值
          }
        }
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
  }
}
