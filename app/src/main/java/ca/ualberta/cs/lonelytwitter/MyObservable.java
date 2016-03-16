package ca.ualberta.cs.lonelytwitter;

/**
 * Created by abrosda on 3/8/16.
 */
public interface MyObservable {
    public void registerObserver(Object o);
    public void myNotifyAll();

}
