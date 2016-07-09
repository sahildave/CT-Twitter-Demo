package xyz.sahildave.cleartax.tweetlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import xyz.sahildave.cleartax.data.list.TweetListRepository;
import xyz.sahildave.cleartax.data.model.Tweet;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;

/**
 * Created by sahil on 9/7/16.
 */
public class TweetListPresenter implements TweetListContract.UserActionsListener{
    private final TweetListRepository mTweetListRepository;
    private final TweetListContract.View mTweetListView;


    private int currentPage = 1;
    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;

    public TweetListPresenter(@NonNull TweetListRepository tweetListRepository,
                              @NonNull TweetListContract.View tweetListView) {
        mTweetListRepository = checkNotNull(tweetListRepository);
        mTweetListView = checkNotNull(tweetListView);
    }

    @Override
    public void setupTweetRecycler(RecyclerView recyclerView) {
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                    loading = true;
                    ++currentPage;
                    loadTweets(false);
                }
            }
        });
    }

    @Override
    public void loadTweets(boolean forceUpdate) {
        if (forceUpdate) {
            currentPage = 1;
            mTweetListView.showEmpty();
        }

        mTweetListRepository.getTweets(mTweetListView, currentPage, new TweetListRepository.LoadTweetListCallback() {
            @Override
            public void onTweetListLoading() {

            }

            @Override
            public void onTweetListLoaded(List<Tweet> tweets, boolean success) {

            }
        });

    }
}
