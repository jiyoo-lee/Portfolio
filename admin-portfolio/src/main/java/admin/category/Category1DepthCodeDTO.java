package admin.category;

public class Category1DepthCodeDTO {
	
	private String depth1Code;
	private String depth1Name;
	
	public Category1DepthCodeDTO() {
		super();
	}

	public Category1DepthCodeDTO(String depth1Code, String depth1Name) {
		super();
		this.depth1Code = depth1Code;
		this.depth1Name = depth1Name;
	}

	public String getDepth1Code() {
		return depth1Code;
	}

	public void setDepth1Code(String depth1Code) {
		this.depth1Code = depth1Code;
	}

	public String getDepth1Name() {
		return depth1Name;
	}

	public void setDepth1Name(String depth1Name) {
		this.depth1Name = depth1Name;
	}

	@Override
	public String toString() {
		return "Category1DepthCodeDTO [depth1Code=" + depth1Code + ", depth1Name=" + depth1Name + "]";
	}

}
