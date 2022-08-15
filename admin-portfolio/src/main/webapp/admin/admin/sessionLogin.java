package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class sessionLogin extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.printf("SessionLogin: /sessionlogin: (%s)\n", req.getMethod());
		super.service(req, resp);
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession sessLogin = req.getSession();
		sessLogin.setMaxInactiveInterval(60);
		
		String userid = req.getParameter("adminId");
		String userpw = req.getParameter("adminPassword");
		System.out.printf("[SessionLogin], userid: %s, password: %s\n", userid, userpw);
		
	}
	private static final long serialVersionUID = 1L;
       
 
    public sessionLogin() {
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
