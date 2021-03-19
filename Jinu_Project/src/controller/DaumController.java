package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Daum;
import service.DaumDao;

@WebServlet("/daum")
public class DaumController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaumDao nd = new DaumDao();
		
		List<Daum> m_list = nd.daum_list("mon");//월
		List<Daum> tu_list = nd.daum_list("tue");//화
		List<Daum> w_list = nd.daum_list("wed");//수
		List<Daum> th_list = nd.daum_list("thu");//목
		List<Daum> f_list = nd.daum_list("fri");//금
		List<Daum> sa_list = nd.daum_list("sat");//토
		List<Daum> su_list = nd.daum_list("sun");//일
		
		req.setAttribute("m_list", m_list);
		req.setAttribute("tu_list", tu_list);
		req.setAttribute("w_list", w_list);
		req.setAttribute("th_list", th_list);
		req.setAttribute("f_list", f_list);
		req.setAttribute("sa_list", sa_list);
		req.setAttribute("su_list", su_list);

		req.getRequestDispatcher("/WEB-INF/view/daum.jsp").forward(req, resp);
	}
	
}
