package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import beans.Board;
import service.BoardDao;

@MultipartConfig(
//		location="/upload", //어디에 저장될 건지
		fileSizeThreshold = 1024*1024, 
		maxFileSize = 1024*1024*5, //최대 업로드 가능용량 
		maxRequestSize = 1024*1024*5*5) //전체요처에 대한 파일 용량
@WebServlet("/write")
public class WriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	req.getRequestDispatcher("/WEB-INF/view/Write.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		Board bo = new Board();
		String title = req.getParameter("title");		
		String content = req.getParameter("content");
		String file_flag = req.getParameter("file_flag");
		System.out.println("file_flag "+file_flag);
		if(file_flag.equals("1")==true) {
		Collection<Part> parts = req.getParts();
		StringBuilder builder = new StringBuilder();
		String filePath ="";
		for(Part p : parts) {
			if(!p.getName().equals("file")) continue;
			if(p.getSize()==0) continue;
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			
			System.out.println("filename : "+fileName);
	
			builder.append(fileName);
			builder.append(",");
		
			InputStream fis = filePart.getInputStream();
			String realPath = req.getServletContext().getRealPath("/photo");
			System.out.println("realpath : "+realPath);
		
			filePath = realPath + File.separator + fileName;
			System.out.println("filepath : " + filePath);
			
			File fl = new File(realPath);
			if(!fl.exists())//중복된 이름의 파일이 업로드x
				fl.mkdirs();
			
			FileOutputStream fos = new FileOutputStream(filePath);
		
			byte[] buf = new byte[1024];
			int size = 0;
			while((size=fis.read(buf))!=-1)
				fos.write(buf, 0, size);
		
		fos.close();
		fis.close();
		}

		builder.delete(builder.length()-1,builder.length());
		
		
		bo.setFiles(builder.toString());
		}else {
			bo.setFiles(null);
		}
		int result = 0;
		
		
		HttpSession session = req.getSession();
		
		bo.setTitle(title);
		bo.setContent(content);
		bo.setWriterID(session.getAttribute("id").toString());
		
		BoardDao bd = new BoardDao();
		result = bd.insertBoard(bo);
	
		
		resp.sendRedirect("board");
		
	

	}
}
