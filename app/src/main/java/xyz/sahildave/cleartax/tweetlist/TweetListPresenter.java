package xyz.sahildave.cleartax.tweetlist;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Timber.d("loadTweets: %s", "forceUpdate = [" + forceUpdate + "]");

        mTweetListRepository.getTweets(mTweetListView, currentPage, new TweetListRepository.LoadTweetListCallback() {
            @Override
            public void onFetchTokenStarted() {
                mTweetListView.setProgressIndicator(true, "Fetching Token");
            }

            @Override
            public void onFetchTokenComplete() {
                mTweetListView.setProgressIndicator(true, "Token Fetched");
            }

            @Override
            public void onTweetListLoading(int page, int listSize) {
                mTweetListView.setProgressIndicator(true, "Fetched " + listSize+" tweets, Page - "+page);
            }

            @Override
            public void onTweetListLoaded(List<Tweet> tweets, int page, boolean complete) {
                Timber.d("onTweetListLoaded: %s", "tweets = [" + tweets.size());
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
                final PriorityQueue<WordCount> countHeap = new PriorityQueue<WordCount>(quantity);

                for (final Map.Entry<String, Integer> entry : words.entrySet()) {
                    if (countHeap.size() < quantity) {
                        countHeap.add(new WordCount(entry.getKey(), entry.getValue()));
                    } else if (entry.getValue() > countHeap.peek().getCount()) {
                        countHeap.remove();
                        countHeap.add(new WordCount(entry.getKey(), entry.getValue()));
                    }
                }

                Timber.d("%s - %s", 1, countHeap.peek());

                final Map<String, Integer> frequencyMap = new ArrayMap<>();
                while (countHeap.size() > 0) {
                    WordCount remove = countHeap.remove();
                    Timber.d(remove.toString());
                    frequencyMap.put(remove.getWord(), remove.getCount());
                }


                mTweetListView.showResult(frequencyMap);
            }
        }, 100);

    }

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
        public int compareTo(final WordCount b) {
            return Integer.compare(this.count, b.count);
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
