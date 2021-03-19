package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Imgboard;
import beans.Photocomment;

public class PhotoContentDAO {
	//instance 생성(싱글톤 패턴) 메모리 효율 좋아짐.
	private static PhotoContentDAO istance = new PhotoContentDAO();
	public static PhotoContentDAO getInstance() {
		return istance;
	}
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public PhotoContentDAO() {
		try {
//			String url = "jdbc:mysql://3.34.233.108:3306/jinuproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//			String root = "jinu";
//			String pw = "a123";
			String url = "jdbc:mysql://localhost:3306/jinuproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String root = "root";
			String pw = "a123";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, root, pw);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Imgboard> getPhotoList(){//int page, String field, String query, int option
		List<Imgboard> list = new ArrayList<Imgboard>();
		String sql = "select * from pcontent";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				String content = rs.getString("content");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Date regdate = rs.getDate("regdate");
				String delFlag = rs.getString("delFlag");
				String path = rs.getString("path");
				
				Imgboard ib = new Imgboard(pid, pname, content, category, price, regdate, delFlag, path);
				list.add(ib);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Imgboard getPhotodetail(String pid){//int page, String field, String query, int option
		Imgboard ib = null;
		String sql = "select * from pcontent where pid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String pid_ = rs.getString("pid");
				String pname = rs.getString("pname");
				String content = rs.getString("content");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				Date regdate = rs.getDate("regdate");
				String delFlag = rs.getString("delFlag");
				String path = rs.getString("path");
				
				ib = new Imgboard(pid_, pname, content, category, price, regdate, delFlag, path);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ib;
	}

	public List<Photocomment> getCommentList(String pid) {
		List<Photocomment> list = new ArrayList<Photocomment>();
		String sql = "select * from p_comment where pid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int wid = rs.getInt("wid");
				String pid_ = rs.getString("pid");
				String comment = rs.getString("comment");
				int score = rs.getInt("score");
				Date regdate = rs.getDate("regdate");
				String userid = rs.getString("userid");
				String delFlag = rs.getString("delFlag");

				
				Photocomment pcm = new Photocomment(wid, pid_, comment, score, regdate, userid, delFlag);
				list.add(pcm);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public int getComCount(String pid) {
		int count = 0;
		String sql = "select count(wid) as count from p_comment where pid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return count;
	}

	public int insertcomment(Photocomment pcm) {
		int result = 0;
		String sql = " insert into p_comment (pid,comment,score,userid) " + " values(? , ? , ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pcm.getPid());
			pstmt.setString(2, pcm.getComment());
			pstmt.setInt(3, pcm.getScore());
			pstmt.setString(4, pcm.getUserid());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
		
	}
}
