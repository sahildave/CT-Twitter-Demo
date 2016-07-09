package xyz.sahildave.cleartax.data.list;

import android.support.annotation.NonNull;

import xyz.sahildave.cleartax.data.api.TwitterListService;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;


/**
 * Created by sahil on 6/3/16.
 */
class InMemoryTweetListRepository implements TweetListRepository {

    private final TwitterListService mTweetListServiceApi;
    private boolean mGetAllTweetsCalled;

    public InMemoryTweetListRepository(@NonNull TwitterListService TweetListServiceApi) {
        mTweetListServiceApi = checkNotNull(TweetListServiceApi);
        mTweetListServiceApi.init();
    }

    @Override
    public void getTweets(TweetListContract.View contextView, int page, @NonNull LoadTweetListCallback callback) {

    }
}
