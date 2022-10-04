package admin.util;

public class AdminDTO {
	
	private long id;
	private String adminId;
	private String password;
	private String name;
	private String email;
	private String tel;
	private String department;
	private String position;
	private String indatetime;
	private String access;
	
	public AdminDTO() {

	}

	public AdminDTO(long id, String adminId, String password, String name, String email, String tel, String department,
			String position, String indatetime, String access) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.department = department;
		this.position = position;
		this.indatetime = indatetime;
		this.access = access;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getIndatetime() {
		return indatetime;
	}

	public void setIndatetime(String indatetime) {
		this.indatetime = indatetime;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", adminId=" + adminId + ", password=" + password + ", name=" + name + ", email="
				+ email + ", tel=" + tel + ", department=" + department + ", position=" + position + ", indatetime="
				+ indatetime + ", access=" + access + "]";
	}
	
	
}
