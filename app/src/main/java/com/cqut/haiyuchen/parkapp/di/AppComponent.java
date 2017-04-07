package com.cqut.haiyuchen.parkapp.di;

import android.content.Context;
import com.cqut.haiyuchen.parkapp.common.retrofit.ServerApi;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by haiyu.chen on 2017/3/2.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getContext();
    /**这里必须加上这个,因为在LoginPresenter里面我@Inject ServerApi,
     这里不加的话,会造成这个ServerApi找不到
     */
    ServerApi getServerApi();
}
