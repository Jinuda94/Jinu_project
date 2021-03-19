package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Naver;
import service.NaverDao;

@WebServlet("/naver")
public class NaverController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NaverDao nd = new NaverDao();
		List<Naver> n_list = nd.naver_list();//전체
		
		List<Naver> m_list = new ArrayList<Naver>();//월
		List<Naver> tu_list = new ArrayList<Naver>();//화
		List<Naver> w_list = new ArrayList<Naver>();//수
		List<Naver> th_list = new ArrayList<Naver>();//목
		List<Naver> f_list = new ArrayList<Naver>();//금
		List<Naver> sa_list = new ArrayList<Naver>();//토
		List<Naver> su_list = new ArrayList<Naver>();//일
		for(Naver n : n_list) {
			String img = n.getImg();
			Naver na = new Naver(n.getTitle(),n.getHref(),n.getImg());
			if(img.contains("mon")) {
				m_list.add(na);
			}else if(img.contains("tue")) {
				tu_list.add(na);
			}else if(img.contains("wed")) {
				w_list.add(na);
			}else if(img.contains("thu")) {
				th_list.add(na);
			}else if(img.contains("fri")) {
				f_list.add(na);
			}else if(img.contains("sat")) {
				sa_list.add(na);
			}else if(img.contains("sun")) {
				su_list.add(na);
			}
		}
		req.setAttribute("m_list", m_list);
		req.setAttribute("tu_list", tu_list);
		req.setAttribute("w_list", w_list);
		req.setAttribute("th_list", th_list);
		req.setAttribute("f_list", f_list);
		req.setAttribute("sa_list", sa_list);
		req.setAttribute("su_list", su_list);

		req.getRequestDispatcher("/WEB-INF/view/naver.jsp").forward(req, resp);
	}
	
}
