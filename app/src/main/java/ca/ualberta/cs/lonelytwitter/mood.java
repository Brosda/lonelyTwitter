package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abrosda on 1/12/16.
 */
public abstract class mood {

    protected String mood;

    public mood(String mood) {
        this.mood = mood;
    }
    public mood(){
        mood = "angry";
    }

    public String getmood() {
        return mood;
    }
}
