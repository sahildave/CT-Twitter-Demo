package xyz.sahildave.cleartax.tweetlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import xyz.sahildave.cleartax.Injector;
import xyz.sahildave.cleartax.R;
import xyz.sahildave.cleartax.data.model.Tweet;

public class TweetListActivity extends AppCompatActivity implements TweetListContract.View, TweetItemListener {

    private TweetListPresenter mTweetListPresenter;
    private RecyclerView mRecyclerView;
    private TweetListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_list);
        mAdapter = new TweetListAdapter(new ArrayList<Tweet>(), this);
        mRecyclerView.setAdapter(mAdapter);

        mTweetListPresenter = new TweetListPresenter(Injector.provideTweetListRepository(), this);
        mTweetListPresenter.setupTweetRecycler(mRecyclerView);
        mTweetListPresenter.loadTweets(true);
    }

    @Override
    public void setProgressIndicator(boolean active) {

    }

    @Override
    public void setTweets(List<Tweet> tweets) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoadMore() {

    }

    @Override
    public Context getViewContext() {
        return null;
    }

    @Override
    public void tweetClicked(View v, Tweet clickedTweet) {

    }
}
