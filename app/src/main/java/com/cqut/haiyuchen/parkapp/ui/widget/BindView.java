package com.cqut.haiyuchen.parkapp.ui.widget;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by haiyu.chen on 2017/3/31.
 */
@Target(ElementType.FIELD)//表示用在字段上
@Retention(RetentionPolicy.RUNTIME)//表示在生命周期是运行时
public @interface BindView {
  int value() default 0;
}
