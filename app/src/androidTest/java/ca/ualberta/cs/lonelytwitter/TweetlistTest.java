package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;

/**
 * Created by abrosda on 1/26/16.
 */
public class TweetlistTest extends ActivityInstrumentationTestCase2 {

    public TweetlistTest() {
        super(LonelyTwitterActivity.class);
    }



    public void testAddTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));

        try {
            tweets.addTweet(tweet);
            fail();
        }catch(Exception exception){

        }

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweets.hasTweet(tweet));
        tweets.addTweet(tweet);
        tweets.hasTweet(tweet);


        assertTrue(tweets.hasTweet(tweet));
    }


    public void testremoveTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        tweets.removeTweet(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }


    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        Tweet returnedTweet = tweets.getTweet(0);

        assertEquals(returnedTweet.getMessage(),tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());


    }

    public void testgetCount(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);
        assertEquals(1,tweets.getCount());

    }


    public void testgetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");
        Tweet tweet2 = new NormalTweet("Test tweet");
        tweets.addTweet(tweet);
        tweets.addTweet(tweet2);

        //ArrayList newTweets = tweets.getTweets();
        for (int i = 0; i < 2; i++){
          //  assertEquals(newTweets.get(i).getDate(), tweets.getTweet(i).getDate() );

        }

    }

}
