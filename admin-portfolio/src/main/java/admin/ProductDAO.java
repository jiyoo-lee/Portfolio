package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public int insertCategoryInfo(List<String> categoryList) throws SQLException {
		
		String sql = "insert into product_category(category_code,big_category,small_category) values(?,?,?,?,?,?,?)";
		this.ps = connection.prepareStatement(sql);
		for(int i = 0; i < categoryList.size(); i++) {
			this.ps.setString(i+1, categoryList.get(i));			
		}
		return this.ps.executeUpdate();
	}
	
	public List<CategoryMangementDTO> selectCategoryList () throws SQLException{
		List<CategoryMangementDTO> list = new ArrayList<CategoryMangementDTO>();
		
		String sql = "select * from product_category";
		
		return list;
	}
}

