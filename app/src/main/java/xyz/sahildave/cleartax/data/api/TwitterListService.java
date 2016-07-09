package xyz.sahildave.cleartax.data.api;

import java.util.List;

import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

/**
 * Created by sahil on 6/3/16.
 */
public interface TwitterListService {
    interface TweetTokenCallback {
        void onTokenStarted();
        void onTokenReceived(String token, boolean success);
    }

    interface TweetListServiceCallbacks<T> {
        void onTweetsLoaded(List<Tweet> tweets, long page);
    }

    void init();

    void destroy();

    void getToken(TweetListContract.View contextView,
                  TweetTokenCallback callback);

    void getAllTweets(TweetListContract.View contextView, long page,
                      String token, TweetListServiceCallbacks<List<Tweet>> callback);
}
