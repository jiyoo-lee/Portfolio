package admin.coupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CouponDAO {
	
	Connection connection;
	PreparedStatement ps = null;
	
	public CouponDAO() throws ClassNotFoundException, SQLException {	
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://umj7-009.cafe24.com/jeeyulee";
		String user ="jeeyulee";
		String password = "jeeyu9400";
		
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url, user, password);
	}
	
	
	public int insertCouponInfo(CouponDTO couponDTO) throws SQLException {
		
		String sql = "insert into "
					+ "coupon(name, type, usage_start, usage_end, discount_type, price_or_rate, min_price, image_path) "
					+ "values(?,?,?,?,?,?,?,?)";
	
		this.ps = this.connection.prepareStatement(sql);
		
		this.ps.setString(1, couponDTO.getName());
		this.ps.setString(2, couponDTO.getType());
		this.ps.setString(3, couponDTO.getUsageStart());
		this.ps.setString(4, couponDTO.getUsageEnd());
		this.ps.setString(5, couponDTO.getDiscountType());
		this.ps.setString(6, couponDTO.getPriceOrRate());
		this.ps.setString(7, couponDTO.getMinPrice());
		this.ps.setString(8, couponDTO.getImagePath());
		
		return this.ps.executeUpdate();
	}

}
