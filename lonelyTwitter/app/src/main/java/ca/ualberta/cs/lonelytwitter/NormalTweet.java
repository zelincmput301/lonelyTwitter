package ca.ualberta.cs.lonelytwitter;

/**
 * Created by zelin on 1/19/17.
 */

public class NormalTweet extends Tweet {

    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
