package admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.category.Category1DepthCodeDTO;
import admin.category.CategoryDAO;


public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProductController() {
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			CategoryDAO categorydao = new CategoryDAO();
			List<Category1DepthCodeDTO> depthList = categorydao.selectDepth1Code();
			request.setAttribute("depthList", depthList);
			RequestDispatcher rd = request.getRequestDispatcher("./admin_product_write.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
