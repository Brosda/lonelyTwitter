package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by abrosda on 1/12/16.
 * Mood class to control moods of tweets like funny and angry
 * Auto sets a tweets mood to angry if not specified
 * Has constructor and getter only
 * @See mood.java
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
