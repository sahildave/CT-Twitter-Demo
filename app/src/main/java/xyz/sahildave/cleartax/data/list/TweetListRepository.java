package xyz.sahildave.cleartax.data.list;

import android.support.annotation.NonNull;

import java.util.List;

import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

/**
 * Created by sahil on 9/7/16.
 */
public interface TweetListRepository {
    interface LoadTweetListCallback {
        void onTweetListLoading();

        void onTweetListLoaded(List<Tweet> tweets, boolean success);
    }

    interface GetTweetCallback {
        void onTweetLoaded(Tweet Tweet, boolean success);
    }

    void getTweets(TweetListContract.View contextView, int page, @NonNull LoadTweetListCallback callback);
}