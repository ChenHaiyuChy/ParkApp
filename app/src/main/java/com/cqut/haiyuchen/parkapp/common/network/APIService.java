package com.cqut.haiyuchen.parkapp.common.network;

import com.cqut.haiyuchen.parkapp.data.model.Book;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public interface APIService {

  @GET("book/search") Observable<Book> requestUrl(@Query("q") String q, @Query("start") int start,
      @Query("count") int count);

}
