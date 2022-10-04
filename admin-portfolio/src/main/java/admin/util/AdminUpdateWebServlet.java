package admin.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminUpdateWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminUpdateWebServlet() {

    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.selectAdminInfo();
			RequestDispatcher rd = req.getRequestDispatcher("./admin_info.jsp");
			rd.forward(req, resp);	
		}catch (Exception e) {
		
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
