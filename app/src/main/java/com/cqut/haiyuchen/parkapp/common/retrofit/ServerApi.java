package com.cqut.haiyuchen.parkapp.common.retrofit;

import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chy on 2017-3-11.
 */

public interface ServerApi {

    @GET("book/search")
    Observable<Map<String, Object>> requestUrl(@Query("q") String q, @Query("start") int start,
        @Query("count") int count);

}
