package bits.org.mtech.ecomuser.Model;

public class UserData {
  private Long userId;
  private String userName;

  public UserData(Long userId, String userName) {
    this.userId = userId;
    this.userName = userName;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}
