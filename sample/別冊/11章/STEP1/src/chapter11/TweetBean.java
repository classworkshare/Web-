package chapter11;

import java.io.Serializable;
import java.util.Date;

public class TweetBean implements Serializable {

  private String name;
  private String Tweet;
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
    return Tweet;
  }

  public void setTweet(String Tweet) {
    this.Tweet = Tweet;
  }

  public Date getDatetime() {
    return datetime;
  }

  public void setDatetime(Date datetime) {
    this.datetime = datetime;
  }

}
