package admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String categoryCode = request.getParameter("categoryCode");
			
			ProductDAO productDao = new ProductDAO();
			String recommandCode = productDao.selectMaxProductCode(categoryCode);
			
			if (recommandCode == null) {
				recommandCode = categoryCode + "000001";
			}
			response.getWriter().print(recommandCode);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}