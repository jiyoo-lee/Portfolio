package admin.notice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.util.AdminDAO;

public class NoticeDeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter pr = resp.getWriter();
		
		String[] index = req.getParameterValues("datas");
	
		if(index != null  && index.length > 0) {
			try {
				AdminDAO adminDAO = new AdminDAO();
				int id = adminDAO.deleteNotices(index);
				
				if(id > 0) {
					pr.print("1");
				}
				else {
					throw new SQLException();
				}
			}catch (Exception e) {
				pr.print("2");
			}
		}
	}
}
