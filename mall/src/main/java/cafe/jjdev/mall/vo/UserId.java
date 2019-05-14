package cafe.jjdev.mall.vo;

public class UserId {

	private String userId;
	private String userGender;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	@Override
	public String toString() {
		return "UserId [userId=" + userId + ", userGender=" + userGender + "]";
	}

}
