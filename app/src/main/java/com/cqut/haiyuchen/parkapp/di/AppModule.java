package com.cqut.haiyuchen.parkapp.di;

import android.content.Context;
import com.cqut.haiyuchen.parkapp.common.retrofit.RetrofitHelper;
import com.cqut.haiyuchen.parkapp.common.retrofit.ServerApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by haiyu.chen on 2017/3/2.
 */
@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideCOntext() {
        return mContext;
    }

    @Provides
    @Singleton ServerApi provodeServerApi(Context context) {
        RetrofitHelper.init(context);
        return RetrofitHelper.getApi();
    }
}
