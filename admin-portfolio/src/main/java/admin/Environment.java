package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Environment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Environment() {
     
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			AdminDAO adminDao = new AdminDAO();
			EnvironmentDTO a = adminDao.loadEnvironmentInfo();
//			PaymentConfigDTO paymentConfig = adminDao.loadPaymentInfo();
//			
//			request.setAttribute("environment", environment);
//			request.setAttribute("paymentConfig", paymentConfig);
			
			RequestDispatcher rd = request.getRequestDispatcher("./admin_config.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			e.getMessage();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		
		Enumeration<String> em = request.getParameterNames();
		List<String> configList = new ArrayList<>();
		List<String> paymentList = new ArrayList<>();
		
		String[] config = {"title","email","point","defaultPoint","level","company","rgNumber","director",
							"directorNumber","reportNumber","valueNumber","postalcode","companyAddr"
							,"infoManager","infoEmail"};
		String[] payment = {"bank","bankAccount","credit","mobile","voucher","minPoint","maxPoint","receipt",
				"shippingName", "shipping_cost", "deliveryDate"};

		while(em.hasMoreElements()) {
			String temp = em.nextElement();
			String value = request.getParameter(temp);
			for(int i = 0; i < config.length; i++) {
				if(temp.equals(config[i])) {
					configList.add(value);
				}
			}
			for(int j = 0; j < payment.length; j++) {
				if(temp.equals(payment[j])) {
					paymentList.add(value);
				}
			}
		}
		try {
			AdminDAO adminDao = new AdminDAO();
			int set1 = adminDao.insertConfig(configList);
			int set2 = adminDao.insertPaymentConfig(paymentList);
			
			if(set1 > 0 && set2 > 0) {
				pr.print("<script>alert('입력이 완료되었습니다.'); location.href='admin_config.jsp';</script>");
			}
		}catch (Exception e) {
			e.printStackTrace();
			pr.print("<script>alert('데이터 통신 오류, 서버 관리자에게 문의바랍니다.'); location.href='admin_config.jsp';</script>");
		}
	}
}
