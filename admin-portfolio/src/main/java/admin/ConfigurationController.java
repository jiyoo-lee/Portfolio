package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.exception.NoConfigurationException;


public class ConfigurationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			AdminDAO adminDao = new AdminDAO();
			HomepageConfigDTO homepageConfig = adminDao.selectHomepageConfig();
			PaymentConfigDTO paymentConfig = adminDao.selectPaymentConfig();
			
			request.setAttribute("homepage", homepageConfig);
			request.setAttribute("payment", paymentConfig);
			
			RequestDispatcher rd = request.getRequestDispatcher("./admin_config.jsp");
			rd.forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoConfigurationException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		try {
			AdminDAO adminDAO = new AdminDAO();
			
			Map<String, String[]> parameterMap = request.getParameterMap();
			
			Map<String, String> homepageParam = new HashMap<>();
			String[] homepageFields = {"title", "managerEmail", "companyName", "companyRegistrationNumber",
					"directorName", "mainNumber", "telemarketingReportNumber", "supplementaryNumber", "businessZipCode",
					"businessAddress", "infoManagerName", "infoManagerEmail", "membershipReserves", "membershipLevel"};
			for (String field : homepageFields) {
				homepageParam.put(field, parameterMap.get(field)[0]);	
			}
			
			int homepageConfigResult = adminDAO.insertHomepageConfig(homepageParam, homepageFields);
			
			Map<String, String> paymentParam = new HashMap<>();
			String[] paymentFields = {"bankName", "accountNumber", "creditUsage", "mobileUsage", "voucherUsage",
					"pointUsage", "minUsagePoint", "maxUsagePoint", "cashReceiptUsage", "shippingCompanyName",
					"shippingCost", "deliveryDateUsage"};
			for (String field : paymentFields) {
				paymentParam.put(field, parameterMap.get(field)[0]);
			}
			
			int paymentConfigResult = adminDAO.insertPaymentConfig(paymentParam, paymentFields);
			
			if(homepageConfigResult > 0 && paymentConfigResult > 0) {
				pr.print("<script>alert('설정이 완료되었습니다.'); location.href='./configuration';</script>");
			}else {
				throw new SQLException();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
