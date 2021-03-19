package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserDao;

@WebServlet("/IDcheck")
public class ID_checkController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("UserID");	
		UserDao ud = new UserDao();
		int check = ud.idcheck(id);	
		req.setAttribute("check", check);
		req.setAttribute("id", id);
		req.getRequestDispatcher("/WEB-INF/view/IDcheck.jsp").forward(req, resp);
	}
}
