package admin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import admin.approval.ApprovalJoinDTO;
import admin.configuration.HomepageConfigDTO;
import admin.configuration.PaymentConfigDTO;
import admin.exception.NoConfigurationException;
import admin.exception.NoPermissionAdminException;
import admin.exception.UserNotFoundException;
import admin.notice.NoticeDTO;

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
		
		return ps.executeUpdate();
	}
	
	public List<ApprovalJoinDTO> selectWaitingMembers(int sequence, int pageSize) throws SQLException{
		List<ApprovalJoinDTO> waitingMembers = new ArrayList<>();
		int startRow = (sequence-1) * pageSize;
		
		String sql = "select @rownum := @rownum+1 as row, a.id, a.name, a.admin_id, a.tel, a.email, a.department, a.position, a.indatetime "
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
			
			member.setId(Integer.parseInt(rs.getString("id")));
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
		
		return waitingMembers;
	}
	
	public boolean selectOnlyId(String id) throws SQLException {
		
		String SQL = "select * from admin_list where admin_id = ?";
		this.ps= connection.prepareStatement(SQL);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
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

	public int insertHomepageConfig( Map<String, String> homepageParam, String[] homepageFields) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		
		String sql = "insert into homepage_configuration values ('0',?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+today+"')";
		this.ps = connection.prepareStatement(sql);
		
		int w = 0;
		while(w < homepageFields.length) {
			this.ps.setString(w+1, homepageParam.get(homepageFields[w]));
			w++;
		}
		return this.ps.executeUpdate();
	}
	
	public int insertPaymentConfig(Map<String, String> paymentParam, String[] paymentFields) throws SQLException{
		
		GetDatetiemUtil datetime = new GetDatetiemUtil();
		String today = datetime.getNowDatetime();
		String sql = "insert into payment_configuration values('0',?,?,?,?,?,?,?,?,?,?,?,?,'"+today+"')";
		this.ps = connection.prepareStatement(sql);
		
		int w = 0;
		while(w < paymentFields.length) {
			this.ps.setString(w+1, paymentParam.get(paymentFields[w]));
			w++;
		}
		return ps.executeUpdate();
	}
	
	public HomepageConfigDTO selectHomepageConfig() throws SQLException{
		String sql = "select * "
			       + "from homepage_configuration "
			       + "order by id desc "
			       + "limit 0, 1";
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			HomepageConfigDTO homepageConfig = new HomepageConfigDTO();
			homepageConfig.setId(rs.getLong("id"));
			homepageConfig.setTitle(rs.getString("title"));
			homepageConfig.setManagerEmail(rs.getString("manager_email"));
			homepageConfig.setCompanyName(rs.getString("company_name"));
			homepageConfig.setCompanyRegistrationNumber(rs.getString("company_registration_number"));
			homepageConfig.setDirectorName(rs.getString("director_name"));
			homepageConfig.setMainNumber(rs.getString("main_number"));
			homepageConfig.setTelemarketingReportNumber(rs.getString("telemarketing_report_number"));
			homepageConfig.setSupplementaryNumber(rs.getString("supplementary_number"));
			homepageConfig.setBusinessZipCode(rs.getString("business_zip_code"));
			homepageConfig.setBusinessAddress(rs.getString("business_address"));
			homepageConfig.setInfoManagerName(rs.getString("info_manager_name"));
			homepageConfig.setInfoManagerEmail(rs.getString("info_manager_email"));
			homepageConfig.setMembershipReserves(rs.getInt("membership_reserves"));
			homepageConfig.setMembershipLevel(rs.getString("membership_level"));
			homepageConfig.setCreateDatetime(rs.getString("create_datetime"));
			
			return homepageConfig;
		} else {
			throw new NoConfigurationException();
		}
	}
	
	public PaymentConfigDTO selectPaymentConfig() throws SQLException{
		String sql = "select * "
			       + "from payment_configuration "
			       + "order by id desc "
			       + "limit 0, 1";
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
				
		if(rs.next()) {
			PaymentConfigDTO paymentConfig = new PaymentConfigDTO();
			paymentConfig.setId(rs.getLong("id"));
			paymentConfig.setBankName(rs.getString("bank_name"));
			paymentConfig.setAccountNumber(rs.getString("account_number"));
			paymentConfig.setCreditUsage(rs.getString("credit_usage"));
			paymentConfig.setMobileUsage(rs.getString("mobile_usage"));
			paymentConfig.setVoucherUsage(rs.getString("voucher_usage"));
			paymentConfig.setPointUsage(rs.getString("point_usage"));
			paymentConfig.setMinUsagePoint(rs.getInt("min_usage_point"));
			paymentConfig.setMaxUsagePoint(rs.getInt("max_usage_point"));
			paymentConfig.setCashReceiptUsage(rs.getString("cash_receipt_usage"));
			paymentConfig.setShippingCompanyName(rs.getString("shipping_company_name"));
			paymentConfig.setShippingCost(rs.getInt("shipping_cost"));
			paymentConfig.setDeliveryDateUsage(rs.getString("delivery_date_usage"));
			paymentConfig.setCreateDatetime(rs.getString("create_datetime"));
			
			return paymentConfig;
		} else {
			throw new NoConfigurationException();
		}
	}
	
	public Integer countNotices() throws SQLException {
		String sql  = "select count(*) as count "
				    + "from notice";
		this.ps = connection.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		return rs.next() ? rs.getInt("count") : 0;
	}
	
	public List<NoticeDTO> selectNotices() throws SQLException{
		List<NoticeDTO> notices = new ArrayList<>();

		String sql = "select id, title, writer, create_datetime, views "
				   + "from notice "
				   + "order by id desc";
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		rs.last();
		int rowNum = rs.getRow();
		rs.beforeFirst();
		
		while(rs.next()) {
			NoticeDTO notice = new NoticeDTO();
			notice.setId(rs.getLong("id"));
			notice.setTitle(rs.getString("title"));
			notice.setWriter(rs.getString("writer"));
			notice.setCreateDatetime(rs.getString("create_datetime"));
			notice.setViews(rs.getInt("views"));
			notice.setRow(rowNum--);
			
			notices.add(notice);
		}
		return notices;
	}
	
	public int insertNotices(List<String>noticeRegistration) throws SQLException {
		String sql = "insert into notice(title, writer, top_exposure, content, attachments) "
				   + "values(?, ?, ?, ?, ?)";
		this.ps = connection.prepareStatement(sql);
		
		int w = 0;
		while(w < noticeRegistration.size()) {
			this.ps.setString(w+1, noticeRegistration.get(w++));
		}
		return this.ps.executeUpdate();
	}
	
	public int deleteNotices(String[] index) throws SQLException{
		String questionMarks = "";
		for(int i = 0; i < index.length-1; i++) {
			questionMarks += "?,";
		}
		questionMarks += "?";
		
		String sql = "delete from notice where id in ("+questionMarks+")";
		try{
			this.ps = connection.prepareStatement(sql);
			int seq = 0;
			while(seq < index.length) {
				this.ps.setString(seq+1, index[seq]);
				seq++;
			}		
			return ps.executeUpdate();
		}finally {
			if(this.ps != null )this.ps.close();
			if(this.connection != null )this.connection.close();
		}
		
	}
	public int updateAccess(String id, String access)throws SQLException{
		
		String sql = "update admin_list set access = ? where id = ?";
		this.ps = connection.prepareStatement(sql);
		this.ps.setString(1, access);
		this.ps.setString(2, id);
		
		return this.ps.executeUpdate();
	}
	
	public List<NoticeDTO> selectNoticeDetail(String id) throws SQLException{
		List<NoticeDTO> notice = new ArrayList<>();
		
		String sql = "select * from notice where id = "+ id;
		this.ps = connection.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		
		rs.last();
		int rowNum = rs.getRow();
		rs.beforeFirst();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			
			noticeDTO.setId(rs.getLong("id"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setTopExposure(rs.getString("top_exposure"));
			noticeDTO.setContent(rs.getString("content"));
			noticeDTO.setAttachments(rs.getString("attachments"));
			noticeDTO.setCreateDatetime(rs.getString("create_datetime"));
			noticeDTO.setRow(rowNum--);
			notice.add(noticeDTO);
		}
		return notice;
	}
	
	public List<AdminDTO> selectAdminInfo(){
		
		List<AdminDTO> admins = new ArrayList<AdminDTO>();
		
		String sql = "select * from admin_list where ";
		
		
		return admins;
	}
}

