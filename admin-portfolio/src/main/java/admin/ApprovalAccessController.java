package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApprovalAccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApprovalAccessController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		String access = request.getParameter("update");
		String id = request.getParameter("id");
		
		try {
			AdminDAO adminDAO = new AdminDAO();
			int data = adminDAO.updateAccess(access,id);
			
			if(data > 0) {
				pr.print("success");				
			}
			else {
				throw new SQLException();
			}
		}catch (Exception e) {
			pr.print("denial");
			e.printStackTrace();
		}
	}

}
