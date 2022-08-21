package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticeDeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pr = resp.getWriter();
		
		String[] index = req.getParameter("datas").split(",");
		try {
			AdminDAO adminDAO = new AdminDAO();
			int id = adminDAO.deleteNotices(index);
			
			if(id > 0) {
				pr.print("<script>alert('삭제 완료되었습니다.'); location.href = './notice';</script>");
			}
			else {
				throw new SQLException();
			}
		}catch (Exception e) {
			pr.print("<script>alert('삭제 완료되었습니다.');</script>");
		}
	}
}
