package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**

 * Created by romansky on 1/12/16.
 * Extends Tweet class
 * Is a normal version of a Tweet.<br>
 *A Tweet must be either normal or Important
 * <br>
 * Important activities are
 * <ul>
 *     NormalTweet
 *     getDate
 *     getMessage
 *     isImportant
 * </ul>
 * <br>
 * To learn more
 * @see NormalTweet
 */
public class NormalTweet extends Tweet implements Tweetable {
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    public NormalTweet(String message) {
        super(message);
    }


    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }

}
