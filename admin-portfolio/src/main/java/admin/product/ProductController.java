package admin.product;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.category.Category1DepthCodeDTO;
import admin.category.CategoryDAO;

@MultipartConfig(maxFileSize = 2 * 1024 * 1024, maxRequestSize = 50 * 1024 * 1024)
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final static String FILE_PATH = "product_images\\";
	
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
		String productCode = "";
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
			System.out.println(key + " " + value);
			
			if (key.equals("productCode")) {
				productCode = value;
			}
		}

		int fileIndex = 1;
		Collection<Part> images = request.getParts();
		for (Part image : images) {
			if (image.getSize() != 0L && image.getName().startsWith("image")) {
				String fileName = productCode + "_" + String.valueOf(fileIndex) +".jpg";
				String realPath = request.getServletContext().getRealPath("");
				System.out.println(realPath);
				System.out.println(image.getName());
				System.out.println(image.getSize());
				System.out.println(FILE_PATH + fileName);
				
				File file = new File(FILE_PATH + fileName);
				image.write(FILE_PATH + fileName);
				fileIndex++;
			}
		}
		
	}

}
