package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.User;

public class UserDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDao() {
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
	
	public int login(String UserID, String UserPassword) {
		String sql = "SELECT UserPassword from user where UserID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, UserID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(UserPassword)) {
					return 1;//로그인 성공
				}else {
					return 0;//비밀번호 오류
				}
			}
			
			return -1;//아이디가 없음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public void join(User user) {
		String sql = "INSERT INTO user (UserID,UserPassword,UserName,UserEmail,Usertel,Usergender) VALUES(?,?,?,?,?,?);";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserTel());
			pstmt.setString(6, user.getUserGender());
			
			pstmt.executeUpdate();
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int idcheck(String UserID) {
		
		String sql = "SELECT * FROM user WHERE UserID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, UserID);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;// 중복아이디 있음 
			}

			return 0;//중복 아이디 없음
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -2;//DB오류
	}


}
