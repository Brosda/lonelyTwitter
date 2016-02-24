package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        protected ArrayList<Tweet> doInBackground(String... search_strings){
            verifyClient();
            //start our initial array list (empty)
            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            Search search = new Search.Builder(search_strings[0]).addIndex("testing").addType("tweet").build();

            try {
                SearchResult execute = client.execute(search);
                //TODO add an error message
        //TODO Right here trigger if insert fails
                if(execute.isSucceeded()) {
                    //Return tweet list
                    List<NormalTweet> returned_tweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(returned_tweets);
                } else {
                    Log.i("TODO", "We don't know why but we get an error here");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    public static ArrayList<Tweet> getTweets() {
       verifyClient();
        return null;
    }
    //TODO: A function that adds a tweet


    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void> {
        @Override
        protected Void doInBackground(NormalTweet... tweets) {
            verifyClient();

            //Since Async works on arrays we have to as well
            for(int i = 0; i <tweets.length; i++) {
                NormalTweet tweet = tweets[i];

                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()){
                        tweet.setId(result.getId());
                    }
                    else {
                        //TODO add an error message
                        //TODO Right here trigger if insert fails
                        Log.i("TODO", "We don't know why but we get an error here");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
    public static void verifyClient() {
        //Verify the client exists
        //if not make it
        // TODO Put this url somewhere better http://cmput301.softwareprocess.es:8080
        if(client == null){
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }

    }
}
