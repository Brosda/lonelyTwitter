package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abrosda on 1/12/16.
 */
public class ImportantTweets extends Tweet implements Tweetable {
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public ImportantTweets(Date date, String message) {
        super(date, message);
       // this.setIsImportant(Boolean.TRUE);
    }

    public Date getDate(){
        return this.date;
    }
    public String getMessage() {
        return "!IMPORTANT! " + this.message;
    }

    public ImportantTweets(String message) {
        super(message);
    }
}
