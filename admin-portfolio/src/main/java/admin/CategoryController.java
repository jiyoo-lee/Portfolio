package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CategoryController() {
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		List<String> categoryList = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		
		String smallMenuCode = request.getParameter("smallMenuCode");
		String smallMenu = request.getParameter("smallMenu");
		
		
		categoryList.add(request.getParameter("categoryCode"));
		categoryList.add(request.getParameter("largeMenuCode"));
		categoryList.add(request.getParameter("largeMenu"));
		categoryList.add(request.getParameter("smallMenuCode"));
		categoryList.add(request.getParameter("smallMenu"));
		categoryList.add(request.getParameter("a"));
		categoryList.add(request.getParameter("onlyLarge"));
		
		System.out.println(categoryList);
//		
//		try {
//			ProductDAO pdDAO = new ProductDAO();
//			int category = pdDAO.insertCategoryInfo(categoryList);
//			
//			if(category > 0) {
//				pw.print("<script>alert('카테고리 등록이 완료되었습니다.');</script>");
//			}
//			else {
//				throw new SQLException();
//			}
//			
//		}catch (Exception e) {
//			pw.print("<script>alert('데이터 통신 오류로 등록되지 못했습니다. 서버관리자에게 문의하세요.');</script>");
//			e.printStackTrace();
//		}
	}
}
