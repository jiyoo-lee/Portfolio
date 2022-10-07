package admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.util.AdminDAO;


public class NoticeViewWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeViewWebServlet() {
    
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String id = req.getParameter("page");
			AdminDAO adminDAO = new AdminDAO();
			List<NoticeDTO> notice = adminDAO.selectNoticeDetail(id);
			req.setAttribute("notice", notice);
			RequestDispatcher rd = req.getRequestDispatcher("./admin_notice_view.jsp");
			rd.forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String idx = request.getParameter("page");
			AdminDAO adminDAO = new AdminDAO();
			
		}catch (Exception e) {
		
		}
	}
}
