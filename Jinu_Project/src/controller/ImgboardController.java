package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Imgboard;
import service.PhotoContentDAO;

@WebServlet("/imgboard")
public class ImgboardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Imgboard> imglist = PhotoContentDAO.getInstance().getPhotoList();
		req.setAttribute("plist", imglist);
		
		req.getRequestDispatcher("/WEB-INF/view/imgboard.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/WEB-INF/view/imgboard.jsp").forward(req, resp);
//	}
}
