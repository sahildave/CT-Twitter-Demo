package xyz.sahildave.cleartax.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sahil on 6/3/16.
 */
public class Tweet {
    @SerializedName("text")
    private String mText;
    @SerializedName("truncated")
    private boolean mTruncated;

    public String getText() {
        return mText;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "mTruncated=" + mTruncated +
                ", mText='" + mText + '\'' +
                '}';
    }

    public static class User {
        @SerializedName("id")
        private int mId;
        @SerializedName("id_str")
        private String mIdStr;
        @SerializedName("name")
        private String mName;
        @SerializedName("screen_name")
        private String mScreenName;
        @SerializedName("location")
        private String mLocation;
        @SerializedName("description")
        private String mDescription;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("protected")
        private boolean mprotected;
        @SerializedName("followers_count")
        private int mFollowersCount;
        @SerializedName("friends_count")
        private int mFriendsCount;
        @SerializedName("created_at")
        private String mCreatedAt;
        @SerializedName("profile_background_color")
        private String mProfileBackgroundColor;
        @SerializedName("profile_image_url")
        private String mProfileImageUrl;

        public int getId() {
            return mId;
        }

        public void setId(int mId) {
            this.mId = mId;
        }

        public String getIdStr() {
            return mIdStr;
        }

        public void setIdStr(String mIdStr) {
            this.mIdStr = mIdStr;
        }

        public String getName() {
            return mName;
        }

        public void setName(String mName) {
            this.mName = mName;
        }

        public String getScreenName() {
            return mScreenName;
        }

        public void setScreenName(String mScreenName) {
            this.mScreenName = mScreenName;
        }

        public String getLocation() {
            return mLocation;
        }

        public void setLocation(String mLocation) {
            this.mLocation = mLocation;
        }

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String mDescription) {
            this.mDescription = mDescription;
        }

        public String getUrl() {
            return mUrl;
        }

        public void setUrl(String mUrl) {
            this.mUrl = mUrl;
        }

        public boolean getMprotected() {
            return mprotected;
        }

        public void setMprotected(boolean mprotected) {
            this.mprotected = mprotected;
        }

        public int getFollowersCount() {
            return mFollowersCount;
        }

        public void setFollowersCount(int mFollowersCount) {
            this.mFollowersCount = mFollowersCount;
        }

        public int getFriendsCount() {
            return mFriendsCount;
        }

        public void setFriendsCount(int mFriendsCount) {
            this.mFriendsCount = mFriendsCount;
        }

        public String getCreatedAt() {
            return mCreatedAt;
        }

        public void setCreatedAt(String mCreatedAt) {
            this.mCreatedAt = mCreatedAt;
        }

        public String getProfileBackgroundColor() {
            return mProfileBackgroundColor;
        }

        public void setProfileBackgroundColor(String mProfileBackgroundColor) {
            this.mProfileBackgroundColor = mProfileBackgroundColor;
        }

        public String getProfileImageUrl() {
            return mProfileImageUrl;
        }

        public void setProfileImageUrl(String mProfileImageUrl) {
            this.mProfileImageUrl = mProfileImageUrl;
        }
    }
}
