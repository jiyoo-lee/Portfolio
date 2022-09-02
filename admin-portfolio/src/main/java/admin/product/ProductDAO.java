package admin.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.category.CategoryDTO;
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
	
	public int insertProductInfo (ProductDTO productDTO) throws SQLException {
		
		String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, productDTO.getCategoryCode());
		ps.setString(2, productDTO.getCode());
		ps.setString(3, productDTO.getName());
		ps.setString(4, productDTO.getSub_desc());
		ps.setString(5, productDTO.getPrice());
		ps.setString(6, productDTO.getDiscount());
		ps.setString(7, productDTO.getDiscountPrice());
		ps.setString(8, productDTO.getStock());
		ps.setString(9, productDTO.getUsageSale());
		ps.setString(10, productDTO.getEarlySoldout());
		ps.setString(11, productDTO.getDetailDesc());
		
		return ps.executeUpdate();
	}
	
	public int insertImageInfo (ProductImageDTO imageDTO) throws SQLException {
		
		String sql = "insert into product_image(product_code, image_path, image_name) values (?,?,?)";
		ps = connection.prepareStatement(sql);
		ps.setString(1, imageDTO.getProductCode());
		ps.setString(2, imageDTO.getImagePath());
		ps.setString(3, imageDTO.getImageName());
		
		return ps.executeUpdate();
	}
	
	public List<ProductDTO> selectAllProductsInfo() throws SQLException{
		
		List<ProductDTO> products = new ArrayList<>();
		
		String sql = "select * from product";
		
		ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductDTO product = new ProductDTO();
			product.setCategoryCode(rs.getString("category_code"));
			product.setCode(rs.getString("code"));
			product.setName(rs.getString("name"));
			product.setSub_desc(rs.getString("sub_desc"));
			product.setPrice(rs.getString("price"));
			product.setDiscount(rs.getString("discount"));
			product.setDiscountPrice(rs.getString("discount_price"));
			product.setStock(rs.getString("stock"));
			product.setUsageSale(rs.getString("usage_sale"));
			product.setEarlySoldout(rs.getString("early_sold_out"));
			product.setDetailDesc(rs.getString("detail_desc"));
			
			products.add(product);
		}
		return products;
	}
	
	public List<ProductDTO> selectByName(String name) throws SQLException {
		
		List<ProductDTO> products = new ArrayList<>();
		String sql = "select * from product where name like ? ";
		ps = connection.prepareStatement(sql);
		ps.setString(1, '%'+name+'%');
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductDTO product = new ProductDTO();
			product.setCategoryCode(rs.getString("category_code"));
			product.setCode(rs.getString("code"));
			product.setName(rs.getString("name"));
			product.setSub_desc(rs.getString("sub_desc"));
			product.setPrice(rs.getString("price"));
			product.setDiscount(rs.getString("discount"));
			product.setDiscountPrice(rs.getString("discount_price"));
			product.setStock(rs.getString("stock"));
			product.setUsageSale(rs.getString("usage_sale"));
			product.setEarlySoldout(rs.getString("early_sold_out"));
			product.setDetailDesc(rs.getString("detail_desc"));
			
			products.add(product);
		}
		
		return products;
	}
	
	public List<ProductDTO> selectByCode(String code) throws SQLException {
		
		List<ProductDTO> products = new ArrayList<>();
		String sql = "select * from product where code like ?";
		ps = connection.prepareStatement(sql);
		ps.setString(1, '%'+code+'%');
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ProductDTO product = new ProductDTO();
			product.setCategoryCode(rs.getString("category_code"));
			product.setCode(rs.getString("code"));
			product.setName(rs.getString("name"));
			product.setSub_desc(rs.getString("sub_desc"));
			product.setPrice(rs.getString("price"));
			product.setDiscount(rs.getString("discount"));
			product.setDiscountPrice(rs.getString("discount_price"));
			product.setStock(rs.getString("stock"));
			product.setUsageSale(rs.getString("usage_sale"));
			product.setEarlySoldout(rs.getString("early_sold_out"));
			product.setDetailDesc(rs.getString("detail_desc"));
			
			products.add(product);
		}
		return products;
	}
	public int deleteProducts(String[] codes) throws SQLException{
		
		String questionMarks = "";
		for(int i =0; i < codes.length-1; i++) {
			questionMarks += "?,";
		}
		questionMarks += "?";
		
		String sql = "delete from product where code in ("+questionMarks+")";
		
		try {
			ps = connection.prepareStatement(sql);
			int seq = 0;
			while (seq < codes.length) {
				ps.setString(seq+1, codes[seq]);
				seq++;
			}
			return ps.executeUpdate();
		}finally {
			if(ps != null) ps.close();
			if(connection != null) connection.close();
		}
	}
}

