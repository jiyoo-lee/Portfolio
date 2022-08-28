package admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.exception.InvaildCategoryCodeException;

public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		try {
			CategoryDAO categoryDAO = new CategoryDAO();
			String search = request.getParameter("search");
			String keyword = request.getParameter("keyword");
			
			List<CategoryDTO> categories;
			if ("1".equals(search)) {
				categories = categoryDAO.selectByName(keyword);
			}
			else if ("2".equals(search)) {
				categories = categoryDAO.selectByCode(keyword);
			}
			else {
				categories = categoryDAO.selectAll();
			}
			
			request.setAttribute("categories", categories);
			
			RequestDispatcher rd = request.getRequestDispatcher("./admin_category.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter pw = response.getWriter();
		try {
			String largeMenuCode = request.getParameter("largeMenuCode");
			String smallMenuCode = request.getParameter("smallMenuCode");

			if (largeMenuCode.length() != 3) {
				throw new InvaildCategoryCodeException("대분류코드는 3글자로 입력해주세요. [예시: 001, 123]");
			} else if (smallMenuCode != null && smallMenuCode.length() != 3) {
				throw new InvaildCategoryCodeException("소분류코드는 3글자 또는 빈 값으로 입력해주세요. [예시: 001, 123, null]");
			}

			CategoryCreationDTO category = new CategoryCreationDTO();
			category.setDepthCode1(largeMenuCode);
			category.setDepthName1(request.getParameter("largeMenu"));
			category.setDepthCode2(smallMenuCode);
			category.setDepthName2(request.getParameter("smallMenu"));
			category.setUsage(request.getParameter("a"));

			CategoryDAO categoryDAO = new CategoryDAO();
			int result = categoryDAO.insert(category);
			if (result > 0) {
				pw.print("<script>alert('카테고리 등록이 완료되었습니다.'); location.href='./category';</script>");
			} else {
				throw new SQLException();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			pw.print("<script>alert('카테고리 등록을 실패했습니다.'); history.go(-1); </script>");
		} catch (InvaildCategoryCodeException e) {
			pw.print("<script>alert('" + e.getMessage() + "'); history.go(-1); </script>");
		}
	}
}
