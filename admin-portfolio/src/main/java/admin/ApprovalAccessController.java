package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApprovalAccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApprovalAccessController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String modification = request.getParameter("update");
		String modification2 = request.getParameter("id");
		
		System.out.println(modification2 + "," + modification);
		
		try {
			AdminDAO adminDAO = new AdminDAO();
			int data = adminDAO.updateAccess(modification);
		}catch (Exception e) {
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
