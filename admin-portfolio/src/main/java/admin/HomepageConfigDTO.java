package admin;


public class HomepageConfigDTO {
	private Long id;
	private String title;
	private String managerEmail;
	private String companyName;
	private String companyRegistrationNumber;
	private String directorName;
	private String mainNumber;
	private String telemarketingReportNumber;
	private String supplementaryNumber;
	private String businessZipCode;
	private String businessAddress;
	private String infoManagerName;
	private String infoManagerEmail;
	private Integer membershipReserves;
	private String membershipLevel;
	private String createDatetime;
	
	public HomepageConfigDTO() {
		super();
	}

	public HomepageConfigDTO(Long id, String title, String managerEmail, String companyName,
			String companyRegistrationNumber, String directorName, String mainNumber, String telemarketingReportNumber,
			String supplementaryNumber, String businessZipCode, String businessAddress, String infoManagerName,
			String infoManagerEmail, Integer membershipReserves, String membershipLevel, String createDatetime) {
		super();
		this.id = id;
		this.title = title;
		this.managerEmail = managerEmail;
		this.companyName = companyName;
		this.companyRegistrationNumber = companyRegistrationNumber;
		this.directorName = directorName;
		this.mainNumber = mainNumber;
		this.telemarketingReportNumber = telemarketingReportNumber;
		this.supplementaryNumber = supplementaryNumber;
		this.businessZipCode = businessZipCode;
		this.businessAddress = businessAddress;
		this.infoManagerName = infoManagerName;
		this.infoManagerEmail = infoManagerEmail;
		this.membershipReserves = membershipReserves;
		this.membershipLevel = membershipLevel;
		this.createDatetime = createDatetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyRegistrationNumber() {
		return companyRegistrationNumber;
	}

	public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
		this.companyRegistrationNumber = companyRegistrationNumber;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getMainNumber() {
		return mainNumber;
	}

	public void setMainNumber(String mainNumber) {
		this.mainNumber = mainNumber;
	}

	public String getTelemarketingReportNumber() {
		return telemarketingReportNumber;
	}

	public void setTelemarketingReportNumber(String telemarketingReportNumber) {
		this.telemarketingReportNumber = telemarketingReportNumber;
	}

	public String getSupplementaryNumber() {
		return supplementaryNumber;
	}

	public void setSupplementaryNumber(String supplementaryNumber) {
		this.supplementaryNumber = supplementaryNumber;
	}

	public String getBusinessZipCode() {
		return businessZipCode;
	}

	public void setBusinessZipCode(String businessZipCode) {
		this.businessZipCode = businessZipCode;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getInfoManagerName() {
		return infoManagerName;
	}

	public void setInfoManagerName(String infoManagerName) {
		this.infoManagerName = infoManagerName;
	}

	public String getInfoManagerEmail() {
		return infoManagerEmail;
	}

	public void setInfoManagerEmail(String infoManagerEmail) {
		this.infoManagerEmail = infoManagerEmail;
	}

	public Integer getMembershipReserves() {
		return membershipReserves;
	}

	public void setMembershipReserves(Integer membershipReserves) {
		this.membershipReserves = membershipReserves;
	}

	public String getMembershipLevel() {
		return membershipLevel;
	}

	public void setMembershipLevel(String membershipLevel) {
		this.membershipLevel = membershipLevel;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	@Override
	public String toString() {
		return "HomepageConfigDTO [id=" + id + ", title=" + title + ", managerEmail=" + managerEmail + ", companyName="
				+ companyName + ", companyRegistrationNumber=" + companyRegistrationNumber + ", directorName="
				+ directorName + ", mainNumber=" + mainNumber + ", telemarketingReportNumber="
				+ telemarketingReportNumber + ", supplementaryNumber=" + supplementaryNumber + ", businessZipCode="
				+ businessZipCode + ", businessAddress=" + businessAddress + ", infoManagerName=" + infoManagerName
				+ ", infoManagerEmail=" + infoManagerEmail + ", membershipReserves=" + membershipReserves
				+ ", membershipLevel=" + membershipLevel + ", createDatetime=" + createDatetime + "]";
	}
}