package admin.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.category.CategoryMangementDTO;

public class ProductDAO {
	
	Connection connection;
	PreparedStatement ps = null;
	
	public ProductDAO() throws ClassNotFoundException, SQLException{
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://umj7-009.cafe24.com/jeeyulee";
		String user ="jeeyulee";
		String password = "jeeyu9400";
		
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url,user,password);
	}

	public int countProductCode(String productCode) throws SQLException {
		String sql = "select count(*) as count "
				   + "from product "
				   + "where code = ?";
		this.ps = connection.prepareStatement(sql);
		this.ps.setString(1, productCode);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt("count");
		}
		else {
			throw new SQLException();
		}
	}

	public String selectMaxProductCode(String categoryCode) throws SQLException {
		String sql = "select max(code)+1 as productCode "
				   + "from product "
				   + "where category_code = ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, categoryCode);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getString("productCode");
		}
		else {
			throw new SQLException();
		}
	}
}

