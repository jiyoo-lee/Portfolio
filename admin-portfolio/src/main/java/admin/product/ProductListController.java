package admin.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductListController() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		try {
			ProductDAO productDAO = new ProductDAO();
			String searchkey = request.getParameter("searchkey");
			String productKeyword = request.getParameter("keyword");
			
			List<ProductDTO> products;
			
			if("1".equals(searchkey)) {
				products = productDAO.selectByName(productKeyword);
				pw.print("success");
			}
			else if ("2".equals(searchkey)) {
				products = productDAO.selectByCode(productKeyword);
				pw.print("sueccess");
			}
			else {
				products = productDAO.selectAllProductsInfo();				
			}
			request.setAttribute("products", products);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		RequestDispatcher rd = request.getRequestDispatcher("./admin_product.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
