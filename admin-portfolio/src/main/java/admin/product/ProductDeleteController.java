package admin.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductDeleteController() {
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		String[] codes = request.getParameter("datas").split(",");
		try {
			ProductDAO productDAO = new ProductDAO();
			int result = productDAO.deleteProducts(codes);
			if(result > 0) {
				pr.print("<script>alert('삭제 완료되었습니다.'); location.href = '../product-list';</script>");
			}
			else {
				throw new Exception();
			}
		}catch (Exception e) {
			pr.print("<script>alert('데이터 통신 오류'); history.go(-1);</script>");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
