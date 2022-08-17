package admin;

import java.time.LocalDate;

public class ApprovalJoinDTO {
	
	private Integer row;
	
	private String name;
	
	private String adminId;

	private String phoneNumber;
	
	private String email;
	
	private String department;
	
	private String position;
	
	private String createDate;

	public ApprovalJoinDTO() {
	}

	public ApprovalJoinDTO(Integer row, String name, String adminId, String phoneNumber, String email,
			String department, String position, String createDate) {
		super();
		this.row = row;
		this.name = name;
		this.adminId = adminId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}