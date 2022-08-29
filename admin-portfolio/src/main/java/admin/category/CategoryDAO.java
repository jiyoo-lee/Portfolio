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
		
		String sql = "select code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category "
				   + "from category";
		
		ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			CategoryDTO category = new CategoryDTO();
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
		
		String sql = "select code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category "
				   + "from category "
				   + "where 1depth_name like ? "
				   + "or 2depth_name like ? ";
		
		ps = connection.prepareStatement(sql);
		ps.setString(1, '%'+name+'%');
		ps.setString(2, '%'+name+'%');
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			CategoryDTO category = new CategoryDTO();
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
		
		String sql = "select code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category "
				   + "from category "
				   + "where 1depth_code like ? "
				   + "or 2depth_code like ? "
				   + "or concat(1depth_code, 2depth_code) = ? ";
		
		ps = connection.prepareStatement(sql);
		ps.setString(1, '%'+code+'%');
		ps.setString(2, '%'+code+'%');
		ps.setString(3, code);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			CategoryDTO category = new CategoryDTO();
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
	
	public int delete(String code) throws SQLException {
		String sql = "delete from category "
				   + "where code = ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, code);
		
		return ps.executeUpdate();
	}
	
	public int insert(CategoryCreationDTO category) throws SQLException {
		String sql = "insert into category (code, 1depth_code, 1depth_name, 2depth_code, 2depth_name, usage_category) "
				   + "value (?, ?, ?, ?, ?, ?)";
		
		ps = connection.prepareStatement(sql);
		ps.setString(1, category.getCategoryCode());
		ps.setString(2, category.getDepthCode1());
		ps.setString(3, category.getDepthName1());
		ps.setString(4, category.getDepthCode2());
		ps.setString(5, category.getDepthName2());
		ps.setString(6, category.getUsage());
		
		return ps.executeUpdate();
	}
	
	public List<Category1DepthCodeDTO> selectDepth1Code () throws SQLException{
		List<Category1DepthCodeDTO> depth1CodeList = new ArrayList<>();
		String sql = "select 1depth_code, 1depth_name from category group by 1depth_name";
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Category1DepthCodeDTO category = new Category1DepthCodeDTO();
			category.setDepth1Code(rs.getString("1depth_code"));
			category.setDepth1Name(rs.getString("1depth_name"));
			
			depth1CodeList.add(category);
		}
		return depth1CodeList;
	}
	
	public List<Category2DepthCodeDTO> selectDepth2Code (String depthCode) throws SQLException{
		List<Category2DepthCodeDTO> depth2CodeList = new ArrayList<>();
		String sql = "select code, 2depth_name from category where 1dpeth_code = ? ";
		this.ps = connection.prepareStatement(sql);
		this.ps.setString(1, depthCode);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Category2DepthCodeDTO category = new Category2DepthCodeDTO();
			category.setCategoryCode(rs.getString("code"));
			category.setDepth2Name(rs.getString("2depth_name"));
			
			depth2CodeList.add(category);
		}
		return depth2CodeList;
	}
}
