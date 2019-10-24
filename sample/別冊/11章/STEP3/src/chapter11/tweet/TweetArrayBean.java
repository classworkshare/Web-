package chapter11.tweet;

import java.io.Serializable;
import java.util.ArrayList;

public class TweetArrayBean implements Serializable {

  private ArrayList<TweetBean> tweetArray;

  public TweetArrayBean() {
    tweetArray = new ArrayList<TweetBean>();
  }

  public void addTweet(TweetBean obj) {
    tweetArray.add(obj);
  }

  public int getArraySize() {
    return tweetArray.size();
  }

  public ArrayList<TweetBean> getTweetArray() {
    return tweetArray;
  }

  public void setTweetArray(ArrayList<TweetBean> tweetArray) {
    this.tweetArray = tweetArray;
  }

}
