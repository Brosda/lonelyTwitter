package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abrosda on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();


    public void addTweet(Tweet tweet){
            if (tweets.contains(tweet)) {
                throw new IllegalArgumentException();
            }  else {
                tweets.add(tweet);
            }
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }


   // public ArrayList getTweets() {
      //  ArrayList<Tweet> nTweet = new ArrayList<Tweet>();
       // for (int i = 0; i < this.getCount(); i++) {
       //     nTweet.add(this.getTweet(i));
      //  }
        // for (int i = 1; i < nTweet.size(); i++) {
        //if (nTweet.get(i).getDate() < (nTweet.get(i-1).getDate())) {
        //   Tweet bTweet = nTweet.get(i-1);
        //     nTweet.remove(i-1);
        //     nTweet.add(bTweet);
        // }
        //  }
        // return
    //}

    public Tweet getTweet(int index){
        return tweets.get(index);
    }
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);

    }
    public int getCount(){
        return tweets.size();
    }


}
