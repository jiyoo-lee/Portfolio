package admin.category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	
	Connection connection;
	PreparedStatement ps = null;
	
	public CategoryDAO() throws ClassNotFoundException, SQLException {	
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://umj7-009.cafe24.com/jeeyulee";
		String user ="jeeyulee";
		String password = "jeeyu9400";
		
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url, user, password);
	}
	
	public List<CategoryDTO> selectAll() throws SQLException {
		List<CategoryDTO> categories = new ArrayList<>();
		
		String sql = "select id, concat(1depth_code, 2depth_code) as code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category "
				   + "from category";
		
		ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			CategoryDTO category = new CategoryDTO();
			category.setId(rs.getLong("id"));
			category.setCode(rs.getString("code"));
			category.setDepthCode1(rs.getString("1depth_code"));
			category.setDepthCode2(rs.getString("2depth_code"));
			category.setDepthName1(rs.getString("1depth_name"));
			category.setDepthName2(rs.getString("2depth_name"));
			category.setUsage(rs.getString("usage_category"));
			
			categories.add(category);
		}
		
		return categories;
	}
	
	public List<CategoryDTO> selectByName(String name) throws SQLException {
		List<CategoryDTO> categories = new ArrayList<>();
		
		String sql = "select id, concat(1depth_code, 2depth_code) as code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category "
				   + "from category "
				   + "where 1depth_name like '%?%' "
				   + "or 2depth_name like '%?%'";
		
		ps = connection.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, name);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			CategoryDTO category = new CategoryDTO();
			category.setId(rs.getLong("id"));
			category.setCode(rs.getString("code"));
			category.setDepthCode1(rs.getString("1depth_code"));
			category.setDepthCode2(rs.getString("2depth_code"));
			category.setDepthName1(rs.getString("1depth_name"));
			category.setDepthName2(rs.getString("2depth_name"));
			category.setUsage(rs.getString("usage_category"));
			
			categories.add(category);
		}
		
		return categories;
	}
	
	public List<CategoryDTO> selectByCode(String code) throws SQLException {
		List<CategoryDTO> categories = new ArrayList<>();
		
		String sql = "select id, concat(1depth_code, 2depth_code) as code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category "
				   + "from category "
				   + "where 1depth_code like '%?%' "
				   + "or 2depth_code like '%?%'";
		
		ps = connection.prepareStatement(sql);
		ps.setString(1, code);
		ps.setString(2, code);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			CategoryDTO category = new CategoryDTO();
			category.setId(rs.getLong("id"));
			category.setCode(rs.getString("code"));
			category.setDepthCode1(rs.getString("1depth_code"));
			category.setDepthCode2(rs.getString("2depth_code"));
			category.setDepthName1(rs.getString("1depth_name"));
			category.setDepthName2(rs.getString("2depth_name"));
			category.setUsage(rs.getString("usage_category"));
			
			categories.add(category);
		}
		
		return categories;
	}
	
	public int delete(Long id) throws SQLException {
		String sql = "delete from category "
				   + "where id = ?";
		ps = connection.prepareStatement(sql);
		ps.setLong(1, id);
		
		return ps.executeUpdate();
	}
	
	public int insert(CategoryCreationDTO category) throws SQLException {
		String sql = "insert into category (1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category) "
				   + "value (?, ?, ?, ?, ?)";
		
		ps = connection.prepareStatement(sql);
		ps.setString(1, category.getDepthCode1());
		ps.setString(2, category.getDepthName1());
		ps.setString(3, category.getDepthCode2());
		ps.setString(4, category.getDepthName2());
		ps.setString(5, category.getUsage());
		
		return ps.executeUpdate();
	}
}
