package chapter11;

import java.io.Serializable;
import java.util.ArrayList;

public class TweetArrayBean implements Serializable {

  private ArrayList<TweetBean> TweetArray;

  public TweetArrayBean() {
    TweetArray = new ArrayList<TweetBean>();
  }

  public void addTweet(TweetBean obj) {
    TweetArray.add(obj);
  }

  public int getArraySize() {
    return TweetArray.size();
  }

  public ArrayList<TweetBean> getTweetArray() {
    return TweetArray;
  }

  public void setTweetArray(ArrayList<TweetBean> TweetArray) {
    this.TweetArray = TweetArray;
  }

}
