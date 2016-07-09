package xyz.sahildave.cleartax.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

/**
 * Created by sahil on 6/3/16.
 */
public class TwitterListServiceImpl implements TwitterListService {
    public final static String BASE_URL = "http://ec2-54-169-131-138.ap-southeast-1.compute.amazonaws.com/";
    private final static String LOG_TAG = TwitterListServiceImpl.class.getName();
    private TwitterApiService wpService;

    @Override
    public void init() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);
        // TODO: 6/3/16 Add Auth
//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request original = chain.request();
//
//                // Customize the request
//                Request request = original.newBuilder()
//                        .header("Accept", "application/json")
//                        .header("Authorization", "auth-token")
//                        .method(original.method(), original.body())
//                        .build();
//
//                Response response = chain.proceed(request);
//
//                // Customize or return the response
//                return response;
//            }
//        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        wpService = retrofit.create(TwitterApiService.class);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void getAllTweets(TweetListContract.View contextView, int page, TweetListServiceCallbacks<List<Tweet>> callback) {

    }
}
