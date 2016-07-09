package xyz.sahildave.cleartax;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import xyz.sahildave.cleartax.data.api.TwitterListService;
import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.tweetlist.TweetListContract;
import xyz.sahildave.cleartax.util.AssetProvider;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;

/**
 * Created by sahil on 6/3/16.
 */
public class FakeTweetListServiceApiImpl implements TwitterListService {

    @Override
    public void init() {
        AssetProvider.init();
    }

    @Override
    public void destroy() {
        AssetProvider.nullify();
    }

    @Override
    public void getAllTweets(TweetListContract.View contextView, int page, final TweetListServiceCallbacks<List<Tweet>> callback) {
        checkNotNull(contextView);

        String json = AssetProvider.getInstance().readFromAssets(contextView.getViewContext(), "recent_news.json");
        List<Tweet> Tweets = new Gson().fromJson(json, new TypeToken<List<Tweet>>() {
        }.getType());
        callback.onLoaded(Tweets);
    }
}
