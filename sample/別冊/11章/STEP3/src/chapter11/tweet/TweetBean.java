package chapter11.tweet;

import java.io.Serializable;
import java.util.Date;

public class TweetBean implements Serializable {

  private String name;
  private String tweet;
  private Date datetime;

  public TweetBean() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTweet() {
    return tweet;
  }

  public void setTweet(String tweet) {
    this.tweet = tweet;
  }

  public Date getDatetime() {
    return datetime;
  }

  public void setDatetime(Date datetime) {
    this.datetime = datetime;
  }

}
