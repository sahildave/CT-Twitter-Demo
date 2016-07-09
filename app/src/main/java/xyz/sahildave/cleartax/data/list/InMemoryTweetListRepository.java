package xyz.sahildave.cleartax.data.list;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;
import xyz.sahildave.cleartax.data.api.TwitterListService;
import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;


/**
 * Created by sahil on 6/3/16.
 */
class InMemoryTweetListRepository implements TweetListRepository {

    private final TwitterListService mTweetListServiceApi;
    private boolean mGetAllTweetsCalled;
    private boolean mTokenReceived;
    private String mToken;
    private ArrayList<Tweet> mTweetList = new ArrayList<>();

    public InMemoryTweetListRepository(@NonNull TwitterListService TweetListServiceApi) {
        mTweetListServiceApi = checkNotNull(TweetListServiceApi);
        mTweetListServiceApi.init();
        Timber.d("InMemoryTweetListRepository: %s", "TweetListServiceApi = [" + TweetListServiceApi + "]");
    }

    @Override
    public void getTweets(final TweetListContract.View contextView, final int page,
                          @NonNull final LoadTweetListCallback callback, final int limit) {
        Timber.d("getTweets: %s", "contextView = [" + contextView + "], page = [" + page + "], callback = [" + callback + "]"); checkNotNull(callback);
        // Load from API only if needed.
        if (!mTokenReceived  || mToken ==null) {
            mTweetListServiceApi.getToken(contextView, new TwitterListService.TweetTokenCallback() {

                @Override
                public void onTokenStarted() {
                    callback.onFetchTokenStarted();
                }

                @Override
                public void onTokenReceived(String token, boolean success) {
                    if (token != null) {
                        callback.onFetchTokenComplete();
                        mTokenReceived = true;
                        mToken = token;
                        getTweetsInner(token, callback, contextView, page, limit);
                    } else {
                        mTokenReceived = false;
                    }
                }
            });
        } else {
            Timber.d("Searching for page - %s, token - %s", page, mToken);
            getTweetsInner(mToken, callback, contextView, page, limit);

        }

    }

    private void getTweetsInner(String token, @NonNull final LoadTweetListCallback callback, final TweetListContract.View contextView, int page, final int limit) {
        Timber.d("Loading Inner more - %s, %s, %s", page, mTweetList.size(), limit);
        callback.onTweetListLoading(page, mTweetList.size());
        mTweetListServiceApi.getAllTweets(contextView, page, token, new TwitterListService.TweetListServiceCallbacks<List<Tweet>>() {
            @Override
            public void onTweetsLoaded(List<Tweet> tweets, int page) {
                if (tweets == null) {
                    return;
                }
                addToTweetList(tweets);
                if (mTweetList.size() < limit) {
                    getTweetsInner(mToken, callback, contextView, ++page, limit);
                } else {
                    callback.onTweetListLoaded(mTweetList, page, true);
                }
                callback.onTweetListLoading(page, mTweetList.size());
            }
        });
    }

    private void addToTweetList(List<Tweet> tweets) {
        if (mTweetList == null) {
            mTweetList = new ArrayList<Tweet>();
        }

        if (tweets != null) {
            mTweetList.addAll(tweets);
        }
        Timber.d("Tweet %s", mTweetList.size());
    }
}
