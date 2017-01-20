package ca.ualberta.cs.lonelytwitter;

/**
 * Created by zelin on 1/19/17.
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
