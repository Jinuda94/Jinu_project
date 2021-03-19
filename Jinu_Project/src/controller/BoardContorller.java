package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.x.Notice;

import beans.Board;
import service.BoardDao;

@WebServlet("/board")
public class BoardContorller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      BoardDao bd = new BoardDao();
	      
	      //파라미터 받기
	      String page_ = req.getParameter("p");
	      String field_ = req.getParameter("f");
	      String query_ = req.getParameter("q");
	      String id_ = req.getParameter("id");
	
	      //매개변수 초기화
	      int page = 1;
	      String field = "title";
	      String query = "";
	      int id = -1;
	      
	      if(page_ != null && !page_.equals("")) {
	    	  page = Integer.parseInt(page_);
	      }
	      
	      if(field_ != null && !field_.equals("")) {
	    	  field = field_;
	      }
	      
	      if(query_ != null && !query_.equals("")) {
	    	  query = query_;
	      }
	      
	      if(id_ != null && !id_.equals("")) {
		    	 id = Integer.parseInt(id_);
		    	 bd.Boarddelite(id);
	      }
	      
	      
	      
	      System.out.println("page :"+page);
	      System.out.println("field : "+ field);
	      System.out.println("query : "+ query);
	            
	      List<Board> list = bd.getPubBoardlist(page,field,query);

//	      for(Board b: list) {
//	    	  System.out.println(b.getTitle());
//	      }

	  
	      int count = 0;
	      
	      count = bd.getBoardCount(field, query);
	      System.out.println("count: "+count);
	      
	      req.setAttribute("list", list); //2
	      req.setAttribute("count", count);
	      req.getRequestDispatcher("/WEB-INF/view/Board.jsp").forward(req, resp); //3
	}
	
}
