package xyz.sahildave.cleartax.data.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import xyz.sahildave.cleartax.data.model.Bearer;
import xyz.sahildave.cleartax.data.model.SearchResult;

/**
 * Created by sahil on 6/3/16.
 */
interface TwitterApiService {

    @POST("oauth2/token?grant_type=client_credentials")
    Call<Bearer> getToken(@Body Map<String, Object> fieldMap);

    @GET("1.1/search/tweets.json")
    Call<SearchResult> getTweets(@QueryMap Map<String, Object> queryMap);
}
