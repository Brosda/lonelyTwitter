package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abrosda on 1/12/16.
 * This class is for the funny mood and sets the mood of a tweet to funny<br>
 *Main activities will be similar to angry class but for funny mode
 *@See angry.java for more info
 */
public class funny extends mood{

    private Date date;

    public funny(Date date) {
        this.date = date;
    }
    public funny() {
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setmood() {
        mood = "funny";
    }

}