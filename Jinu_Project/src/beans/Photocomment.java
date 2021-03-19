package beans;

import java.util.Date;

public class Photocomment {
	private int wid;
	private String pid;
	private String comment;
	private int score;
	private Date regdate;
	private String userid;
	private String delFlag;
	
	public Photocomment() {
		
	}
	
	public Photocomment(int wid, String pid, String comment, int score, Date regdate,
			String userid, String delFlag) {
		this.wid = wid;
		this.pid = pid;
		this.comment = comment;
		this.score = score;
		this.regdate = regdate;
		this.userid = userid;
		this.delFlag = delFlag;
	}
	
	

	public Photocomment(String pid, String comment, int score, String userid) {
		this.pid = pid;
		this.comment = comment;
		this.score = score;
		this.userid = userid;
	}



	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	
	
}   
