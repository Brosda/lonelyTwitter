package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 *Inherits from the tweet class. Is a more important version of a Tweet
 *Same as a Normal Tweet but will print !IMPORTANT! infrom of messages
 * @See Tweet.java
 */
public class ImportantTweet extends Tweet implements Tweetable {
    /**
     * sets the tweet to Impostant
     * @return true so the tweet is now important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    public ImportantTweet(String message) {
        super(message);
    }

    public Date getDate() {
        return this.date;
    }

    /**
     * Modifies the message to include an important notice infront
     * @return the message plus new notice
     */
    public String getMessage() {
        return "!IMPORTANT! " + this.message;
    }
}
