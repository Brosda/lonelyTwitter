package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abrosda on 1/12/16.
 * This is the angry mood class that sets a tweets mood to angry<br>
 *A list of important activites in this class are
 * <ul>
 *    public angry
 *    public setmood
 *    public getDate
 * </ul>
 * @See angry,java for more info
 *
 *
 */
public class angry extends mood {
    private Date date;
    public angry(Date date) {
        this.date = date;
    }

    public angry(){
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setmood(){
        mood =  "angry";
    }
}
