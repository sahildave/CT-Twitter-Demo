package xyz.sahildave.cleartax.tweetlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import timber.log.Timber;
import xyz.sahildave.cleartax.R;
import xyz.sahildave.cleartax.data.model.Tweet;

/**
 * Created by sahil on 9/7/16.
 */
public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.ViewHolder> {

    private final List<Tweet> mValues;
    private final Context mContext;
    private TweetItemListener mTweetItemListener;
    private int ITEM_LIST_CONTENT = R.layout.item_list_content;

    public TweetListAdapter(Context context, List<Tweet> items, final TweetItemListener tweetItemListener) {
        mContext = context;
        mValues = items;
        mTweetItemListener = tweetItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new ViewHolder(view, mTweetItemListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Tweet tweet = mValues.get(position);
        holder.mItem = tweet;
        Timber.d("onBindViewHolder: %s", "Tweet = [" + tweet + "], position = [" + position + "]");
        if (tweet != null) {
            holder.mTitleView.setText(tweet.getText());
            int placeholderColor = Color.parseColor("#" + tweet.getUser().getPlaceholderColor());
            ColorDrawable cd = new ColorDrawable(placeholderColor);
            Glide.with(mContext).load(tweet.getUser().getProfileImageUrl())
                    .placeholder(cd)
                    .into(holder.mAvatarView);

        }
    }

    public void addTweets(final List<Tweet> tweets) {
        if(tweets == null) {
            hideLoadMore();
            return;
        }

        int oldCount = mValues.size() + 1;
        mValues.addAll(tweets);
        int newCount = mValues.size();
        Timber.d("Adding - %s, %s", oldCount, newCount);
        notifyItemRangeInserted(oldCount, newCount);
    }

    public void showLoadMore() {
        mValues.add(null);
        Timber.d("ShowLoadMore");
        notifyItemInserted(mValues.size() + 1);
    }

    public void hideLoadMore() {
        if (getItemCount() > 0) {
            Tweet loadTweet = mValues.get(mValues.size() - 1);
            if (loadTweet == null) {
                Timber.d("hideLoadMore");
                mValues.remove(loadTweet);
                notifyItemRemoved(mValues.size());
            }
        }
    }

    @Override
    public int getItemViewType(final int position) {
        return ITEM_LIST_CONTENT;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View mView;
        public final ImageView mAvatarView;
        public final TextView mTitleView;
        public Tweet mItem;
        private final TweetItemListener mTweetItemListener;

        public ViewHolder(View view, final TweetItemListener tweetItemListener) {
            super(view);
            mView = view;
            mTweetItemListener = tweetItemListener;
            mAvatarView = (ImageView) view.findViewById(R.id.image);
            mTitleView = (TextView) view.findViewById(R.id.title);
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            mTweetItemListener.tweetClicked(v, mItem);
        }
    }
}
interface TweetItemListener {
    void tweetClicked(View v, Tweet clickedTweet);
}
