package admin;

public class EnvironmentDTO {
	
	private String title;
	private String manager_email;
	private String point;
	private String default_point;
	private String level;
	private String company;
	private String rg_number;
	private String director;
	private String director_number;
	private String report_number;
	private String value_number;
	private String postalcode;
	private String company_addr;
	private String info_manager;
	private String info_email;
	
	
	public EnvironmentDTO () {
		
	}
	

	public EnvironmentDTO(String title, String manager_email, String point, String default_point, String level,
			String company, String rg_number, String director, String director_number, String report_number,
			String value_number, String postalcode, String company_addr, String info_manager, String info_email) {
		super();
		this.title = title;
		this.manager_email = manager_email;
		this.point = point;
		this.default_point = default_point;
		this.level = level;
		this.company = company;
		this.rg_number = rg_number;
		this.director = director;
		this.director_number = director_number;
		this.report_number = report_number;
		this.value_number = value_number;
		this.postalcode = postalcode;
		this.company_addr = company_addr;
		this.info_manager = info_manager;
		this.info_email = info_email;
	}



	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getManager_email() {
		return manager_email;
	}


	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}


	public String getPoint() {
		return point;
	}


	public void setPoint(String point) {
		this.point = point;
	}


	public String getDefault_point() {
		return default_point;
	}


	public void setDefault_point(String default_point) {
		this.default_point = default_point;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getRg_number() {
		return rg_number;
	}


	public void setRg_number(String rg_number) {
		this.rg_number = rg_number;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getDirector_number() {
		return director_number;
	}


	public void setDirector_number(String director_number) {
		this.director_number = director_number;
	}


	public String getReport_number() {
		return report_number;
	}


	public void setReport_number(String report_number) {
		this.report_number = report_number;
	}


	public String getValue_number() {
		return value_number;
	}


	public void setValue_number(String value_number) {
		this.value_number = value_number;
	}


	public String getPostalcode() {
		return postalcode;
	}


	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}


	public String getCompany_addr() {
		return company_addr;
	}


	public void setCompany_addr(String company_addr) {
		this.company_addr = company_addr;
	}


	public String getInfo_manager() {
		return info_manager;
	}


	public void setInfo_manager(String info_manager) {
		this.info_manager = info_manager;
	}


	public String getInfo_email() {
		return info_email;
	}


	public void setInfo_email(String info_email) {
		this.info_email = info_email;
	}
	
	
}