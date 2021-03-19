package beans;

import java.util.Date;

public class BoardComment {
	private int id;
	private int mid;
	private String comment;
	private String writerID;
	private Date regdate;
	
	public BoardComment() {
		
	}
	
	public BoardComment(int id, int mid, String comment, String writerID, Date regdate) {
		this.id = id;
		this.mid = mid;
		this.comment = comment;
		this.writerID = writerID;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWriterID() {
		return writerID;
	}

	public void setWriterID(String writerID) {
		this.writerID = writerID;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
