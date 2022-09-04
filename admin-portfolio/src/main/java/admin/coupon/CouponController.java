package admin.coupon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CouponController() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		RequestDispatcher rd = request.getRequestDispatcher("./admin_coupon_config.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		CouponDTO couponDTO = new CouponDTOBuilder()
								.name(request.getParameter("couponName"))
								.type(request.getParameter("couponType"))
								.usageStart(request.getParameter("usageStart"))
								.usageEnd(request.getParameter("usageEnd"))
								.discountType(request.getParameter("discountType"))
								.build();
	}
}
