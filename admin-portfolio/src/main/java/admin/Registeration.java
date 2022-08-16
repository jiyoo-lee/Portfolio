package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registeration extends HttpServlet {
	boolean isoverlap = true;
	
	private static final long serialVersionUID = 1L;
       

    public Registeration() {
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("overlap");
		
		try {
			AdminDAO rd = new AdminDAO();
			this.isoverlap = rd.selectOnlyId(id);
			PrintWriter pr = response.getWriter();
			
			if(this.isoverlap == true) {
				pr.print("<script>alert('중복된 아이디입니다.'); history.go(-1);</script>");
			}
			else {
				pr.print("<script>alert('사용가능한 아이디입니다.'); history.go(-1);</script>");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		if(this.isoverlap == true) {
			pr.print("<script>alert('아이디 중복 확인이 필요합니다.'); history.go(-1);</script>");
		}
		else {
			ArrayList<String> adminList = new ArrayList<>();
			String telNumber = request.getParameter("admintel1") + request.getParameter("admintel2") + request.getParameter("admintel3");
			
			adminList.add(request.getParameter("adminId"));
			adminList.add(request.getParameter("adminPassword"));
			adminList.add(request.getParameter("adminName"));
			adminList.add(request.getParameter("adminEmail"));
			adminList.add(telNumber);
			adminList.add(request.getParameter("department"));
			adminList.add(request.getParameter("position"));
			
			try {
				AdminDAO rd = new AdminDAO();
				int insert = rd.insert(adminList);
				
				if(insert > 0) {
					pr.print("<script>alert('관리자 등록이 완료되었습니다. 담당자 승인 후 사용가능합니다.'); location.href = './index.html';</script>");
				}
				else {
					throw new Exception("error-!");
				}
			}catch (Exception e) {
				pr.print("<script>alert('데이터 통신오류로 등록이 취소되었습니다. 담당자에게 문의바랍니다.')</script>");
			}
		}
	}
}
