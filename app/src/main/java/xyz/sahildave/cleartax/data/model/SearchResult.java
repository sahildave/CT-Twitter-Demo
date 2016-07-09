package xyz.sahildave.cleartax.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sahil on 9/7/16.
 */
public class SearchResult {
    @SerializedName("statuses")
    private List<Tweet> mTweets;

    @SerializedName("search_metadata")
    private SearchMetadata mSearchMetaData;


    public List<Tweet> getTweets() {
        return mTweets;
    }

    public void setmTweets(List<Tweet> mTweets) {
        this.mTweets = mTweets;
    }

    public SearchMetadata getmSearchMetaData() {
        return mSearchMetaData;
    }

    public void setmSearchMetaData(SearchMetadata mSearchMetaData) {
        this.mSearchMetaData = mSearchMetaData;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "mTweets=" + mTweets +
                '}';
    }

    public static class SearchMetadata {

        @SerializedName("completed_in")
        private double mCompletedIn;
        @SerializedName("max_id")
        private String mMaxId;
        @SerializedName("max_id_str")
        private String mMaxIdStr;
        @SerializedName("next_results")
        private String mNextResults;
        @SerializedName("query")
        private String mQuery;
        @SerializedName("refresh_url")
        private String mRefreshUrl;
        @SerializedName("count")
        private int mCount;
        @SerializedName("since_id")
        private int mSinceId;
        @SerializedName("since_id_str")
        private String mSinceIdStr;

        public double getCompletedIn() {
            return mCompletedIn;
        }

        public void setCompletedIn(double mCompletedIn) {
            this.mCompletedIn = mCompletedIn;
        }

        public String getMaxId() {
            return mMaxId;
        }

        public void setMaxId(String mMaxId) {
            this.mMaxId = mMaxId;
        }

        public String getMaxIdStr() {
            return mMaxIdStr;
        }

        public void setMaxIdStr(String mMaxIdStr) {
            this.mMaxIdStr = mMaxIdStr;
        }

        public String getNextResults() {
            return mNextResults;
        }

        public void setNextResults(String mNextResults) {
            this.mNextResults = mNextResults;
        }

        public String getQuery() {
            return mQuery;
        }

        public void setQuery(String mQuery) {
            this.mQuery = mQuery;
        }

        public String getRefreshUrl() {
            return mRefreshUrl;
        }

        public void setRefreshUrl(String mRefreshUrl) {
            this.mRefreshUrl = mRefreshUrl;
        }

        public int getCount() {
            return mCount;
        }

        public void setCount(int mCount) {
            this.mCount = mCount;
        }

        public int getSinceId() {
            return mSinceId;
        }

        public void setSinceId(int mSinceId) {
            this.mSinceId = mSinceId;
        }

        public String getSinceIdStr() {
            return mSinceIdStr;
        }

        public void setSinceIdStr(String mSinceIdStr) {
            this.mSinceIdStr = mSinceIdStr;
        }
    }
}
