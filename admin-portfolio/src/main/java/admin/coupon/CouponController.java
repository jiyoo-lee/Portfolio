package admin.coupon;

import java.awt.geom.IllegalPathStateException;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.core.compiler.InvalidInputException;


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
		
		// file upload
		String filePath = "/jeeyulee/image/coupon/";
		String fileName = request.getParameter("couponName") + request.getParameter("couponType");
		Part couponImage = request.getPart("couponImage");
		
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("mac")) {
			filePath = "/Users/jiyoo/Desktop" + filePath;
		}
		
		File file = new File(filePath + fileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		couponImage.write(filePath + fileName);			
		
	
		// dto 생성, 세팅
		CouponDTO couponDTO = new CouponDTO();
		couponDTO.setName(request.getParameter("couponName"));
		couponDTO.setType(request.getParameter("couponType"));
		couponDTO.setUsageStart(request.getParameter("usageStart"));
		couponDTO.setUsageEnd(request.getParameter("usageEnd"));
		couponDTO.setDiscountType(request.getParameter("discountType"));
		couponDTO.setPriceOrRate(request.getParameter("discount"));
		couponDTO.setMinPrice(request.getParameter("minPrice"));
		couponDTO.setImagePath(filePath + fileName);
			
		try {
			CouponDAO couponDAO = new CouponDAO();
			int insertCnt = couponDAO.insertCouponInfo(couponDTO);
			
			if(insertCnt > 0) {
				response.getWriter().print("<script>alert('쿠폰 등록이 완료되었습니다.');</script>");
			}
			else {
				throw new InvalidInputException();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("<script>alert('데이터 통신 오류로 쿠폰등록이 되지못했습니다. 관리자에게 문의바랍니다.'); history.go(-1);</script>");
		}
	}
}
