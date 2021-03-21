package beans;

import java.util.Date;

public class Webboard {
	int id;
	int mid;
	String flag;
	String UserID;
	String comment;
	Date regdate;
	
	public Webboard() {
		
	}
	
		
	public Webboard(int id, int mid, String flag, String userID, String comment, Date regdate) {
		this.id = id;
		this.mid = mid;
		this.flag = flag;
		this.UserID = userID;
		this.comment = comment;
		this.regdate = regdate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		this.UserID = userID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
