package xyz.sahildave.cleartax;

import xyz.sahildave.cleartax.data.api.TwitterListServiceImpl;
import xyz.sahildave.cleartax.data.list.TweetListRepoProvider;
import xyz.sahildave.cleartax.data.list.TweetListRepository;

/**
 * Created by sahil on 9/7/16.
 */
public class Injector {
    public static TweetListRepository provideTweetListRepository() {
        return TweetListRepoProvider.getInMemoryRepoInstance(new TwitterListServiceImpl());
    }
}
