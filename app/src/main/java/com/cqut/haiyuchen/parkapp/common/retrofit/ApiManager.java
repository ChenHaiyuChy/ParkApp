package com.cqut.haiyuchen.parkapp.common.retrofit;

import com.cqut.haiyuchen.parkapp.BuildConfig;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by haiyu.chen on 2017/4/6.
 */

@Module public class ApiManager {
  @Provides @Singleton public OkHttpClient provideOkHttpClient() {
    final OkHttpClient.Builder builder = new OkHttpClient.Builder();
    //添加logo日志打印网络请求的拦截器
    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(HttpLoggingInterceptor.Level.BODY);
      builder.addInterceptor(logging);
    }

    builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
        .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

    return builder.build();
  }

  @Provides @Singleton public Retrofit provideRestAdapter(OkHttpClient okHttpClient) {
    Retrofit.Builder builder = new Retrofit.Builder();
    builder.client(okHttpClient)
        .baseUrl("https://www.baidu.comg/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create());
    return builder.build();
  }
}
