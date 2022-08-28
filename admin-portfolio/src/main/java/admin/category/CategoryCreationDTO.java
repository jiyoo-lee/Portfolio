package admin.category;

public class CategoryCreationDTO {
	private String depthCode1;
	private String depthName1;
	private String depthCode2;
	private String depthName2;
	private String usage;

	public CategoryCreationDTO() {
		super();
	}

	public CategoryCreationDTO(String depthCode1, String depthName1, String depthCode2, String depthName2,
			String usage) {
		super();
		this.depthCode1 = depthCode1;
		this.depthName1 = depthName1;
		this.depthCode2 = depthCode2;
		this.depthName2 = depthName2;
		this.usage = usage;
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
		return "CategoryCreationDTO [depthCode1=" + depthCode1 + ", depthName1=" + depthName1 + ", depthCode2="
				+ depthCode2 + ", depthName2=" + depthName2 + ", usage=" + usage + "]";
	}

}
