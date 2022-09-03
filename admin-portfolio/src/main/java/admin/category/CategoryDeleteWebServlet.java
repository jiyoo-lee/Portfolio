package admin.category;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CategoryDeleteWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CategoryDeleteWebServlet() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String[] codes = request.getParameter("datas").split(",");
		
		System.out.println(Arrays.toString(codes));
		
		try {
			CategoryDAO categoryDAO = new CategoryDAO();
			int result = categoryDAO.delete(codes);
			
			if(result > 0) {
				response.getWriter().print("<script>alert('삭제 완료되었습니다.'); location.href = '../category'</script>");
			}
			else {
				throw new Exception();
			}
		}
		catch (Exception e) {
			response.getWriter().print("<script>alert('데이터 통신 오류 '); history.go(-1);</script>");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
