package com.cqut.haiyuchen.parkapp.common.network;

import android.util.Log;
import com.cqut.haiyuchen.parkapp.data.ConfigInternal;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class HttpManager {
  public final static int CONNECT_TIMEOUT = 5;
  public final static int READ_TIMEOUT = 5;
  public final static int WRITE_TIMEOUT = 5;
  //服务器地址
  private static final String BASE_URL = ConfigInternal.BASE_URL;

  private static APIService service;
  private static Retrofit retrofit;

  public static APIService getService() {
    if (service == null) {
      service = getRetrofit().create(APIService.class);
    }
    return service;
  }

  private static Retrofit getRetrofit() {
    if (retrofit == null) {
      HttpLoggingInterceptor interceptor =
          new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override public void log(String message) {
              Log.e("RxJava", message);
            }
          });
      //网络缓存路径文件
      // File httpCacheDirectory = new File(BaseApplication.getInstance().getExternalCacheDir(), "responses");
      //通过拦截器设置缓存，暂未实现
      //CacheInterceptor cacheInterceptor = new CacheInterceptor();

      //初始化OkHttpClient
      OkHttpClient client =
          new OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
              .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
              .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
              .addInterceptor(new MyInterceptors())
              .addNetworkInterceptor(interceptor)
              .build();
      //初始化retrofit
      retrofit = new Retrofit.Builder().client(client)
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .build();
    }
    return retrofit;
  }
}