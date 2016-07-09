package xyz.sahildave.cleartax.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sahil on 6/3/16.
 */
public class Tweet {
    @SerializedName("user")
    private User mUser;
    @SerializedName("text")
    private String mText;
    @SerializedName("id")
    private long mId;
    @SerializedName("id_str")
    private String mUrl;

    public String getText() {
        return mText;
    }

    public User getUser() {
        return mUser;
    }

    public long getId() {
        return mId;
    }

    public String getUrl() {
        return mUrl;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                ", mText='" + mText + '\'' +
                '}';
    }

    public static class User {
        @SerializedName("profile_image_url")
        private String mProfileImageUrl;

        @SerializedName("profile_link_color")
        private String mPlaceholderColor;

        public String getPlaceholderColor() {
            return mPlaceholderColor;
        }

        public String getProfileImageUrl() {
            return mProfileImageUrl;
        }
    }
}
