package admin.category;

public class CategoryDTO {
	private Long id;
	private String code;
	private String depthCode1;
	private String depthName1;
	private String depthCode2;
	private String depthName2;
	private String usage;
	
	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Long id, String code, String depthCode1, String depthName1, String depthCode2, String depthName2,
			String usage) {
		super();
		this.id = id;
		this.code = code;
		this.depthCode1 = depthCode1;
		this.depthName1 = depthName1;
		this.depthCode2 = depthCode2;
		this.depthName2 = depthName2;
		this.usage = usage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDepthCode1() {
		return depthCode1;
	}

	public void setDepthCode1(String depthCode1) {
		this.depthCode1 = depthCode1;
	}

	public String getDepthName1() {
		return depthName1;
	}

	public void setDepthName1(String depthName1) {
		this.depthName1 = depthName1;
	}

	public String getDepthCode2() {
		return depthCode2;
	}

	public void setDepthCode2(String depthCode2) {
		this.depthCode2 = depthCode2;
	}

	public String getDepthName2() {
		return depthName2;
	}

	public void setDepthName2(String depthName2) {
		this.depthName2 = depthName2;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", code=" + code + ", depthCode1=" + depthCode1 + ", depthName1=" + depthName1
				+ ", depthCode2=" + depthCode2 + ", depthName2=" + depthName2 + ", usage=" + usage + "]";
	}
	
}
