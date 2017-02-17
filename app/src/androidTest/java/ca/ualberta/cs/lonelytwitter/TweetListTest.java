package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by zelin on 2/16/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{
    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }


    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("some tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try{
            Tweet tweet2 = new NormalTweet("some tweet");
            tweets.add(tweet);
            fail();
        } catch (IllegalArgumentException e){
        }
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }



    public void testGetTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");

        tweets.add(tweet);
        NormalTweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweets() throws InterruptedException {
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("1");
        Thread.sleep(100);
        NormalTweet tweet2 = new NormalTweet("2");
        Thread.sleep(100);
        NormalTweet tweet3 = new NormalTweet("3");

        tweets.add(tweet3);
        tweets.add(tweet2);
        tweets.add(tweet);

        ArrayList<NormalTweet> returnedTweets = tweets.getTweets();

        for (int n = 0; n < returnedTweets.size() -1 ;n++){
            assertTrue(returnedTweets.get(n).getDate().before(returnedTweets.get(n + 1).getDate()));
        }


    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        NormalTweet tweet = new NormalTweet("some tweet");
        NormalTweet tweet2 = new NormalTweet("another tweet");

        tweets.add(tweet);
        tweets.add(tweet2);
        assertEquals(tweets.getCount(), 2);

    }
}
