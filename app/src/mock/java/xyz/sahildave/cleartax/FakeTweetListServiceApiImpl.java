package xyz.sahildave.cleartax;

import com.google.gson.Gson;

import java.util.List;

import xyz.sahildave.cleartax.data.api.TwitterListService;
import xyz.sahildave.cleartax.data.model.SearchResult;
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

//        String json = AssetProvider.getInstance().readFromAssets(contextView.getViewContext(), "tweets.json");
        String json = jsonData;
        SearchResult searchResult = new Gson().fromJson(json, SearchResult.class);
        List<Tweet> tweets = searchResult.getTweets();
        callback.onLoaded(tweets);
    }


    String jsonData = "{\n" +
            "  \"statuses\": [\n" +
            "    {\n" +
            "      \"created_at\": \"Sat Jul 09 03:40:32 +0000 2016\",\n" +
            "      \"id\": 751622036233949185,\n" +
            "      \"id_str\": \"751622036233949185\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/sIQwy9DgxN\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/sIQwy9DgxN\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/saura3296\",\n" +
            "            \"display_url\": \"cleartax.in/r/saura3296\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 243769988,\n" +
            "        \"id_str\": \"243769988\",\n" +
            "        \"name\": \"Saurabh Bhardwaj\",\n" +
            "        \"screen_name\": \"bhardwaj357\",\n" +
            "        \"location\": \"India\",\n" +
            "        \"description\": \"\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 31,\n" +
            "        \"friends_count\": 9,\n" +
            "        \"listed_count\": 0,\n" +
            "        \"created_at\": \"Thu Jan 27 19:38:39 +0000 2011\",\n" +
            "        \"favourites_count\": 1,\n" +
            "        \"utc_offset\": 19800,\n" +
            "        \"time_zone\": \"New Delhi\",\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 10,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"C0DEED\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/3476365954/6ac891e8c2c252590d002aee4f787262_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/3476365954/6ac891e8c2c252590d002aee4f787262_normal.jpeg\",\n" +
            "        \"profile_link_color\": \"0084B4\",\n" +
            "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": true,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": true,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 20:05:45 +0000 2016\",\n" +
            "      \"id\": 751507587896643584,\n" +
            "      \"id_str\": \"751507587896643584\",\n" +
            "      \"text\": \"RT @2009Tax: The latest Free Tax Filing Options! https://t.co/2wmqw6IDVW Thanks to @cleartax_in @LBCPAtips @OnePriceTaxes #crochet #ad\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"crochet\",\n" +
            "            \"indices\": [\n" +
            "              122,\n" +
            "              130\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"ad\",\n" +
            "            \"indices\": [\n" +
            "              131,\n" +
            "              134\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"2009Tax\",\n" +
            "            \"name\": \"Frazier Key\",\n" +
            "            \"id\": 2155519795,\n" +
            "            \"id_str\": \"2155519795\",\n" +
            "            \"indices\": [\n" +
            "              3,\n" +
            "              11\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"screen_name\": \"cleartax_in\",\n" +
            "            \"name\": \"ClearTax\",\n" +
            "            \"id\": 313723289,\n" +
            "            \"id_str\": \"313723289\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              95\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"screen_name\": \"LBCPAtips\",\n" +
            "            \"name\": \"LBCPA\",\n" +
            "            \"id\": 2811247590,\n" +
            "            \"id_str\": \"2811247590\",\n" +
            "            \"indices\": [\n" +
            "              96,\n" +
            "              106\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"screen_name\": \"OnePriceTaxes\",\n" +
            "            \"name\": \"OnePriceTaxes\",\n" +
            "            \"id\": 14307521,\n" +
            "            \"id_str\": \"14307521\",\n" +
            "            \"indices\": [\n" +
            "              107,\n" +
            "              121\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/2wmqw6IDVW\",\n" +
            "            \"expanded_url\": \"http://paper.li/2009Tax/1427227225?edition_id=aebc92c0-4546-11e6-bfc9-0cc47a0d1609\",\n" +
            "            \"display_url\": \"paper.li/2009Tax/142722…\",\n" +
            "            \"indices\": [\n" +
            "              49,\n" +
            "              72\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://PurpleKiss.Co\\\" rel=\\\"nofollow\\\">RetweetPKC</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 627482306,\n" +
            "        \"id_str\": \"627482306\",\n" +
            "        \"name\": \"Purple Kiss Co.\",\n" +
            "        \"screen_name\": \"PurpleKissCo\",\n" +
            "        \"location\": \"Cleveland, OH ♥\",\n" +
            "        \"description\": \"Currently not selling physical items due to major time contraints. Please enjoy this account for Crochet News!\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 8215,\n" +
            "        \"friends_count\": 8818,\n" +
            "        \"listed_count\": 411,\n" +
            "        \"created_at\": \"Thu Jul 05 15:38:01 +0000 2012\",\n" +
            "        \"favourites_count\": 230,\n" +
            "        \"utc_offset\": -14400,\n" +
            "        \"time_zone\": \"Eastern Time (US & Canada)\",\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 169943,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"FFFFFF\",\n" +
            "        \"profile_background_image_url\": \"http://pbs.twimg.com/profile_background_images/378800000158581177/p6PWGh_7.jpeg\",\n" +
            "        \"profile_background_image_url_https\": \"https://pbs.twimg.com/profile_background_images/378800000158581177/p6PWGh_7.jpeg\",\n" +
            "        \"profile_background_tile\": true,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/421511378138968064/3sXKbhf8_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/421511378138968064/3sXKbhf8_normal.jpeg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/627482306/1402596568\",\n" +
            "        \"profile_link_color\": \"FF5F95\",\n" +
            "        \"profile_sidebar_border_color\": \"FFFFFF\",\n" +
            "        \"profile_sidebar_fill_color\": \"FFFFFF\",\n" +
            "        \"profile_text_color\": \"000000\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"retweeted_status\": {\n" +
            "        \"created_at\": \"Fri Jul 08 20:00:59 +0000 2016\",\n" +
            "        \"id\": 751506388426383360,\n" +
            "        \"id_str\": \"751506388426383360\",\n" +
            "        \"text\": \"The latest Free Tax Filing Options! https://t.co/2wmqw6IDVW Thanks to @cleartax_in @LBCPAtips @OnePriceTaxes #crochet #ad\",\n" +
            "        \"truncated\": false,\n" +
            "        \"entities\": {\n" +
            "          \"hashtags\": [\n" +
            "            {\n" +
            "              \"text\": \"crochet\",\n" +
            "              \"indices\": [\n" +
            "                109,\n" +
            "                117\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"text\": \"ad\",\n" +
            "              \"indices\": [\n" +
            "                118,\n" +
            "                121\n" +
            "              ]\n" +
            "            }\n" +
            "          ],\n" +
            "          \"symbols\": [],\n" +
            "          \"user_mentions\": [\n" +
            "            {\n" +
            "              \"screen_name\": \"cleartax_in\",\n" +
            "              \"name\": \"ClearTax\",\n" +
            "              \"id\": 313723289,\n" +
            "              \"id_str\": \"313723289\",\n" +
            "              \"indices\": [\n" +
            "                70,\n" +
            "                82\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"screen_name\": \"LBCPAtips\",\n" +
            "              \"name\": \"LBCPA\",\n" +
            "              \"id\": 2811247590,\n" +
            "              \"id_str\": \"2811247590\",\n" +
            "              \"indices\": [\n" +
            "                83,\n" +
            "                93\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"screen_name\": \"OnePriceTaxes\",\n" +
            "              \"name\": \"OnePriceTaxes\",\n" +
            "              \"id\": 14307521,\n" +
            "              \"id_str\": \"14307521\",\n" +
            "              \"indices\": [\n" +
            "                94,\n" +
            "                108\n" +
            "              ]\n" +
            "            }\n" +
            "          ],\n" +
            "          \"urls\": [\n" +
            "            {\n" +
            "              \"url\": \"https://t.co/2wmqw6IDVW\",\n" +
            "              \"expanded_url\": \"http://paper.li/2009Tax/1427227225?edition_id=aebc92c0-4546-11e6-bfc9-0cc47a0d1609\",\n" +
            "              \"display_url\": \"paper.li/2009Tax/142722…\",\n" +
            "              \"indices\": [\n" +
            "                36,\n" +
            "                59\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        \"metadata\": {\n" +
            "          \"iso_language_code\": \"en\",\n" +
            "          \"result_type\": \"recent\"\n" +
            "        },\n" +
            "        \"source\": \"<a href=\\\"http://paper.li\\\" rel=\\\"nofollow\\\">Paper.li</a>\",\n" +
            "        \"in_reply_to_status_id\": null,\n" +
            "        \"in_reply_to_status_id_str\": null,\n" +
            "        \"in_reply_to_user_id\": null,\n" +
            "        \"in_reply_to_user_id_str\": null,\n" +
            "        \"in_reply_to_screen_name\": null,\n" +
            "        \"user\": {\n" +
            "          \"id\": 2155519795,\n" +
            "          \"id_str\": \"2155519795\",\n" +
            "          \"name\": \"Frazier Key\",\n" +
            "          \"screen_name\": \"2009Tax\",\n" +
            "          \"location\": \"\",\n" +
            "          \"description\": \"Amateur web specialist. Alcohol advocate. Avid bacon evangelist. Hipster-friendly coffee geek. Writer.\",\n" +
            "          \"url\": \"http://t.co/v3y75bNsg0\",\n" +
            "          \"entities\": {\n" +
            "            \"url\": {\n" +
            "              \"urls\": [\n" +
            "                {\n" +
            "                  \"url\": \"http://t.co/v3y75bNsg0\",\n" +
            "                  \"expanded_url\": \"http://2009Tax.org\",\n" +
            "                  \"display_url\": \"2009Tax.org\",\n" +
            "                  \"indices\": [\n" +
            "                    0,\n" +
            "                    22\n" +
            "                  ]\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            \"description\": {\n" +
            "              \"urls\": []\n" +
            "            }\n" +
            "          },\n" +
            "          \"protected\": false,\n" +
            "          \"followers_count\": 620,\n" +
            "          \"friends_count\": 205,\n" +
            "          \"listed_count\": 19,\n" +
            "          \"created_at\": \"Fri Oct 25 19:40:01 +0000 2013\",\n" +
            "          \"favourites_count\": 96,\n" +
            "          \"utc_offset\": -10800,\n" +
            "          \"time_zone\": \"Atlantic Time (Canada)\",\n" +
            "          \"geo_enabled\": false,\n" +
            "          \"verified\": false,\n" +
            "          \"statuses_count\": 4201,\n" +
            "          \"lang\": \"en\",\n" +
            "          \"contributors_enabled\": false,\n" +
            "          \"is_translator\": false,\n" +
            "          \"is_translation_enabled\": false,\n" +
            "          \"profile_background_color\": \"C6E2EE\",\n" +
            "          \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme2/bg.gif\",\n" +
            "          \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme2/bg.gif\",\n" +
            "          \"profile_background_tile\": false,\n" +
            "          \"profile_image_url\": \"http://pbs.twimg.com/profile_images/378800000646889625/9228d05c8328bcd6426daa92ac6126c4_normal.jpeg\",\n" +
            "          \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/378800000646889625/9228d05c8328bcd6426daa92ac6126c4_normal.jpeg\",\n" +
            "          \"profile_link_color\": \"1F98C7\",\n" +
            "          \"profile_sidebar_border_color\": \"C6E2EE\",\n" +
            "          \"profile_sidebar_fill_color\": \"DAECF4\",\n" +
            "          \"profile_text_color\": \"663B12\",\n" +
            "          \"profile_use_background_image\": true,\n" +
            "          \"has_extended_profile\": false,\n" +
            "          \"default_profile\": false,\n" +
            "          \"default_profile_image\": false,\n" +
            "          \"following\": null,\n" +
            "          \"follow_request_sent\": null,\n" +
            "          \"notifications\": null\n" +
            "        },\n" +
            "        \"geo\": null,\n" +
            "        \"coordinates\": null,\n" +
            "        \"place\": null,\n" +
            "        \"contributors\": null,\n" +
            "        \"is_quote_status\": false,\n" +
            "        \"retweet_count\": 1,\n" +
            "        \"favorite_count\": 0,\n" +
            "        \"favorited\": false,\n" +
            "        \"retweeted\": false,\n" +
            "        \"possibly_sensitive\": false,\n" +
            "        \"lang\": \"en\"\n" +
            "      },\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 1,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 20:00:59 +0000 2016\",\n" +
            "      \"id\": 751506388426383360,\n" +
            "      \"id_str\": \"751506388426383360\",\n" +
            "      \"text\": \"The latest Free Tax Filing Options! https://t.co/2wmqw6IDVW Thanks to @cleartax_in @LBCPAtips @OnePriceTaxes #crochet #ad\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"crochet\",\n" +
            "            \"indices\": [\n" +
            "              109,\n" +
            "              117\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"ad\",\n" +
            "            \"indices\": [\n" +
            "              118,\n" +
            "              121\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"cleartax_in\",\n" +
            "            \"name\": \"ClearTax\",\n" +
            "            \"id\": 313723289,\n" +
            "            \"id_str\": \"313723289\",\n" +
            "            \"indices\": [\n" +
            "              70,\n" +
            "              82\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"screen_name\": \"LBCPAtips\",\n" +
            "            \"name\": \"LBCPA\",\n" +
            "            \"id\": 2811247590,\n" +
            "            \"id_str\": \"2811247590\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              93\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"screen_name\": \"OnePriceTaxes\",\n" +
            "            \"name\": \"OnePriceTaxes\",\n" +
            "            \"id\": 14307521,\n" +
            "            \"id_str\": \"14307521\",\n" +
            "            \"indices\": [\n" +
            "              94,\n" +
            "              108\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/2wmqw6IDVW\",\n" +
            "            \"expanded_url\": \"http://paper.li/2009Tax/1427227225?edition_id=aebc92c0-4546-11e6-bfc9-0cc47a0d1609\",\n" +
            "            \"display_url\": \"paper.li/2009Tax/142722…\",\n" +
            "            \"indices\": [\n" +
            "              36,\n" +
            "              59\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://paper.li\\\" rel=\\\"nofollow\\\">Paper.li</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 2155519795,\n" +
            "        \"id_str\": \"2155519795\",\n" +
            "        \"name\": \"Frazier Key\",\n" +
            "        \"screen_name\": \"2009Tax\",\n" +
            "        \"location\": \"\",\n" +
            "        \"description\": \"Amateur web specialist. Alcohol advocate. Avid bacon evangelist. Hipster-friendly coffee geek. Writer.\",\n" +
            "        \"url\": \"http://t.co/v3y75bNsg0\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"http://t.co/v3y75bNsg0\",\n" +
            "                \"expanded_url\": \"http://2009Tax.org\",\n" +
            "                \"display_url\": \"2009Tax.org\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  22\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 620,\n" +
            "        \"friends_count\": 205,\n" +
            "        \"listed_count\": 19,\n" +
            "        \"created_at\": \"Fri Oct 25 19:40:01 +0000 2013\",\n" +
            "        \"favourites_count\": 96,\n" +
            "        \"utc_offset\": -10800,\n" +
            "        \"time_zone\": \"Atlantic Time (Canada)\",\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 4201,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"C6E2EE\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme2/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme2/bg.gif\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/378800000646889625/9228d05c8328bcd6426daa92ac6126c4_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/378800000646889625/9228d05c8328bcd6426daa92ac6126c4_normal.jpeg\",\n" +
            "        \"profile_link_color\": \"1F98C7\",\n" +
            "        \"profile_sidebar_border_color\": \"C6E2EE\",\n" +
            "        \"profile_sidebar_fill_color\": \"DAECF4\",\n" +
            "        \"profile_text_color\": \"663B12\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 1,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 19:34:06 +0000 2016\",\n" +
            "      \"id\": 751499620975468544,\n" +
            "      \"id_str\": \"751499620975468544\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/qzIHJtrlKO\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/qzIHJtrlKO\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/dines3670\",\n" +
            "            \"display_url\": \"cleartax.in/r/dines3670\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 141696879,\n" +
            "        \"id_str\": \"141696879\",\n" +
            "        \"name\": \"Dinesh (Dev) Verma\",\n" +
            "        \"screen_name\": \"dev8765\",\n" +
            "        \"location\": \"BANGALORE, INDIA\",\n" +
            "        \"description\": \"Network Support engineer at SkyHigh networks\",\n" +
            "        \"url\": \"https://t.co/8gHQ7eeNSv\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"https://t.co/8gHQ7eeNSv\",\n" +
            "                \"expanded_url\": \"http://technodew.com\",\n" +
            "                \"display_url\": \"technodew.com\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  23\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 98,\n" +
            "        \"friends_count\": 118,\n" +
            "        \"listed_count\": 1,\n" +
            "        \"created_at\": \"Sat May 08 19:38:15 +0000 2010\",\n" +
            "        \"favourites_count\": 48,\n" +
            "        \"utc_offset\": null,\n" +
            "        \"time_zone\": null,\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 146,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"000000\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/655028693119561728/bzp9QL0U_normal.jpg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/655028693119561728/bzp9QL0U_normal.jpg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/141696879/1382394506\",\n" +
            "        \"profile_link_color\": \"FA743E\",\n" +
            "        \"profile_sidebar_border_color\": \"000000\",\n" +
            "        \"profile_sidebar_fill_color\": \"000000\",\n" +
            "        \"profile_text_color\": \"000000\",\n" +
            "        \"profile_use_background_image\": false,\n" +
            "        \"has_extended_profile\": true,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 19:33:22 +0000 2016\",\n" +
            "      \"id\": 751499436879060992,\n" +
            "      \"id_str\": \"751499436879060992\",\n" +
            "      \"text\": \"I just e-Filed my Tax Returns with the super easy to use @ClearTax_In. You should try them out! https://t.co/x6cxOqKXFI\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"cleartax_in\",\n" +
            "            \"name\": \"ClearTax\",\n" +
            "            \"id\": 313723289,\n" +
            "            \"id_str\": \"313723289\",\n" +
            "            \"indices\": [\n" +
            "              57,\n" +
            "              69\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/x6cxOqKXFI\",\n" +
            "            \"expanded_url\": \"http://cleartax.in\",\n" +
            "            \"display_url\": \"cleartax.in\",\n" +
            "            \"indices\": [\n" +
            "              96,\n" +
            "              119\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 141696879,\n" +
            "        \"id_str\": \"141696879\",\n" +
            "        \"name\": \"Dinesh (Dev) Verma\",\n" +
            "        \"screen_name\": \"dev8765\",\n" +
            "        \"location\": \"BANGALORE, INDIA\",\n" +
            "        \"description\": \"Network Support engineer at SkyHigh networks\",\n" +
            "        \"url\": \"https://t.co/8gHQ7eeNSv\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"https://t.co/8gHQ7eeNSv\",\n" +
            "                \"expanded_url\": \"http://technodew.com\",\n" +
            "                \"display_url\": \"technodew.com\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  23\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 98,\n" +
            "        \"friends_count\": 118,\n" +
            "        \"listed_count\": 1,\n" +
            "        \"created_at\": \"Sat May 08 19:38:15 +0000 2010\",\n" +
            "        \"favourites_count\": 48,\n" +
            "        \"utc_offset\": null,\n" +
            "        \"time_zone\": null,\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 146,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"000000\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/655028693119561728/bzp9QL0U_normal.jpg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/655028693119561728/bzp9QL0U_normal.jpg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/141696879/1382394506\",\n" +
            "        \"profile_link_color\": \"FA743E\",\n" +
            "        \"profile_sidebar_border_color\": \"000000\",\n" +
            "        \"profile_sidebar_fill_color\": \"000000\",\n" +
            "        \"profile_text_color\": \"000000\",\n" +
            "        \"profile_use_background_image\": false,\n" +
            "        \"has_extended_profile\": true,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 18:18:44 +0000 2016\",\n" +
            "      \"id\": 751480654018125825,\n" +
            "      \"id_str\": \"751480654018125825\",\n" +
            "      \"text\": \"@architgupta I just love it. Ive always updated it on my own for years. My 2nfd time with @cleartax_in  This is a no brainer.\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"architgupta\",\n" +
            "            \"name\": \"Archit Gupta\",\n" +
            "            \"id\": 28971466,\n" +
            "            \"id_str\": \"28971466\",\n" +
            "            \"indices\": [\n" +
            "              0,\n" +
            "              12\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"screen_name\": \"cleartax_in\",\n" +
            "            \"name\": \"ClearTax\",\n" +
            "            \"id\": 313723289,\n" +
            "            \"id_str\": \"313723289\",\n" +
            "            \"indices\": [\n" +
            "              90,\n" +
            "              102\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": []\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\n" +
            "      \"in_reply_to_status_id\": 751341764661829632,\n" +
            "      \"in_reply_to_status_id_str\": \"751341764661829632\",\n" +
            "      \"in_reply_to_user_id\": 28971466,\n" +
            "      \"in_reply_to_user_id_str\": \"28971466\",\n" +
            "      \"in_reply_to_screen_name\": \"architgupta\",\n" +
            "      \"user\": {\n" +
            "        \"id\": 50006098,\n" +
            "        \"id_str\": \"50006098\",\n" +
            "        \"name\": \"SkinnyGirlDiariez\",\n" +
            "        \"screen_name\": \"SkinnygirlDee\",\n" +
            "        \"location\": \"Bengaluru, India\",\n" +
            "        \"description\": \"Fashion | Food | Travel | Tech | Finance - A Guide Book to a Classy Lifestyle! PR & Collabs: skinnygirldiariez@gmail.com #lifestyleblogger\",\n" +
            "        \"url\": \"https://t.co/SMA07ppKk6\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"https://t.co/SMA07ppKk6\",\n" +
            "                \"expanded_url\": \"http://www.skinnygirldiariez.com\",\n" +
            "                \"display_url\": \"skinnygirldiariez.com\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  23\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 533,\n" +
            "        \"friends_count\": 532,\n" +
            "        \"listed_count\": 61,\n" +
            "        \"created_at\": \"Tue Jun 23 15:28:23 +0000 2009\",\n" +
            "        \"favourites_count\": 1945,\n" +
            "        \"utc_offset\": 19800,\n" +
            "        \"time_zone\": \"New Delhi\",\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 3768,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"FF6699\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme11/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme11/bg.gif\",\n" +
            "        \"profile_background_tile\": true,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/735714061459939328/e9Eehk16_normal.jpg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/735714061459939328/e9Eehk16_normal.jpg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/50006098/1466075049\",\n" +
            "        \"profile_link_color\": \"B40B43\",\n" +
            "        \"profile_sidebar_border_color\": \"CC3366\",\n" +
            "        \"profile_sidebar_fill_color\": \"E5507E\",\n" +
            "        \"profile_text_color\": \"362720\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": true,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 1,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 17:47:21 +0000 2016\",\n" +
            "      \"id\": 751472754860232704,\n" +
            "      \"id_str\": \"751472754860232704\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/FE0vK9Fqzp\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/FE0vK9Fqzp\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/sourj6\",\n" +
            "            \"display_url\": \"cleartax.in/r/sourj6\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 32994313,\n" +
            "        \"id_str\": \"32994313\",\n" +
            "        \"name\": \"Sourjya Guha\",\n" +
            "        \"screen_name\": \"sourjyaguha\",\n" +
            "        \"location\": \"Bangalore\",\n" +
            "        \"description\": \"Avid Gööner, Intense Rider, Food Hogger, Hibernator, Android cult,\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 243,\n" +
            "        \"friends_count\": 913,\n" +
            "        \"listed_count\": 8,\n" +
            "        \"created_at\": \"Sat Apr 18 20:04:44 +0000 2009\",\n" +
            "        \"favourites_count\": 105,\n" +
            "        \"utc_offset\": 19800,\n" +
            "        \"time_zone\": \"New Delhi\",\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 16355,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"1A1B1F\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme9/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme9/bg.gif\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/500962495725453312/m2iMxTXI_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/500962495725453312/m2iMxTXI_normal.jpeg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/32994313/1408273737\",\n" +
            "        \"profile_link_color\": \"2FC2EF\",\n" +
            "        \"profile_sidebar_border_color\": \"181A1E\",\n" +
            "        \"profile_sidebar_fill_color\": \"252429\",\n" +
            "        \"profile_text_color\": \"666666\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 17:00:36 +0000 2016\",\n" +
            "      \"id\": 751460989988548608,\n" +
            "      \"id_str\": \"751460989988548608\",\n" +
            "      \"text\": \"ClearTax - Lead - Business Partnership (2-4 yrs) | https://t.co/vcR3njkCPi\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/vcR3njkCPi\",\n" +
            "            \"expanded_url\": \"http://www.iimjobs.com/j/cleartax-lead-business-partnership-2-4-yrs-353959.html?ref=tw\",\n" +
            "            \"display_url\": \"iimjobs.com/j/cleartax-lea…\",\n" +
            "            \"indices\": [\n" +
            "              51,\n" +
            "              74\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://www.iimjobs.com\\\" rel=\\\"nofollow\\\">iimjobs.com</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 529198976,\n" +
            "        \"id_str\": \"529198976\",\n" +
            "        \"name\": \"iimjobs Sales Jobs\",\n" +
            "        \"screen_name\": \"iimjobs_Sales\",\n" +
            "        \"location\": \"\",\n" +
            "        \"description\": \"\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 394,\n" +
            "        \"friends_count\": 1,\n" +
            "        \"listed_count\": 76,\n" +
            "        \"created_at\": \"Mon Mar 19 07:55:16 +0000 2012\",\n" +
            "        \"favourites_count\": 0,\n" +
            "        \"utc_offset\": null,\n" +
            "        \"time_zone\": null,\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 40130,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"C0DEED\",\n" +
            "        \"profile_background_image_url\": \"http://pbs.twimg.com/profile_background_images/461181696/bg.jpg\",\n" +
            "        \"profile_background_image_url_https\": \"https://pbs.twimg.com/profile_background_images/461181696/bg.jpg\",\n" +
            "        \"profile_background_tile\": true,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1936386213/sales_normal.png\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1936386213/sales_normal.png\",\n" +
            "        \"profile_link_color\": \"990000\",\n" +
            "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 16:31:01 +0000 2016\",\n" +
            "      \"id\": 751453546168651778,\n" +
            "      \"id_str\": \"751453546168651778\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/rzkbYkCQ1t\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/rzkbYkCQ1t\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/vipin372\",\n" +
            "            \"display_url\": \"cleartax.in/r/vipin372\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 2875304057,\n" +
            "        \"id_str\": \"2875304057\",\n" +
            "        \"name\": \"Vipin Sharma\",\n" +
            "        \"screen_name\": \"bffc018a8402422\",\n" +
            "        \"location\": \"\",\n" +
            "        \"description\": \"Andhera Chatega...Suraj Niklega...Kamal Khilega...Aur Lo Kamal Khil Bhi Gaya...\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 47,\n" +
            "        \"friends_count\": 126,\n" +
            "        \"listed_count\": 0,\n" +
            "        \"created_at\": \"Thu Nov 13 16:58:14 +0000 2014\",\n" +
            "        \"favourites_count\": 39,\n" +
            "        \"utc_offset\": null,\n" +
            "        \"time_zone\": null,\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 221,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"C0DEED\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/536421365142675456/oWV5S5U-_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/536421365142675456/oWV5S5U-_normal.jpeg\",\n" +
            "        \"profile_link_color\": \"0084B4\",\n" +
            "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": true,\n" +
            "        \"default_profile\": true,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 1,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 15:49:55 +0000 2016\",\n" +
            "      \"id\": 751443202616467457,\n" +
            "      \"id_str\": \"751443202616467457\",\n" +
            "      \"text\": \"That awkward moment when an air hostess wears a life vest while doing her taxes. https://t.co/inBEsbLSw6 https://t.co/UUO2LgxP0v\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/inBEsbLSw6\",\n" +
            "            \"expanded_url\": \"https://www.instagram.com/p/BHmyo8hj-y7/\",\n" +
            "            \"display_url\": \"instagram.com/p/BHmyo8hj-y7/\",\n" +
            "            \"indices\": [\n" +
            "              81,\n" +
            "              104\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 751443200544481280,\n" +
            "            \"id_str\": \"751443200544481280\",\n" +
            "            \"indices\": [\n" +
            "              105,\n" +
            "              128\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/Cm2pnA1WIAA4eNw.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/Cm2pnA1WIAA4eNw.jpg\",\n" +
            "            \"url\": \"https://t.co/UUO2LgxP0v\",\n" +
            "            \"display_url\": \"pic.twitter.com/UUO2LgxP0v\",\n" +
            "            \"expanded_url\": \"http://twitter.com/cleartax_in/status/751443202616467457/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 1024,\n" +
            "                \"h\": 1024,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 1024,\n" +
            "                \"h\": 1024,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://ifttt.com\\\" rel=\\\"nofollow\\\">IFTTT</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 313723289,\n" +
            "        \"id_str\": \"313723289\",\n" +
            "        \"name\": \"ClearTax\",\n" +
            "        \"screen_name\": \"cleartax_in\",\n" +
            "        \"location\": \"India\",\n" +
            "        \"description\": \"ClearTax India helps individuals prepare and e-file their Income Tax Return online. We maximize your tax deductions so you pay the lowest tax possible!\",\n" +
            "        \"url\": \"http://t.co/EFFTA9DQPe\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"http://t.co/EFFTA9DQPe\",\n" +
            "                \"expanded_url\": \"http://cleartax.in\",\n" +
            "                \"display_url\": \"cleartax.in\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  22\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 1046,\n" +
            "        \"friends_count\": 87,\n" +
            "        \"listed_count\": 30,\n" +
            "        \"created_at\": \"Thu Jun 09 03:26:41 +0000 2011\",\n" +
            "        \"favourites_count\": 1215,\n" +
            "        \"utc_offset\": -36000,\n" +
            "        \"time_zone\": \"Hawaii\",\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 1949,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"C0DEED\",\n" +
            "        \"profile_background_image_url\": \"http://pbs.twimg.com/profile_background_images/458964825960230912/cSQlNgoi.png\",\n" +
            "        \"profile_background_image_url_https\": \"https://pbs.twimg.com/profile_background_images/458964825960230912/cSQlNgoi.png\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/701653900588265472/AOsZf2ep_normal.png\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/701653900588265472/AOsZf2ep_normal.png\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/313723289/1464776564\",\n" +
            "        \"profile_link_color\": \"131516\",\n" +
            "        \"profile_sidebar_border_color\": \"FFFFFF\",\n" +
            "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 15:15:48 +0000 2016\",\n" +
            "      \"id\": 751434616091840512,\n" +
            "      \"id_str\": \"751434616091840512\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/OFHgE1Zf7H\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/OFHgE1Zf7H\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/danie89\",\n" +
            "            \"display_url\": \"cleartax.in/r/danie89\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 97790162,\n" +
            "        \"id_str\": \"97790162\",\n" +
            "        \"name\": \"Danny\",\n" +
            "        \"screen_name\": \"d4dany\",\n" +
            "        \"location\": \"Chennai\",\n" +
            "        \"description\": \"Why do u care ?\",\n" +
            "        \"url\": \"http://t.co/AvXLFvxXh6\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"http://t.co/AvXLFvxXh6\",\n" +
            "                \"expanded_url\": \"http://danview.net\",\n" +
            "                \"display_url\": \"danview.net\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  22\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 517,\n" +
            "        \"friends_count\": 340,\n" +
            "        \"listed_count\": 3,\n" +
            "        \"created_at\": \"Sat Dec 19 01:32:30 +0000 2009\",\n" +
            "        \"favourites_count\": 85,\n" +
            "        \"utc_offset\": 19800,\n" +
            "        \"time_zone\": \"Chennai\",\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 24229,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"1A1B1F\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme9/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme9/bg.gif\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/492597634041786369/xe4v8e4l_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/492597634041786369/xe4v8e4l_normal.jpeg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/97790162/1412174807\",\n" +
            "        \"profile_link_color\": \"3A08D1\",\n" +
            "        \"profile_sidebar_border_color\": \"FFFFFF\",\n" +
            "        \"profile_sidebar_fill_color\": \"252429\",\n" +
            "        \"profile_text_color\": \"666666\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": true,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 14:14:52 +0000 2016\",\n" +
            "      \"id\": 751419282446168068,\n" +
            "      \"id_str\": \"751419282446168068\",\n" +
            "      \"text\": \"Comparison of Income Tax Filing Websites:IncomeTaxEfiling,ClearTax,etc https://t.co/kPI3Wtvlc7\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/kPI3Wtvlc7\",\n" +
            "            \"expanded_url\": \"http://www.bemoneyaware.com/blog/comparison-income-tax-itr-filing-websites/\",\n" +
            "            \"display_url\": \"bemoneyaware.com/blog/compariso…\",\n" +
            "            \"indices\": [\n" +
            "              71,\n" +
            "              94\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 3285464342,\n" +
            "        \"id_str\": \"3285464342\",\n" +
            "        \"name\": \"Ram\",\n" +
            "        \"screen_name\": \"ReddyMRM\",\n" +
            "        \"location\": \"\",\n" +
            "        \"description\": \"\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 10,\n" +
            "        \"friends_count\": 37,\n" +
            "        \"listed_count\": 1,\n" +
            "        \"created_at\": \"Mon Jul 20 14:21:22 +0000 2015\",\n" +
            "        \"favourites_count\": 15,\n" +
            "        \"utc_offset\": null,\n" +
            "        \"time_zone\": null,\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 74,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"C0DEED\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://abs.twimg.com/sticky/default_profile_images/default_profile_6_normal.png\",\n" +
            "        \"profile_image_url_https\": \"https://abs.twimg.com/sticky/default_profile_images/default_profile_6_normal.png\",\n" +
            "        \"profile_link_color\": \"0084B4\",\n" +
            "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": true,\n" +
            "        \"default_profile_image\": true,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 12:57:05 +0000 2016\",\n" +
            "      \"id\": 751399707637788676,\n" +
            "      \"id_str\": \"751399707637788676\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/7WnjQinUoi\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/7WnjQinUoi\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/kshit314\",\n" +
            "            \"display_url\": \"cleartax.in/r/kshit314\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 103614010,\n" +
            "        \"id_str\": \"103614010\",\n" +
            "        \"name\": \"Kshitiz Anand\",\n" +
            "        \"screen_name\": \"anandkshitiz\",\n" +
            "        \"location\": \"Bengaluru\",\n" +
            "        \"description\": \"IT Consultant, Oracle | https://t.co/In7vBJVt1H ,NIT Rourkela\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"https://t.co/In7vBJVt1H\",\n" +
            "                \"expanded_url\": \"http://B.Tech\",\n" +
            "                \"display_url\": \"B.Tech\",\n" +
            "                \"indices\": [\n" +
            "                  24,\n" +
            "                  47\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 118,\n" +
            "        \"friends_count\": 618,\n" +
            "        \"listed_count\": 1,\n" +
            "        \"created_at\": \"Sun Jan 10 17:02:22 +0000 2010\",\n" +
            "        \"favourites_count\": 28,\n" +
            "        \"utc_offset\": 19800,\n" +
            "        \"time_zone\": \"New Delhi\",\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 202,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"ACDED6\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme18/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme18/bg.gif\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/671712724993183745/eyjkrRdB_normal.jpg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/671712724993183745/eyjkrRdB_normal.jpg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/103614010/1398527363\",\n" +
            "        \"profile_link_color\": \"89C9FA\",\n" +
            "        \"profile_sidebar_border_color\": \"000000\",\n" +
            "        \"profile_sidebar_fill_color\": \"F6F6F6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 12:37:39 +0000 2016\",\n" +
            "      \"id\": 751394818614439936,\n" +
            "      \"id_str\": \"751394818614439936\",\n" +
            "      \"text\": \"I just e-Filed my Tax Returns with the super easy to use @ClearTax_In. You should try them out! https://t.co/h8MZcKDQ5D\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"cleartax_in\",\n" +
            "            \"name\": \"ClearTax\",\n" +
            "            \"id\": 313723289,\n" +
            "            \"id_str\": \"313723289\",\n" +
            "            \"indices\": [\n" +
            "              57,\n" +
            "              69\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/h8MZcKDQ5D\",\n" +
            "            \"expanded_url\": \"http://cleartax.in\",\n" +
            "            \"display_url\": \"cleartax.in\",\n" +
            "            \"indices\": [\n" +
            "              96,\n" +
            "              119\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 103614010,\n" +
            "        \"id_str\": \"103614010\",\n" +
            "        \"name\": \"Kshitiz Anand\",\n" +
            "        \"screen_name\": \"anandkshitiz\",\n" +
            "        \"location\": \"Bengaluru\",\n" +
            "        \"description\": \"IT Consultant, Oracle | https://t.co/In7vBJVt1H ,NIT Rourkela\",\n" +
            "        \"url\": null,\n" +
            "        \"entities\": {\n" +
            "          \"description\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"https://t.co/In7vBJVt1H\",\n" +
            "                \"expanded_url\": \"http://B.Tech\",\n" +
            "                \"display_url\": \"B.Tech\",\n" +
            "                \"indices\": [\n" +
            "                  24,\n" +
            "                  47\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 118,\n" +
            "        \"friends_count\": 618,\n" +
            "        \"listed_count\": 1,\n" +
            "        \"created_at\": \"Sun Jan 10 17:02:22 +0000 2010\",\n" +
            "        \"favourites_count\": 28,\n" +
            "        \"utc_offset\": 19800,\n" +
            "        \"time_zone\": \"New Delhi\",\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 202,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"ACDED6\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme18/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme18/bg.gif\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/671712724993183745/eyjkrRdB_normal.jpg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/671712724993183745/eyjkrRdB_normal.jpg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/103614010/1398527363\",\n" +
            "        \"profile_link_color\": \"89C9FA\",\n" +
            "        \"profile_sidebar_border_color\": \"000000\",\n" +
            "        \"profile_sidebar_fill_color\": \"F6F6F6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 1,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"created_at\": \"Fri Jul 08 11:50:39 +0000 2016\",\n" +
            "      \"id\": 751382990433898497,\n" +
            "      \"id_str\": \"751382990433898497\",\n" +
            "      \"text\": \"I just e-filed via ClearTax and it was so AWESOME! Make sure you e-file with them! https://t.co/3gHo61DXwe\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/3gHo61DXwe\",\n" +
            "            \"expanded_url\": \"https://cleartax.in/r/anagh110\",\n" +
            "            \"display_url\": \"cleartax.in/r/anagh110\",\n" +
            "            \"indices\": [\n" +
            "              83,\n" +
            "              106\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"metadata\": {\n" +
            "        \"iso_language_code\": \"en\",\n" +
            "        \"result_type\": \"recent\"\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web Client</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 137372715,\n" +
            "        \"id_str\": \"137372715\",\n" +
            "        \"name\": \"Anagha Khobragade\",\n" +
            "        \"screen_name\": \"anaghark\",\n" +
            "        \"location\": \"Bangalore, India\",\n" +
            "        \"description\": \"I'm Anagha, a very straight forward person. My desire is that my entire life should bring a WONDROUS SONG in my HEART and a LIVELY DANCE in my STEP.\",\n" +
            "        \"url\": \"http://t.co/xZ7jc0PDsh\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"http://t.co/xZ7jc0PDsh\",\n" +
            "                \"expanded_url\": \"http://www.hp.com\",\n" +
            "                \"display_url\": \"hp.com\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  22\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 60,\n" +
            "        \"friends_count\": 80,\n" +
            "        \"listed_count\": 2,\n" +
            "        \"created_at\": \"Mon Apr 26 15:25:47 +0000 2010\",\n" +
            "        \"favourites_count\": 0,\n" +
            "        \"utc_offset\": -18000,\n" +
            "        \"time_zone\": \"Quito\",\n" +
            "        \"geo_enabled\": true,\n" +
            "        \"verified\": false,\n" +
            "        \"statuses_count\": 407,\n" +
            "        \"lang\": \"en\",\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"709397\",\n" +
            "        \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme6/bg.gif\",\n" +
            "        \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme6/bg.gif\",\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/441515282343792640/UZJefQJd_normal.jpeg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/441515282343792640/UZJefQJd_normal.jpeg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/137372715/1452177900\",\n" +
            "        \"profile_link_color\": \"DB03CD\",\n" +
            "        \"profile_sidebar_border_color\": \"FFFFFF\",\n" +
            "        \"profile_sidebar_fill_color\": \"7AC3EE\",\n" +
            "        \"profile_text_color\": \"3D1957\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": false,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"search_metadata\": {\n" +
            "    \"completed_in\": 0.038,\n" +
            "    \"max_id\": 751622036233949185,\n" +
            "    \"max_id_str\": \"751622036233949185\",\n" +
            "    \"next_results\": \"?max_id=751382990433898496&q=cleartax%20-%23cleartax&include_entities=1\",\n" +
            "    \"query\": \"cleartax+-%23cleartax\",\n" +
            "    \"refresh_url\": \"?since_id=751622036233949185&q=cleartax%20-%23cleartax&include_entities=1\",\n" +
            "    \"count\": 15,\n" +
            "    \"since_id\": 0,\n" +
            "    \"since_id_str\": \"0\"\n" +
            "  }\n" +
            "}";
}
