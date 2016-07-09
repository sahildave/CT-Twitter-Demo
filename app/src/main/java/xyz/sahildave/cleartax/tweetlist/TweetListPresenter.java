package xyz.sahildave.cleartax.tweetlist;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

import timber.log.Timber;
import xyz.sahildave.cleartax.data.list.TweetListRepository;
import xyz.sahildave.cleartax.data.model.Tweet;

import static xyz.sahildave.cleartax.util.Common.checkNotNull;

/**
 * Created by sahil on 9/7/16.
 */
public class TweetListPresenter implements TweetListContract.UserActionsListener{
    private final TweetListRepository mTweetListRepository;
    private final TweetListContract.View mTweetListView;


    private int visibleThreshold = 2;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;

    public TweetListPresenter(@NonNull TweetListRepository tweetListRepository,
                              @NonNull TweetListContract.View tweetListView) {
        mTweetListRepository = checkNotNull(tweetListRepository);
        mTweetListView = checkNotNull(tweetListView);
    }

    /**
     * Can be used for creating pagination in the recyclerview
     * @param recyclerView
     */
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
                }
            }
        });
    }


    /**
     * Gets tweet from the repo provided by {@link TweetListActivity}
     * For prod/dev {@link xyz.sahildave.cleartax.data.list.InMemoryTweetListRepository}
     * Process the tweets for the most used words.
     * Sends back the tweets and the most used words map.
     * @param forceUpdate
     */
    @Override
    public void loadTweets(boolean forceUpdate) {
        if (forceUpdate) {
            mTweetListView.showEmpty();
        }

        mTweetListRepository.getTweets(new TweetListRepository.LoadTweetListCallback() {
            @Override
            public void onFetchTokenStarted() {
                mTweetListView.setProgressIndicator(true, "Fetching Token");
            }

            @Override
            public void onFetchTokenComplete() {
                mTweetListView.setProgressIndicator(true, "Token Fetched");
            }

            @Override
            public void onTweetListLoading(long sinceId, int listSize) {
                mTweetListView.setProgressIndicator(true, "Fetched " + listSize+" tweets");
            }

            @Override
            public void onTweetListLoaded(List<Tweet> tweets, long page, boolean complete) {
                mTweetListView.setTweets(tweets);

                String tweetString = "";
                for (Tweet tweet : tweets) {
                    tweetString = tweetString + tweet.getText() + " ";
                }
                Timber.d("------------");
                Timber.d(tweetString);
                Timber.d("------------");

                int quantity = 3;
                Map<String, Integer> words = getWordMap(tweetString);

                // Creating an priorityQueue. Keeps the least common element on top.
                // Top element would be used to compare the count.
                final PriorityQueue<WordCount> countHeap = new PriorityQueue<WordCount>(quantity);

                // Go through the word map and compare the current word's count with the least in
                // the count heap
                for (final Entry<String, Integer> entry : words.entrySet()) {
                    if (countHeap.size() < quantity) {
                        countHeap.add(new WordCount(entry.getKey(), entry.getValue()));
                    } else if (entry.getValue() > countHeap.peek().getCount()) {
                        countHeap.remove();
                        countHeap.add(new WordCount(entry.getKey(), entry.getValue()));
                    }
                }

                // ArrayMap sorts the map again by the key i.e. count
                final Map<Integer, String> frequencyMap = new ArrayMap<>();
                while (countHeap.size() > 0) {
                    WordCount remove = countHeap.remove();
                    Timber.d(remove.toString());
                    frequencyMap.put(remove.getCount(), remove.getWord());
                }

                mTweetListView.showResult(frequencyMap);
            }
        }, 100);

    }

    /**
     * @param tweetString the string to be processed
     * @return Returns Word of map with key as the word and Integer as value
     */
    private Map<String, Integer> getWordMap(String tweetString) {
        final Map<String, Integer> wordMap = new HashMap<String, Integer>();
        String[] tweetStringArray = tweetString.split(" ");
        for (String word : tweetStringArray) {
            int count = 1;
            word = word.trim();
            if (wordMap.containsKey(word)) {
                count = wordMap.get(word) + 1;
            }
            wordMap.put(word, count);
        }
        return wordMap;
    }

    final class WordCount implements Comparable<WordCount> {
        private String word;
        private int count;

        public WordCount(final String string, final int count) {
            word = string;
            this.count = count;
        }

        @Override
        public int compareTo(final WordCount that) {
            int lhs = this.count;
            int rhs = that.count;
            return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
        }

        public int getCount() {
            return count;
        }

        public String getWord() {
            return word;
        }

        @Override
        public String toString() {
            return "WordCount{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
