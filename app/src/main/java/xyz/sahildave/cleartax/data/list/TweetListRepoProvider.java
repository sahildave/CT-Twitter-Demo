package xyz.sahildave.cleartax.data.list;

import android.support.annotation.NonNull;

import xyz.sahildave.cleartax.data.api.TwitterListService;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;

/**
 * Created by sahil on 6/3/16.
 */
public class TweetListRepoProvider {
    private TweetListRepoProvider() {
        // no instance
    }

    private static TweetListRepository repository = null;

    public synchronized static TweetListRepository getInMemoryRepoInstance(@NonNull TwitterListService TweetsServiceApi) {
        checkNotNull(TweetsServiceApi);
        if (null == repository) {
            repository = new InMemoryTweetListRepository(TweetsServiceApi);
        }
        return repository;
    }
}
