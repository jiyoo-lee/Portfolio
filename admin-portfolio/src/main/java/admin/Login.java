package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import admin.exception.NoPermissionAdminException;
import admin.exception.UserNotFoundException;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("adminId");
		String password = request.getParameter("adminPassword");		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		try {
			AdminDAO rd = new AdminDAO();
			String name = rd.selectNameByIdAndPW(id,password);
			
			// 20분짜리 세션생성
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20*60);
			
			if (session.isNew() || session.getAttribute("name") == null) {
					session.setAttribute("name", name);
					int log = rd.loginHistory(id);
					pr.print("<script>alert('로그인 되었습니다.'); location.href='./admin_main.jsp';</script>");
			} else {
				pr.print("<script>alert('이미 로그인하셨습니다.'); location.href='./admin_main.jsp';</script>");
			}
		}catch (NoPermissionAdminException e) {
			pr.print("<script>alert('권한 승인 후 로그인이 가능합니다. 서버 관리자에게 문의하세요.'); history.go(-1);</script>");
		}
		catch(UserNotFoundException e) {
			pr.print("<script>alert('아이디 혹은 패스워드를 다시 확인해주세요'); history.go(-1);</script>");
		} catch(SQLException | ClassNotFoundException e) {
			pr.print("<script>alert('데이터 통신 오류, 서버 관리자에게 문의하세요'); history.go(-1);</script>");
		}
	}
}