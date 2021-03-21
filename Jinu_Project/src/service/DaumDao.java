package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Daum;
import beans.Naver;

public class DaumDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DaumDao() {
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
	
	public List<Daum> daum_list(String day) {
		String sql = "SELECT * FROM daum where day = ?";
		List<Daum> d_list = new ArrayList<Daum>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, day);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String nickname = rs.getString("nickname");
				String imgurl = rs.getString("imgurl");
				
				Daum da = new Daum(id,title,nickname,imgurl);
				d_list.add(da);
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		return d_list;
	}

}
