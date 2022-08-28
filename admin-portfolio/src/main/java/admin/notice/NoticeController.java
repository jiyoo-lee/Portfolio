package admin.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.util.AdminDAO;

public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			AdminDAO adminDAO = new AdminDAO();
			List<NoticeDTO> notices = adminDAO.selectNotices();
			
			req.setAttribute("notices", notices);

			RequestDispatcher rd = req.getRequestDispatcher("./admin_notice.jsp");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pr = resp.getWriter();
		
		List<String> noticeRegistration = new ArrayList<>();
		
		noticeRegistration.add(req.getParameter("noticeTitle"));
		noticeRegistration.add(req.getParameter("writer"));
		noticeRegistration.add(req.getParameter("topExposure"));
		noticeRegistration.add(req.getParameter("attachments"));
		noticeRegistration.add(req.getParameter("content"));
				
		try {
			AdminDAO adminDAO = new AdminDAO();
			int notice = adminDAO.insertNotices(noticeRegistration);
			if(notice > 0) {
				pr.print("<script>alert('공지 등록이 완료되었습니다.'); location.href ='./notice';</script>");
			}
			else {
				throw new SQLException();
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
