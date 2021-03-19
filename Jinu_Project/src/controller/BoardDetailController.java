package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.x.Notice;

import beans.Board;
import beans.BoardComment;
import service.BoardDao;

@WebServlet("/detail")
public class BoardDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 파라미터 받기
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);

		BoardDao bd = new BoardDao();
		// 쿠키를 이용한 새로고침 hit 수 증가 마
		Cookie[] cookies = req.getCookies();
		Cookie viewCookie = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookie" + id)) {
					viewCookie = cookies[i];
				}
			}
		}

		if (viewCookie == null) {
			Cookie newCookie = new Cookie("cookie" + id, "|" + id + "|");
			res.addCookie(newCookie);
			bd.hit(id);
		}

		
		Board bo = bd.getBoardDetail(id);

		int comCount = 0;
		comCount = bd.getComCount(id);
		System.out.println("c_count:" + comCount);
		if (comCount != 0) {// 댓글이 있을때만 보냄
			List<BoardComment> bc = bd.getComment(id);
			req.setAttribute("bc", bc);
		}

		req.setAttribute("count", comCount);
		req.setAttribute("bo", bo);
		req.setAttribute("id", id);
		req.getRequestDispatcher("/WEB-INF/view/BoardDetail.jsp").forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		int pageid = Integer.parseInt(req.getParameter("pageID"));
		HttpSession session = req.getSession();
		String writerID = session.getAttribute("id").toString();
		String comment = req.getParameter("comment");

		BoardDao bd = new BoardDao();
		BoardComment bc = new BoardComment();
		int result = 0;

		bc.setMid(pageid);
		bc.setComment(comment);
		bc.setWriterID(writerID);

		result = bd.insertBoardComment(bc);

		resp.sendRedirect("detail?id=" + pageid);
	}
}