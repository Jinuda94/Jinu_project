package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Webboard;
import service.WebboardDao;

@WebServlet("webboard")
public class WebboardController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int mid = Integer.parseInt(req.getParameter("id"));
		int mid = 1;
		String href = req.getParameter("href");
		String flag = req.getParameter("flag");
		
		WebboardDao wd = new WebboardDao();
		List<Webboard> w_list = wd.web_list(mid,flag);
		
		req.setAttribute("href", href);
		req.setAttribute("w_list", w_list);
		
		req.getRequestDispatcher("/WEB-INF/view/Webboard.jsp").forward(req, resp);
	}
}
