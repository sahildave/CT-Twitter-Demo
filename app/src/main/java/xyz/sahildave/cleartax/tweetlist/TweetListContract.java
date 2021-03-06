package xyz.sahildave.cleartax.tweetlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Map;

import xyz.sahildave.cleartax.data.model.Tweet;

/**
 * Created by sahil on 9/7/16.
 */
public interface TweetListContract {
    interface View {
        void setProgressIndicator(boolean active, String text);

        void setTweets(List<Tweet> tweets);

        void showResult(Map<Integer, String> frequencyMap);

        void showError();

        void showEmpty();

        void showLoadMore();

        Context getViewContext();
    }

    interface UserActionsListener {
        void setupTweetRecycler(RecyclerView recyclerView);

        void loadTweets(boolean forceUpdate);
    }
}