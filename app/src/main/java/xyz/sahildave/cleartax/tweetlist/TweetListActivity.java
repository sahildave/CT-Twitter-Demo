package xyz.sahildave.cleartax.tweetlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xyz.sahildave.cleartax.Injector;
import xyz.sahildave.cleartax.R;
import xyz.sahildave.cleartax.data.model.Tweet;
import xyz.sahildave.cleartax.util.Common;

public class TweetListActivity extends AppCompatActivity implements TweetListContract.View, TweetItemListener {

    private TweetListPresenter mTweetListPresenter;
    private RecyclerView mRecyclerView;
    private TweetListAdapter mAdapter;
    private View mCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);

        mCoordinatorLayout = findViewById(R.id.coordinatorlayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.item_list);
        mAdapter = new TweetListAdapter(this, new ArrayList<Tweet>(), this);
        mRecyclerView.setAdapter(mAdapter);

        /*
        Create a Presenter and send a Repository in the constructor
        This Repository is based on the project flavour.
        mock sends FakeTweetListRepository which reads a search result from String present in
        the same file. It can also be used to read an Asset file using AssetProvider in the same
        package.
         */

        mTweetListPresenter = new TweetListPresenter(Injector.provideTweetListRepository(), this);
        mTweetListPresenter.setupTweetRecycler(mRecyclerView);
        mTweetListPresenter.loadTweets(true);
    }

    @Override
    public void setProgressIndicator(boolean active, String text) {
        ((AppCompatTextView) findViewById(R.id.progress_text)).setText(text);
    }

    @Override
    public void setTweets(List<Tweet> tweets) {
        Common.crossFadeViews(mRecyclerView, findViewById(R.id.progress_root), Common.DURATION_LONG);
        mAdapter.addTweets(tweets);
    }

    @Override
    public void showResult(Map<Integer, String> frequencyMap) {
        String result = "";

        ArrayList<Integer> keys = new ArrayList<Integer>(frequencyMap.keySet());
        for(int i=keys.size()-1; i>=0;i--){
            Integer key = keys.get(i);
            String value = frequencyMap.get(key);
            result += key + " : " + value + "\n";
        }
//
//        for (Integer key : frequencyMap.keySet()) {
//            Object value = frequencyMap.get(key);
//            result += key + " : " + value + "\n";
//        }

        Common.showMessageOK(this, "Result", result, null);
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
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        builder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse("https://twitter.com/sahildave1991/status/" + clickedTweet.getUrl()));
    }
}
