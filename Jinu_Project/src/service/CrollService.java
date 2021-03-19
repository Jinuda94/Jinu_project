package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CrollService {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CrollService() {
		try {
			String url = "jdbc:mysql://3.34.233.108:3306/jinuproject";
			String root = "jinu";
			String pw = "a123";
//			String url = "jdbc:mysql://localhost:3306/jinuproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//			String root = "root";
//			String pw = "a123";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, root, pw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void naver(ArrayList<String> title_list,ArrayList<String> href_list,ArrayList<String> img_list) {
		String sql = "insert into naver (title,href,img) values(?,?,?)";
		System.out.println(title_list.size());
		try {
			pstmt = con.prepareStatement(sql);
			
			for(int i=0; i<title_list.size(); i++) {
			pstmt.setString(1, title_list.get(i));
			pstmt.setString(2, href_list.get(i));
			pstmt.setString(3, img_list.get(i));
			pstmt.addBatch();	
			}
			pstmt.executeBatch();
			pstmt.close();
			System.out.println("데이터 입력 완료");
						
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void daum(ArrayList<String> title_list,ArrayList<String> nickname_list,ArrayList<String> imgurl_list,ArrayList<String> day_list) {
		String sql = "insert into daum (title,nickname,imgurl,day) values(?,?,?,?)";
		System.out.println(title_list.size());
		try {
			pstmt = con.prepareStatement(sql);
			
			for(int i=0; i<title_list.size(); i++) {
			pstmt.setString(1, title_list.get(i));
			pstmt.setString(2, nickname_list.get(i));
			pstmt.setString(3, imgurl_list.get(i));
			pstmt.setString(4, day_list.get(i));
			pstmt.addBatch();	
			}
			pstmt.executeBatch();
			pstmt.close();
			System.out.println("데이터 입력 완료");
						
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
