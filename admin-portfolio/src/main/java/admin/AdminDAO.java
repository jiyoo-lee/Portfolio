package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.exception.NoPermissionAdminException;
import admin.exception.UserNotFoundException;

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
		
		String SQL = "insert into admin_list values('0',?,?,?,?,?,?,?,'"+today+"','W')";
		this.ps = connection.prepareStatement(SQL);
		this.ps.setString(1, adminList.get(0));
		this.ps.setString(2, adminList.get(1));
		this.ps.setString(3, adminList.get(2));
		this.ps.setString(4, adminList.get(3));
		this.ps.setString(5, adminList.get(4));
		this.ps.setString(6, adminList.get(5));
		this.ps.setString(7, adminList.get(6));
		
		connection.close();
		return ps.executeUpdate();
	}
	
	public List<ApprovalJoinDTO> selectWaitingMembers(int sequence, int pageSize) throws SQLException{
		List<ApprovalJoinDTO> waitingMembers = new ArrayList<>();
		int startRow = (sequence-1) * pageSize;
		
		String sql = "select @rownum := @rownum+1 as row, a.name, a.admin_id, a.tel, a.email, a.department, a.position, a.indatetime "
				   + "from admin_list a, (select @rownum := 0) r "
				   + "where a.access = 'W' "
				   + "order by row desc "
				   + "limit ?, ?";
		this.ps = connection.prepareStatement(sql);
		this.ps.setInt(1, startRow);
		this.ps.setInt(2, pageSize);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ApprovalJoinDTO member = new ApprovalJoinDTO();
			member.setRow(Integer.parseInt(rs.getString("row")));
			member.setName(rs.getString("name"));
			member.setAdminId(rs.getString("admin_id"));
			member.setPhoneNumber(rs.getString("tel"));
			member.setEmail(rs.getString("email"));
			member.setDepartment(rs.getString("department"));
			member.setPosition(rs.getString("position"));
			member.setCreateDate(rs.getString("indatetime").substring(0, 10));
			
			waitingMembers.add(member);
		}
		
		connection.close();
		return waitingMembers;
	}
	
	public boolean selectOnlyId(String id) throws SQLException {
		
		String SQL = "select * from admin_list where admin_id = ?";
		this.ps= connection.prepareStatement(SQL);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		connection.close();
		return rs.next() ;
	}
	
	public String selectNameByIdAndPW(String id, String pw) throws SQLException {
		
		String SQL = "select name,access from admin_list where admin_id = ? and password = ?";
		this.ps = connection.prepareStatement(SQL);
		this.ps.setString(1, id);
		this.ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			if(rs.getString("access").intern() != "Y") {
				throw new NoPermissionAdminException();
			}
			else {
				return rs.getString("name");
			}
		}
		else {
			throw new UserNotFoundException();
		}			
	}
	
	public int loginHistory(String id) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		String SQL = "insert into login_log values('0','"+id+"','"+today+"')";
		this.ps = connection.prepareStatement(SQL);
		
		connection.close();
		return ps.executeUpdate();
	}
	
	public int countWaitingMembers() throws SQLException{
		String sql = "select count(*) as count "
				   + "from admin_list "
				   + "where access = 'W'";
		this.ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return rs.getInt("count");			
		}
		else {
			throw new SQLException();
		}
	}

	public int insertConfig(List<String>configList) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		String sql = "insert into environment values('0',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+today+"')";
		this.ps = connection.prepareStatement(sql);
		
		int w = 0;
		while(w<configList.size()) {
			this.ps.setString(w+1, configList.get(w));
			w++;
		}
		return ps.executeUpdate();
	}
	
	public int insertPaymentConfig(List<String>paymentList) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		String sql = "insert into payment_config values('0',?,?,?,?,?,?,?,?,?,?,?,'"+today+"')";
		this.ps = connection.prepareStatement(sql);
		
		int w = 0;
		while(w < paymentList.size()) {
			this.ps.setString(w+1, paymentList.get(w));
			w++;
		}
		return ps.executeUpdate();
	}
	
	public EnvironmentDTO loadEnvironmentInfo() throws SQLException{
		List<EnvironmentDTO> environmentInfoList = new ArrayList<>();
		String sql = "select * from environment order by id limit 0,1";
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String title = rs.getString("title");
			String managerEmail = rs.getString("managerEmail");
			String point = rs.getString("point");
			String defaultPoint = rs.getString("default_point");
			String level = rs.getString("level");
			String company = rs.getString("company");
			String registrationNumber = rs.getString("rg_number");
			String director = rs.getString("director");
			String directorNumber = rs.getString("director_number");
			String reportNumber = rs.getString("report_number");
			String valueNumber = rs.getString("value_number");
			String postalcode = rs.getString("postalcode");
			String companyAddr = rs.getString("company_addr");
			String infoManger = rs.getString("info_manager");
			String infoEmail = rs.getString("info_email");
			EnvironmentDTO environment = new EnvironmentDTO(title, managerEmail, defaultPoint, point, level, company, registrationNumber, directorNumber, director, reportNumber, valueNumber, postalcode, companyAddr, infoManger, infoEmail);
		}
		return null;
	}
	
	public List<PaymentConfigDTO> loadPaymentInfo() throws SQLException{
		List<PaymentConfigDTO> paymentInfoList = new ArrayList<>();
		String sql = "select * from payment_config";
		
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		return paymentInfoList;
	}
}
