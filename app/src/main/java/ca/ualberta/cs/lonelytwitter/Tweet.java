package ca.ualberta.cs.lonelytwitter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**

 * Created by romansky on 1/12/16.
 * This is the main object class of this app
 * A tweet consists of a message and a date.
 * Also has an arraylist of moods
 * <br>
 * Some important functions are:
 * <ul>
 *     setMessage() which checks for message length
 *     Tweet()
 *     getMessage
 *     getDate
 *     toString
 * </ul>
 */
public abstract class Tweet {
    protected Date date;
    protected String message;
    protected ArrayList<mood> moods;

    /**
     * determines whether a tweet is or is not important
     * @return either true ofr false
     */
    public abstract Boolean isImportant();

    /**
     * Constructs a tweet object
     * @param date the date the tweet was made
     * @param message the content of the tweet
     */
    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;

    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    /**
     * Checks for message length else it sets the message to param
     * @param message the string that contains the text of the tweet
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();

        }
        this.message = message;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<mood> getMoods() {
        return moods;
    }

    public void setMoods(ArrayList<mood> moods) {
        this.moods = moods;
    }

    /**
     * makes the tweet displayable by the list view item
     * @return returns a formated string to be shown to the user
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
