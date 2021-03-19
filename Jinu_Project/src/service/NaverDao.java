package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Naver;

public class NaverDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public NaverDao() {
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
	
	public List<Naver> naver_list() {
		String sql = "SELECT * FROM naver";
		List<Naver> n_list = new ArrayList<Naver>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String href = rs.getString("href");
				String img = rs.getString("img");
				
				Naver na = new Naver(title,href,img);
				n_list.add(na);
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		return n_list;
	}

}
