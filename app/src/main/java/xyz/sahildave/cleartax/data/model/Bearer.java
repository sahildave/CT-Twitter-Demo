package xyz.sahildave.cleartax.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sahil on 9/7/16.
 */
public class Bearer {
    @SerializedName("token_type")
    private String mTokenType;
    @SerializedName("access_token")
    private String mAccessToken;

    public String getTokenType() {
        return mTokenType;
    }

    public void setTokenType(String mTokenType) {
        this.mTokenType = mTokenType;
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String mAccessToken) {
        this.mAccessToken = mAccessToken;
    }

    @Override
    public String toString() {
        return "Bearer{" +
                "mTokenType='" + mTokenType + '\'' +
                ", mAccessToken='" + mAccessToken + '\'' +
                '}';
    }
}
