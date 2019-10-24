package chapter11.parameter;

public class TweetParameters {
  public static final String SQL_SELECT_ALL = "SELECT * FROM TWEET ORDER BY DATE DESC";
  public static final String SQL_SELECT_PERSON = "SELECT * FROM TWEET WHERE NAME = ? ORDER BY DATE DESC";

  public static final String SQL_INSERT = "INSERT INTO TWEET VALUES(?,?,?)";

  public static final String NAME = "NAME";
  public static final String TWEET = "TWEET";
  public static final String DATE = "DATE";
}
