package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.UserDao;

@WebServlet("/login")
public class loginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		UserDao ud = new UserDao();
		String UserID = req.getParameter("UserID");
		System.out.println(UserID);
		String UserPassword = req.getParameter("UserPassword");
		System.out.println(UserPassword);
		int result = ud.login(UserID, UserPassword);
		System.out.println(result);
		if(result==1) {
			HttpSession session = req.getSession(true);
			session.setAttribute("User", result);
			session.setAttribute("id", UserID);
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('로그인 성공.'); location.href='main';</script>");
			 
			out.flush();
			
		} else if(result == 0) {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('비밀번호가 틀립니다.'); history.back(); </script>");
			 
			out.flush();
		} else if(result == -1) {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('존재하지 않는 아이디 입니다.'); history.back();</script>");
			 
			out.flush();
		} else {
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('DB오류 입니다.'); history.back();</script>");
			 
			out.flush();
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/view/login_join.jsp").forward(req, resp);
	}
	
}
