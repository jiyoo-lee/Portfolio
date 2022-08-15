package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {
	
	Connection connection;
	PreparedStatement ps = null;
	
	public AdminDAO() throws ClassNotFoundException, SQLException{
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://umj7-009.cafe24.com/jeeyulee";
		String user ="jeeyulee";
		String password = "jeeyu9400";
		
		Class.forName(driver);
		this.connection = DriverManager.getConnection(url,user,password);
	}
	
	public int insert(ArrayList<String> adminList) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		
		String SQL = "insert into admin_list values('0',?,?,?,?,?,?,?,'"+today+"','N')";
		this.ps = connection.prepareStatement(SQL);
		this.ps.setString(1, adminList.get(0));
		this.ps.setString(2, adminList.get(1));
		this.ps.setString(3, adminList.get(2));
		this.ps.setString(4, adminList.get(3));
		this.ps.setString(5, adminList.get(4));
		this.ps.setString(6, adminList.get(5));
		this.ps.setString(7, adminList.get(6));
		
		return ps.executeUpdate();
	}
	
	public boolean selectOnlyId(String id) throws SQLException {
		
		String SQL = "select * from admin_list where admin_id ='"+id+"'";
		this.ps= connection.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		
		return rs.next() ;
	}
	
	public boolean selectIdAndPW (String id, String pw) throws SQLException {
		
		String SQL = "select * from admin_list where admin_id = '"+id+"' and password= '"+pw+"'";
		this.ps = connection.prepareStatement(SQL);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}
	public int loginHistory(String id) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		String SQL = "insert into login_log values('0','"+id+"','"+today+"')";
		this.ps = connection.prepareStatement(SQL);
		
		return ps.executeUpdate();
	}

}
