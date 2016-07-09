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
    private boolean mTokenReceived;
    private String mToken;
    private ArrayList<Tweet> mTweetList = new ArrayList<>();

    public InMemoryTweetListRepository(@NonNull TwitterListService TweetListServiceApi) {
        mTweetListServiceApi = checkNotNull(TweetListServiceApi);
        mTweetListServiceApi.init();
        Timber.d("InMemoryTweetListRepository: %s", "TweetListServiceApi = [" + TweetListServiceApi + "]");
    }

    @Override
    public void getTweets(final TweetListContract.View contextView,
                          @NonNull final LoadTweetListCallback callback, final int limit) {
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
                        getTweetsInner(token, callback, contextView, 0, limit);
                    } else {
                        mTokenReceived = false;
                    }
                }
            });
        } else {
            getTweetsInner(mToken, callback, contextView, 0, limit);

        }

    }

    private void getTweetsInner(String token, @NonNull final LoadTweetListCallback callback,
                                final TweetListContract.View contextView, long sinceId, final int limit) {
        Timber.d("Loading Inner more - %s, %s, %s", sinceId, mTweetList.size(), limit);
        callback.onTweetListLoading(sinceId, mTweetList.size());
        mTweetListServiceApi.getAllTweets(contextView, sinceId, token, new TwitterListService.TweetListServiceCallbacks<List<Tweet>>() {
            @Override
            public void onTweetsLoaded(List<Tweet> tweets, long sinceId) {
                if (tweets == null) {
                    return;
                }
                addToTweetList(tweets);
                if (mTweetList.size() < limit) {
                    getTweetsInner(mToken, callback, contextView, sinceId, limit);
                } else {
                    callback.onTweetListLoaded(mTweetList, sinceId, true);
                }
                callback.onTweetListLoading(sinceId, mTweetList.size());
            }
        });
        // TODO: 9/7/16 Filter more tweets by  entities.urls[n].display_url
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
