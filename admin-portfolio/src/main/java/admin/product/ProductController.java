package admin.product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		
		String productCode = "";
		Enumeration<String> parameterNames = request.getParameterNames();
		ProductDTO productDTO = new ProductDTO();
		while(parameterNames.hasMoreElements()) {
			String key = parameterNames.nextElement();
			String value = request.getParameter(key);
//			System.out.println(key + " " + value);
			
			if (key.equals("productCode")) {
				productCode = value;
			}
			if(key.equals("select2")) {
				productDTO.setCategoryCode(value);				
			}
			else if(key.equals("productCode")) {
				productDTO.setCode(value);
			}
			else if(key.equals("productName")) {
				productDTO.setName(value);
			}
			else if(key.equals("productSubDesc")) {
				productDTO.setSub_desc(value);
			}
			else if(key.equals("price")) {
				productDTO.setPrice(value);
			}
			else if(key.equals("discount")) {
				productDTO.setDiscount(value);
			}
			else if(key.equals("discount_price")) {
				productDTO.setDiscountPrice(value);
			}
			else if(key.equals("stock")) {
				productDTO.setStock(value);
			}
			else if(key.equals("sales")) {
				productDTO.setUsageSale(value);
			}
			else if(key.equals("soldOut")) {
				productDTO.setEarlySoldout(value);
			}
			else if(key.equals("productDetailDesc")) {
				productDTO.setDetailDesc(value);
			}
		}

		int fileIndex = 1;
		Collection<Part> images = request.getParts();
		ProductImageDTO imageDTO = new ProductImageDTO();
		for (Part image : images) {
			if (image.getSize() != 0L && image.getName().startsWith("image")) {
				String fileName = productCode + "_" + String.valueOf(fileIndex) +".jpg";
				String realPath = request.getServletContext().getRealPath("");
//				System.out.println(realPath);
//				System.out.println(image.getName());
//				System.out.println(image.getSize());
//				System.out.println(FILE_PATH + fileName);
				
				File file = new File(FILE_PATH + fileName);
				image.write(FILE_PATH + fileName);
				
				imageDTO.setProductCode(productCode);
				imageDTO.setImagePath(realPath + fileName);
				imageDTO.setImageName(fileName);
				
				fileIndex++;
			}
		}
		try {
			ProductDAO productDAO = new ProductDAO();
			int insert = productDAO.insertProductInfo(productDTO);
			int insertImage =  productDAO.insertImageInfo(imageDTO);
			
			if(insert > 0 && insertImage > 0) {
				response.getWriter().print("<script>alert('상품 등록이 완료되었습니다.'); location.href = './product-list';</script>");
			}
			else {
				throw new SQLException();
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.getWriter().print("<script>alert('데이터 통신 오류 발생, 잠시 후 다시 시도해주세요.'); history.go(-1);</script>");
		}
	}
}
