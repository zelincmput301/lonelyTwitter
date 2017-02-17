package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zelin on 2/16/17.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets = new ArrayList<NormalTweet>();

    public void add(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }
        else {
            tweets.add((NormalTweet) tweet);
        }
    }


    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public  NormalTweet getTweet(int index) {
//        return new NormalTweet("not the tweet");
        return tweets.get(0);
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public ArrayList<NormalTweet> getTweets(){
        Collections.sort(tweets);
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }
}
