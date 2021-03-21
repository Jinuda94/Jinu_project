package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Naver;
import beans.Webboard;

public class WebboardDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public WebboardDao() {
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
	
	public List<Webboard> web_list(int mid, String flag) {
		String sql = "SELECT * FROM webboard where mid=? and flag=?";
		List<Webboard> w_list = new ArrayList<Webboard>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mid);
			pstmt.setString(2, flag);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int mid_ = rs.getInt("mid");
				String flag_ = rs.getString("flag");
				String UserID = rs.getString("UserID");
				String comment = rs.getString("comment");
				Date regdate = rs.getDate("regdate");
				
				Webboard wb = new Webboard(id,mid_,flag_,UserID,comment,regdate);
				w_list.add(wb);
			}
			

		}catch(Exception e) {
			e.printStackTrace();
		}
		return w_list;
	}
}
