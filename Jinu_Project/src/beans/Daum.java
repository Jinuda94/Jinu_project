package beans;

public class Daum {
	int id;
	String title;
	String nickname;
	String imgurl;
	
	public Daum() {
		
	}
	
	public Daum(int id, String title, String nickname, String imgurl) {
		this.id = id;
		this.title = title;
		this.nickname = nickname;
		this.imgurl = imgurl;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
	
	
	
	

}
