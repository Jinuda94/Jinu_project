package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import service.UserDao;

@WebServlet("/join")
public class JoinController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String UserID = req.getParameter("UserID");
		String UserPassword = req.getParameter("UserPassword");
		String UserName = req.getParameter("UserName");
		String UserEmail = req.getParameter("UserEmail");
		String UserTel = req.getParameter("UserTel");
		String UserGender = req.getParameter("UserGender");
		
		System.out.println(UserName);
		User user = new User(UserID, UserPassword, UserName, UserEmail, UserTel,
				UserGender); 
		UserDao ud = new UserDao();
		ud.join(user);
	
		resp.sendRedirect("login");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jf = "1";
		req.setAttribute("jf", jf);
		req.getRequestDispatcher("/WEB-INF/view/login_join.jsp").forward(req, resp);;
	}
}
