package beans;

public class User {
	String UserID;
	String UserPassword;
	String UserName;
	String UserEmail;
	String UserTel;
	String UserGender;
	
	public User() {
		
	}

	public User(String userID, String userPassword, String userName, String userEmail, String userTel,
			String userGender) {
		UserID = userID;
		UserPassword = userPassword;
		UserName = userName;
		UserEmail = userEmail;
		UserTel = userTel;
		UserGender = userGender;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserTel() {
		return UserTel;
	}

	public void setUserTel(String userTel) {
		UserTel = userTel;
	}

	public String getUserGender() {
		return UserGender;
	}

	public void setUserGender(String userGender) {
		UserGender = userGender;
	}
	
	
	
	
}
