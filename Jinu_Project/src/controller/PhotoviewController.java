package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BoardComment;
import beans.Imgboard;
import beans.Photocomment;
import service.PhotoContentDAO;

@WebServlet("/view")
public class PhotoviewController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String userID = "jinu"; //session
		String comment = req.getParameter("comment");
		int score = Integer.parseInt(req.getParameter("s"));
		String pid = req.getParameter("pid");
		System.out.println(pid);
		Photocomment pcm = new Photocomment(pid, comment, score, userID);
		int result = PhotoContentDAO.getInstance().insertcomment(pcm);
		
		resp.sendRedirect("view?pid="+pid);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		System.out.println(pid);
		
		Imgboard ibo = PhotoContentDAO.getInstance().getPhotodetail(pid);
		req.setAttribute("ibo", ibo);
		int comCount = 0;
		comCount = PhotoContentDAO.getInstance().getComCount(pid);
		req.setAttribute("comCount", comCount);
		if (comCount != 0) {// 댓글이 있을때만 보냄
			List<Photocomment> clist = PhotoContentDAO.getInstance().getCommentList(pid);
			req.setAttribute("clist", clist);
			for(Photocomment p : clist) {
				System.out.println(p.getComment());
			}
		}


		req.getRequestDispatcher("/WEB-INF/view/imgboarddetail.jsp").forward(req, resp);
	}
}
