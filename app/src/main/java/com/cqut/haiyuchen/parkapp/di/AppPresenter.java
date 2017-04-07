package com.cqut.haiyuchen.parkapp.di;

import javax.inject.Inject;

/**
 * Created by haiyu.chen on 2017/3/2.
 */

public abstract class AppPresenter<V extends MvpView> {
    @Inject
    protected V baseView;

    public AppPresenter(V baseView) {
        this.baseView = baseView;
    }

    public abstract void attach();

    public abstract void detach();
}
