package beans;

public class Naver {
	int id;
	String title;
	String href;
	String img;
	
	public Naver() {

	}
	
	public Naver(int id, String title, String href, String img) {
		this.id = id;
		this.title = title;
		this.href = href;
		this.img = img;
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
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
