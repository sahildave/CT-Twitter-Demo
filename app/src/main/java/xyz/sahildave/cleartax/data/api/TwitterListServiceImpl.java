package xyz.sahildave.cleartax.data.api;

import android.support.v4.util.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;
import xyz.sahildave.cleartax.data.model.Bearer;
import xyz.sahildave.cleartax.data.model.SearchResult;
import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;

/**
 * Created by sahil on 6/3/16.
 */
public class TwitterListServiceImpl implements TwitterListService {
    public final static String BASE_URL = "https://api.twitter.com/";
    public final static String OAUTH_TOKEN = "oauth2/token";
    private final static String LOG_TAG = TwitterListServiceImpl.class.getName();
    private TwitterApiService twitterApiService;
    private HttpLoggingInterceptor loggingInterceptor;
    private OkHttpClient.Builder httpClient;
    private Gson gson;

    @Override
    public void init() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);
        // TODO: 6/3/16 Add Auth
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Customize the request
                Request request = original.newBuilder()
                        .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
                        .header("Authorization", "Basic Rk40WE1QVVJ4a3hmeFJuaEtjNXpieE9OcDpsQkxLd2RsUXBhSFliT3d2a1pIRUprMzZSN0ViMmZmbVgyZk9PQ0didG54d2FhV0h1Ug==")
                        .method(original.method(), original.body())
                        .build();

                // Customize or return the response
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        twitterApiService = retrofit.create(TwitterApiService.class);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void getToken(TweetListContract.View contextView, final TweetTokenCallback callback) {
        checkNotNull(twitterApiService);

        Map<String, Object> fieldMap = new ArrayMap<>();
        fieldMap.put("grant_type", "client_credentials");
        Call<Bearer> call = twitterApiService.getToken(fieldMap);
        call.enqueue(new Callback<Bearer>() {
            @Override
            public void onResponse(Call<Bearer> call, Response<Bearer> response) {
                Timber.d("onResponse: %s", "call = [" + call + "], response = [" + response + "]");
                if (response != null && response.isSuccessful()) {
                    Bearer bearer = response.body();
                    Timber.d("Bearer - %s", bearer);
                    callback.onTokenReceived(bearer.getAccessToken(), true);
                } else {
                    callback.onTokenReceived(null, false);
                }
            }

            @Override
            public void onFailure(Call<Bearer> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAllTweets(TweetListContract.View contextView, final int page,
                             final String token, final TweetListServiceCallbacks<List<Tweet>> callback) {
        checkNotNull(twitterApiService);
        checkNotNull(token);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Customize the request
                Request request = original.newBuilder()
                        .header("Authorization", "Bearer "+token)
                        .method(original.method(), original.body())
                        .build();

                // Customize or return the response
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        twitterApiService = retrofit.create(TwitterApiService.class);

        Map<String, Object> fieldMap = new ArrayMap<>();
        fieldMap.put("q", "cleartax%20-%23cleartax%20-%40cleartax_in");
        Call<SearchResult> call = twitterApiService.getTweets(fieldMap);
        call.enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                Timber.d("onResponse: %s", "call = [" + call + "], response = [" + response + "]");
                if (response != null && response.isSuccessful()) {
                    SearchResult result = response.body();
                    callback.onTweetsLoaded(result.getTweets(), page);
                } else {
                    callback.onTweetsLoaded(null, page);
                }
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
                callback.onTweetsLoaded(null, page);
            }
        });
    }


}
