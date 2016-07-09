package xyz.sahildave.cleartax.data.api;

import java.util.List;

import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

/**
 * Created by sahil on 6/3/16.
 */
public interface TwitterListService {
    interface TweetListServiceCallbacks<T> {
        void onLoaded(T tweets);
    }

    void init();

    void destroy();

    void getAllTweets(TweetListContract.View contextView, int page,
                      TweetListServiceCallbacks<List<Tweet>> callback);
}
