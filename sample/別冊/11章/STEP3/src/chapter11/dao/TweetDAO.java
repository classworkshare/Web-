package chapter11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import chapter11.exception.DatabaseException;
import chapter11.exception.SystemException;
import chapter11.parameter.ExceptionParameters;
import chapter11.parameter.TweetParameters;
import chapter11.tweet.TweetArrayBean;
import chapter11.tweet.TweetBean;

public class TweetDAO extends DAOBase {

  public TweetArrayBean getTweetArray() throws DatabaseException,
      SystemException {
    Statement stmt = null;
    TweetArrayBean tweetArray = new TweetArrayBean();
    this.open();
    try {
      stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(TweetParameters.SQL_SELECT_ALL);
      while (rs.next()) {
        TweetBean record = new TweetBean();
        record.setName(rs.getString(TweetParameters.NAME));
        record.setTweet(rs.getString(TweetParameters.TWEET));
        record.setDatetime(rs.getTimestamp(TweetParameters.DATE));
        tweetArray.addTweet(record);
      }
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    return tweetArray;
  }

  public TweetArrayBean getPersonTweetArray(String name)
      throws DatabaseException, SystemException {
    PreparedStatement stmt = null;
    TweetArrayBean tweetArray = new TweetArrayBean();
    this.open();
    try {
      stmt = con.prepareStatement(TweetParameters.SQL_SELECT_PERSON);
      stmt.setString(1, name);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        TweetBean record = new TweetBean();
        record.setName(rs.getString(TweetParameters.NAME));
        record.setTweet(rs.getString(TweetParameters.TWEET));
        record.setDatetime(rs.getTimestamp(TweetParameters.DATE));
        tweetArray.addTweet(record);
      }
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
    return tweetArray;
  }

  public void setTweet(TweetBean tweet) throws DatabaseException,
      SystemException {
    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con.prepareStatement(TweetParameters.SQL_INSERT);
      stmt.setString(1, tweet.getName());
      stmt.setString(2, tweet.getTweet());
      stmt.setString(3, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
          .format(tweet.getDatetime()));
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
  }

  public void deleteTweet(String name) throws DatabaseException,
      SystemException {
    PreparedStatement stmt = null;
    this.open();
    try {
      stmt = con.prepareStatement(TweetParameters.SQL_DELETE);
      stmt.setString(1, name);
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseException(
          ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE, e);
    } finally {
      this.close(stmt);
    }
  }
}
